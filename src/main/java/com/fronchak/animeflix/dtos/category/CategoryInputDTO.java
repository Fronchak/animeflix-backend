package com.fronchak.animeflix.dtos.category;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class CategoryInputDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "Category's name cannot be empty")
	private String name;
	
	@NotBlank(message = "Category's description cannot be empty")
	private String description;
	
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
