package com.fronchak.animeflix.validations.category;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.fronchak.animeflix.dtos.category.CategoryInsertDTO;
import com.fronchak.animeflix.entities.Category;
import com.fronchak.animeflix.exceptions.FieldMessage;
import com.fronchak.animeflix.repositories.CategoryRepository;

public class CategoryInsertValidator implements ConstraintValidator<CategoryInsertValid, CategoryInsertDTO> {

	@Autowired
	private CategoryRepository repository;
	
	@Override
	public boolean isValid(CategoryInsertDTO dto, ConstraintValidatorContext context) {
		
		List<FieldMessage> errors = new ArrayList<>();
		
		Category category = repository.findByNameIgnoreCase(dto.getName());
		if(category != null) {
			errors.add(new FieldMessage("name", "Category is already register"));
		}
		
		for (FieldMessage e : errors) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		
		return errors.isEmpty();
	}

}
