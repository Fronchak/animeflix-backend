package com.fronchak.animeflix.dtos.anime;

import java.io.Serializable;

import com.fronchak.animeflix.entities.Anime;

public class AnimeOutputAllDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Double avaliation;
	private String imgUrl;
	
	public AnimeOutputAllDTO() {}
	
	public AnimeOutputAllDTO(Long id, String name, Double avaliation, String imgUrl) {
		this.id = id;
		this.name = name;
		this.avaliation = avaliation;
		this.imgUrl = imgUrl;
	}
	
	public AnimeOutputAllDTO(Anime anime) {
		this(anime.getId(), anime.getName(), anime.getAvaliation(), anime.getImgUrl());
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
}
