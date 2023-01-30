package com.fronchak.animeflix.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fronchak.animeflix.dtos.anime.AnimeInputDTO;
import com.fronchak.animeflix.dtos.anime.AnimeInsertDTO;
import com.fronchak.animeflix.dtos.anime.AnimeOutputAllDTO;
import com.fronchak.animeflix.dtos.anime.AnimeOutputDTO;
import com.fronchak.animeflix.dtos.anime.AnimeUpdateDTO;
import com.fronchak.animeflix.entities.Anime;
import com.fronchak.animeflix.entities.Category;
import com.fronchak.animeflix.exceptions.DatabaseException;
import com.fronchak.animeflix.exceptions.ResourceNotFoundException;
import com.fronchak.animeflix.mappers.AnimeMapper;
import com.fronchak.animeflix.repositories.AnimeRepository;
import com.fronchak.animeflix.repositories.CategoryRepository;

@Service
public class AnimeService {

	@Autowired
	private AnimeRepository repository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private AnimeMapper mapper;
	
	@Transactional
	public AnimeOutputDTO save(AnimeInsertDTO dto) {
		Anime entity = new Anime();
		copyDTOToEntity(dto, entity);
		entity = repository.save(entity);
		return mapper.convertAnimeEntityToAnimeOutputDTO(entity);
	}
	
	private void copyDTOToEntity(AnimeInputDTO dto, Anime entity) {
		mapper.copyAnimeInputDTOToAnimeEntity(dto, entity);
		entity.getCategories().clear();
		dto.getCategories().forEach((categoryId) -> entity.addCategory(categoryRepository.getReferenceById(categoryId)));
	}
	
	@Transactional
	public AnimeOutputDTO update(AnimeUpdateDTO dto, Long id) {
		try {
			Anime entity = repository.getReferenceById(id);
			copyDTOToEntity(dto, entity);
			entity = repository.save(entity);
			return mapper.convertAnimeEntityToAnimeOutputDTO(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Error trying to update anime: " + e.getMessage());
		}
	}
	
	@Transactional(readOnly = true)
	public AnimeOutputDTO findById(Long id) {
		Anime entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Anime", id.toString()));
		return mapper.convertAnimeEntityToAnimeOutputDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public Page<AnimeOutputAllDTO> findPaged(String filter, Long categoryID, Pageable pageable) {
		Category category = categoryID.equals(0L) ? null : categoryRepository.getReferenceById(categoryID);
		Page<Anime> page = repository.findPaged(filter, category, pageable);
		repository.findAnimeWithCategories(page.getContent());
		return mapper.convertAnimeEntityPageToAnimeOutputAllDTOPage(page);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Anime", id.toString());
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Error trying to delete anime: " + e.getMessage());
		}
	}
}
