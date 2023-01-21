package com.fronchak.animeflix.dtos.category;

import java.io.Serializable;

import com.fronchak.animeflix.entities.Category;

public class CategoryOutputDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String description;
	
	public CategoryOutputDTO() {}
	
	public CategoryOutputDTO(Long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public CategoryOutputDTO(Category entity) {
		this(entity.getId(), entity.getName(), entity.getDescription());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
