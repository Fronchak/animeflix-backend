package com.fronchak.animeflix.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fronchak.animeflix.dtos.category.CategoryInsertDTO;
import com.fronchak.animeflix.dtos.category.CategoryNameOutputDTO;
import com.fronchak.animeflix.dtos.category.CategoryOutputDTO;
import com.fronchak.animeflix.dtos.category.CategoryUpdateDTO;
import com.fronchak.animeflix.entities.Category;
import com.fronchak.animeflix.exceptions.DatabaseException;
import com.fronchak.animeflix.exceptions.ResourceNotFoundException;
import com.fronchak.animeflix.mappers.CategoryMapper;
import com.fronchak.animeflix.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	@Autowired
	private CategoryMapper mapper;
	
	@Transactional
	public CategoryOutputDTO save(CategoryInsertDTO dto) {
		Category entity = new Category();
		mapper.copyCategoryInputDTOTOCategoryEntity(dto, entity);
		entity = repository.save(entity);
		return mapper.convertCategoryEntityToCategoryOutputDTO(entity);
	}
	
	@Transactional
	public CategoryOutputDTO update(CategoryUpdateDTO dto, Long id) {
		try {
			Category entity = repository.getReferenceById(id);
			mapper.copyCategoryInputDTOTOCategoryEntity(dto, entity);
			entity = repository.save(entity);
			return mapper.convertCategoryEntityToCategoryOutputDTO(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Category", id.toString());
		}
	}
	
	@Transactional(readOnly = true)
	public CategoryOutputDTO findById(Long id) {
		Category entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category", id.toString()));
		return mapper.convertCategoryEntityToCategoryOutputDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public List<CategoryOutputDTO> findAll(String filter) {
		List<Category> list = repository.findAll(filter);
		return mapper.convertCategoryEntityListToCategoryOutputDTOList(list);
	}
	
	@Transactional(readOnly = true)
	public List<CategoryNameOutputDTO> findAllNames() {
		List<Category> list = repository.findAll();
		return mapper.convertCategoryEntityListToCategoryNameOutputDTOList(list);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Category", id.toString());
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException("You can't delete a category that has any anime");
		}
	}
}
