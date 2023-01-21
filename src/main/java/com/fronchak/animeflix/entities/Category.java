package com.fronchak.animeflix.entities;

import java.util.HashSet;
import java.util.Set;

public class Category {

	private Long id;
	private String name;
	private String description;
	
	private Set<Anime> animes = new HashSet<>();
}
