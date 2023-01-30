package com.fronchak.animeflix.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.fronchak.animeflix.dtos.anime.AnimeInsertDTO;
import com.fronchak.animeflix.dtos.anime.AnimeOutputAllDTO;
import com.fronchak.animeflix.dtos.anime.AnimeOutputDTO;
import com.fronchak.animeflix.dtos.anime.AnimeUpdateDTO;
import com.fronchak.animeflix.services.AnimeService;

@RestController
@RequestMapping(value = "/animes")
public class AnimeController {

	@Autowired
	private AnimeService service;
	
	@PostMapping
	public ResponseEntity<AnimeOutputDTO> save(@Valid @RequestBody AnimeInsertDTO insertDTO) {
		AnimeOutputDTO outputDTO = service.save(insertDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(outputDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(outputDTO);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AnimeOutputDTO> update(@Valid @RequestBody AnimeUpdateDTO updateDTO, @PathVariable Long id) {
		AnimeOutputDTO outputDTO = service.update(updateDTO, id);
		return ResponseEntity.ok().body(outputDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AnimeOutputDTO> findById(@PathVariable Long id) {
		AnimeOutputDTO outputDTO = service.findById(id);
		return ResponseEntity.ok().body(outputDTO);
	}
	
	@GetMapping
	public ResponseEntity<Page<AnimeOutputAllDTO>> findPaged(
			@RequestParam(value = "filter", defaultValue = "") String filter,
			@RequestParam(value = "categoryId", defaultValue = "0") Long categoryId,
			Pageable pageable) {
		Page<AnimeOutputAllDTO> page = service.findPaged(filter, categoryId, pageable);
		return ResponseEntity.ok().body(page);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
