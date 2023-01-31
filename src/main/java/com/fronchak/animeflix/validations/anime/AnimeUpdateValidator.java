package com.fronchak.animeflix.validations.anime;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.fronchak.animeflix.dtos.anime.AnimeInsertDTO;
import com.fronchak.animeflix.dtos.anime.AnimeUpdateDTO;
import com.fronchak.animeflix.entities.Anime;
import com.fronchak.animeflix.exceptions.FieldMessage;
import com.fronchak.animeflix.repositories.AnimeRepository;

public class AnimeUpdateValidator implements ConstraintValidator<AnimeUpdateValid, AnimeUpdateDTO> {

	@Autowired
	private AnimeRepository repository;
	
	@Autowired
	private HttpServletRequest request;
	
	@Override
	public boolean isValid(AnimeUpdateDTO dto, ConstraintValidatorContext context) {
		
		List<FieldMessage> errors = new ArrayList<>();
		
		Map<String, String> uriVars = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Long id = Long.parseLong(uriVars.get("id"));
		
		Anime anime = repository.findByName(dto.getName());
		if(anime != null && !anime.getId().equals(id)) {
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
