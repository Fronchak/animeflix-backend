package com.fronchak.animeflix.validations.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.fronchak.animeflix.dtos.user.UserUpdateDTO;
import com.fronchak.animeflix.entities.User;
import com.fronchak.animeflix.exceptions.FieldMessage;
import com.fronchak.animeflix.repositories.UserRepository;

public class UserUpdateValidator implements ConstraintValidator<UserUpdateValid, UserUpdateDTO> {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private HttpServletRequest request;
	
	@Override
	public boolean isValid(UserUpdateDTO dto, ConstraintValidatorContext context) {
		
		List<FieldMessage> errors = new ArrayList<>();
		
		Map<String, String> uriVars = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Long id = Long.parseLong(uriVars.get("id"));
		
		User user = repository.findByEmail(dto.getEmail());
		if(user != null && !user.getId().equals(id)) {
			errors.add(new FieldMessage("email", "E-mail is already been used"));
		}
		
		if(!dto.getPassword().equals(dto.getConfirmPassword())) {
			errors.add(new FieldMessage("password", "Passwords must be the same"));
			errors.add(new FieldMessage("confirmPassword", "Passwords must be the same"));
		}
		
		for (FieldMessage e : errors) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		
		return errors.isEmpty();
	}

}
