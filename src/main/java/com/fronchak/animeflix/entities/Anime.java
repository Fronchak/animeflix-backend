package com.fronchak.animeflix.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "anime")
public class Anime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@Column(columnDefinition = "TEXT")
	private String synopsis;
	
	@Column(name = "lauch_year")
	private Integer lauchYear;
	private Double avaliation;
	@Column(name = "img_url", columnDefinition = "TEXT")
	private String imgUrl;
	
	@ManyToMany
	@JoinTable(name = "anime_category",
			joinColumns = @JoinColumn(name = "id_anime"),
			inverseJoinColumns = @JoinColumn(name = "id_category"))
	private Set<Category> categories = new HashSet<>();
	
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
	
	public Set<Category> getCategories() {
		return categories;
	}
	
	public void addCategory(Category category) {
		categories.add(category);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Anime other = (Anime) obj;
		return Objects.equals(id, other.id);
	}
}
