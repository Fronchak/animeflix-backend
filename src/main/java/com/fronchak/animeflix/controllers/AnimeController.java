package com.fronchak.animeflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fronchak.animeflix.services.AnimeService;

@RestController
@RequestMapping(value = "/animes")
public class AnimeController {

	@Autowired
	private AnimeService service;
}
