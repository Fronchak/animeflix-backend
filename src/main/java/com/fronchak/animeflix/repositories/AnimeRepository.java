package com.fronchak.animeflix.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fronchak.animeflix.entities.Anime;
import com.fronchak.animeflix.entities.Category;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {

	@Query("SELECT DISTINCT obj FROM Anime obj INNER JOIN obj.categories cats WHERE " +
			"(:category IS NULL OR :category IN cats) AND " +
			"(" +
				"UPPER(obj.name) LIKE UPPER(CONCAT('%', :filter, '%')) OR " +
				"UPPER(obj.synopsis) LIKE UPPER( CONCAT('%', :filter, '%') ) " +
			")")
	Page<Anime> findPaged(String filter, Category category, Pageable pageable);
	
	@Query("SELECT obj FROM Anime obj JOIN FETCH obj.categories WHERE obj IN :animes")
	List<Anime> findAnimeWithCategories(List<Anime> animes);
}
