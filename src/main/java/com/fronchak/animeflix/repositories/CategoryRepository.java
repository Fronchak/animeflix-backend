package com.fronchak.animeflix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fronchak.animeflix.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	Category findByNameIgnoreCase(String name);
	
	@Query("SELECT obj FROM Category obj WHERE " +
			"UPPER(obj.name) LIKE UPPER( CONCAT('%', :filter, '%') ) OR " + 
			"UPPER(obj.description) LIKE UPPER( CONCAT('%', :filter, '%') )")
	List<Category> findAll(String filter);
}
