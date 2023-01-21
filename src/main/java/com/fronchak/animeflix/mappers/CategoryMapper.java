package com.fronchak.animeflix.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fronchak.animeflix.dtos.category.CategoryInputDTO;
import com.fronchak.animeflix.dtos.category.CategoryNameOutputDTO;
import com.fronchak.animeflix.dtos.category.CategoryOutputDTO;
import com.fronchak.animeflix.entities.Category;

@Service
public class CategoryMapper {

	public CategoryOutputDTO convertCategoryEntityToCategoryOutputDTO(Category entity) {
		return new CategoryOutputDTO(entity);
	}
	
	public List<CategoryOutputDTO> convertCategoryEntityListToCategoryOutputDTOList(List<Category> list) {
		return list.stream()
				.map((entity) -> convertCategoryEntityToCategoryOutputDTO(entity))
				.collect(Collectors.toList());
	}
	
	public List<CategoryNameOutputDTO> convertCategoryEntityListToCategoryNameOutputDTOList(List<Category> list) {
		return list.stream()
				.map((entity) -> new CategoryNameOutputDTO(entity))
				.collect(Collectors.toList());
	}
	
	public void copyCategoryInputDTOTOCategoryEntity(CategoryInputDTO dto, Category entity) {
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
	}
}
