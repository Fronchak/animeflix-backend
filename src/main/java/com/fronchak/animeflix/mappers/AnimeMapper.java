package com.fronchak.animeflix.mappers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.fronchak.animeflix.dtos.anime.AnimeInputDTO;
import com.fronchak.animeflix.dtos.anime.AnimeOutputAllDTO;
import com.fronchak.animeflix.dtos.anime.AnimeOutputDTO;
import com.fronchak.animeflix.dtos.category.CategoryNameOutputDTO;
import com.fronchak.animeflix.entities.Anime;

@Service
public class AnimeMapper {

	@Autowired
	private CategoryMapper categoryMapper;
	
	public Page<AnimeOutputAllDTO> convertAnimeEntityPageToAnimeOutputAllDTOPage(Page<Anime> page) {
		return page.map((entity) -> convertAnimeEntityToAnimeOutputAllDTO(entity));
	}
	
	private AnimeOutputAllDTO convertAnimeEntityToAnimeOutputAllDTO(Anime entity) {
		return new AnimeOutputAllDTO(entity);
	}
	
	public AnimeOutputDTO convertAnimeEntityToAnimeOutputDTO(Anime entity) {
		AnimeOutputDTO dto = new AnimeOutputDTO(entity);
		Set<CategoryNameOutputDTO> categories = categoryMapper.convertCategoryEntitySetToCategoryNameOutputDTOSet(entity.getCategories());
		categories.forEach(category -> dto.addCategory(category));
		return dto;
	}
	
	public void copyAnimeInputDTOToAnimeEntity(AnimeInputDTO dto, Anime entity) {
		entity.setName(dto.getName());
		entity.setSynopsis(dto.getSynopsis());
		entity.setAvaliation(dto.getAvaliation());
		entity.setLauchYear(dto.getLauchYear());
		entity.setImgUrl(dto.getImgUrl());
	}
}
