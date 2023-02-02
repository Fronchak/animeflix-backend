package com.fronchak.animeflix.validations.user;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.fronchak.animeflix.dtos.user.UserInsertDTO;
import com.fronchak.animeflix.entities.User;
import com.fronchak.animeflix.exceptions.FieldMessage;
import com.fronchak.animeflix.repositories.UserRepository;

public class UserInsertValidator implements ConstraintValidator<UserInsertValid, UserInsertDTO> {

	@Autowired
	private UserRepository repository;
	
	@Override
	public boolean isValid(UserInsertDTO dto, ConstraintValidatorContext context) {
		
		List<FieldMessage> errors = new ArrayList<>();
		
		User user = repository.findByEmail(dto.getEmail());
		if(user != null) {
			errors.add(new FieldMessage("Email", "E-mail is already been used"));
		}
		
		if(!dto.getPassword().equals(dto.getConfirmPassword())) {
			errors.add(new FieldMessage("Password", "Passwords must be the same"));
			errors.add(new FieldMessage("ConfirmPassword", "Passwords must be the same"));
		}
		
		for (FieldMessage e : errors) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		
		return errors.isEmpty();
	}

}
