package com.fronchak.animeflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fronchak.animeflix.dtos.user.UserOutputDTO;
import com.fronchak.animeflix.services.UserService;

@RestController
@RequestMapping(value = "/admin/users")
public class AdminUserController {

	@Autowired
	private UserService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserOutputDTO> findById(@PathVariable Long id) {
		UserOutputDTO outputDTO = service.findById(id);
		return ResponseEntity.ok().body(outputDTO);
	}
}
