package com.fronchak.animeflix.dtos.anime;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class AnimeInputDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String synopsis;
	private Integer lauchYear;
	private Double avaliation;
	private String imgUrl;
	private Set<Long> categories = new HashSet<>();
	
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
