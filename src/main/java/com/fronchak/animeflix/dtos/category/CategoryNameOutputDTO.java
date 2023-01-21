package com.fronchak.animeflix.dtos.category;

import java.io.Serializable;

import com.fronchak.animeflix.entities.Category;

public class CategoryNameOutputDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	public CategoryNameOutputDTO() {}
	
	public CategoryNameOutputDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public CategoryNameOutputDTO(Category entity) {
		this(entity.getId(), entity.getName());
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
}
