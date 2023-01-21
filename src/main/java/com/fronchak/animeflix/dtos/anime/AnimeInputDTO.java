package com.fronchak.animeflix.dtos.anime;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AnimeInputDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "Anime's name cannot be empty")
	private String name;
	
	@NotBlank(message = "Anime's synopsis cannot be empty")
	private String synopsis;
	
	@NotNull(message = "Anime's lauch year must be specified")
	@Max(value = 2023, message = "Anime's lauch year cannot be greater than 2023")
	@Min(value = 1980, message = "Anime's lauch year cannot be lower than 1980")
	private Integer lauchYear;
	
	@NotNull(message = "Anime's avaliation must be specified")
	@Min(value = 0, message = "Anime's avaliation cannot be lower than 0")
	@Max(value = 10, message = "Anime's avaliation cannot be greater than 10")
	private Double avaliation;
	
	@NotNull(message = "Anime's image must be specified")
	private String imgUrl;
	
	@NotNull(message = "Anime's categories must be specified")
	@NotEmpty(message = "Anime's categories cannot be emtpy, you must choose at least one category")
	private Set<@NotNull(message = "Category id cannot be null") Long> categories = new HashSet<>();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSynopsis() {
		return synopsis;
	}
	
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	
	public Integer getLauchYear() {
		return lauchYear;
	}
	
	public void setLauchYear(Integer lauchYear) {
		this.lauchYear = lauchYear;
	}
	
	public Double getAvaliation() {
		return avaliation;
	}
	
	public void setAvaliation(Double avaliation) {
		this.avaliation = avaliation;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}
	
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public Set<Long> getCategories() {
		return categories;
	}
}
