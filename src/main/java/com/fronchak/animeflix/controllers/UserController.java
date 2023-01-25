package com.fronchak.animeflix.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fronchak.animeflix.dtos.user.UserInputDTO;
import com.fronchak.animeflix.dtos.user.UserOutputDTO;
import com.fronchak.animeflix.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService service;;
	
	@PostMapping
	public ResponseEntity<UserOutputDTO> save(@RequestBody UserInputDTO inputDTO) {
		UserOutputDTO outputDTO = service.save(inputDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(outputDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(outputDTO);
		
	}
}
