package com.fronchak.animeflix.dtos.anime;

import java.util.HashSet;
import java.util.Set;

import com.fronchak.animeflix.dtos.category.CategoryNameOutputDTO;
import com.fronchak.animeflix.entities.Anime;

public class AnimeOutputDTO extends AnimeOutputAllDTO {

	private static final long serialVersionUID = 1L;

	private String synopsis;
	private Integer lauchYear;
	
	public AnimeOutputDTO() {
		super();
	}
	
	public AnimeOutputDTO(Long id, String name, Double avaliation, String imgUrl, String synopsis, Integer lauchYear) {
		super(id, name, avaliation, imgUrl);
		this.synopsis = synopsis;
		this.lauchYear = lauchYear;
	}

	public AnimeOutputDTO(Anime anime) {
		super(anime);
		this.synopsis = anime.getSynopsis();
		this.lauchYear = anime.getLauchYear();
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
}
