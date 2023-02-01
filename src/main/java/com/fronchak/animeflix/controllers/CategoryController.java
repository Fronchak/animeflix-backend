package com.fronchak.animeflix.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fronchak.animeflix.dtos.category.CategoryInsertDTO;
import com.fronchak.animeflix.dtos.category.CategoryNameOutputDTO;
import com.fronchak.animeflix.dtos.category.CategoryOutputDTO;
import com.fronchak.animeflix.dtos.category.CategoryUpdateDTO;
import com.fronchak.animeflix.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

	@Autowired
	private CategoryService service;
	
	@PostMapping
	public ResponseEntity<CategoryOutputDTO> save(@Valid @RequestBody CategoryInsertDTO insertDTO) {
		CategoryOutputDTO outputDTO = service.save(insertDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(outputDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(outputDTO);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoryOutputDTO> update(@Valid @RequestBody CategoryUpdateDTO updateDTO, @PathVariable Long id) {
		CategoryOutputDTO outputDTO = service.update(updateDTO, id);
		return ResponseEntity.ok().body(outputDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoryOutputDTO> findById(@PathVariable Long id) {
		CategoryOutputDTO outputDTO = service.findById(id);
		return ResponseEntity.ok().body(outputDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<CategoryOutputDTO>> findAll(
			@RequestParam(value = "filter", defaultValue = "") String filter
			) {
		List<CategoryOutputDTO> list = service.findAll(filter);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<CategoryNameOutputDTO>> findAllNames() {
		List<CategoryNameOutputDTO> list = service.findAllNames();
		return ResponseEntity.ok().body(list);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}	
