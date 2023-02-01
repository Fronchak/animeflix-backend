package com.fronchak.animeflix.validations.category;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.fronchak.animeflix.dtos.category.CategoryInsertDTO;
import com.fronchak.animeflix.dtos.category.CategoryUpdateDTO;
import com.fronchak.animeflix.entities.Category;
import com.fronchak.animeflix.exceptions.FieldMessage;
import com.fronchak.animeflix.repositories.CategoryRepository;

public class CategoryUpdateValidator implements ConstraintValidator<CategoryUpdateValid, CategoryUpdateDTO> {

	@Autowired
	private CategoryRepository repository;
	
	@Autowired
	private HttpServletRequest request;
	
	@Override
	public boolean isValid(CategoryUpdateDTO dto, ConstraintValidatorContext context) {
		
		List<FieldMessage> errors = new ArrayList<>();
		
		Map<String, String> uriVars = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Long id = Long.parseLong(uriVars.get("id"));
		
		Category category = repository.findByNameIgnoreCase(dto.getName());
		if(category != null && !category.getId().equals(id)) {
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
