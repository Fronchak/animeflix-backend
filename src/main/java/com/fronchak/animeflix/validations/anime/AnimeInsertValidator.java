package com.fronchak.animeflix.validations.anime;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.fronchak.animeflix.dtos.anime.AnimeInsertDTO;
import com.fronchak.animeflix.entities.Anime;
import com.fronchak.animeflix.exceptions.FieldMessage;
import com.fronchak.animeflix.repositories.AnimeRepository;

public class AnimeInsertValidator implements ConstraintValidator<AnimeInsertValid, AnimeInsertDTO> {

	@Autowired
	private AnimeRepository repository;
	
	@Override
	public boolean isValid(AnimeInsertDTO dto, ConstraintValidatorContext context) {
		
		List<FieldMessage> errors = new ArrayList<>();
		
		Anime anime = repository.findByName(dto.getName());
		if(anime != null) {
			errors.add(new FieldMessage("name", "This anime is already register"));
		}
		
		for (FieldMessage e : errors) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		
		return errors.isEmpty();
	}

}
