package com.fronchak.animeflix.mappers;

import org.springframework.stereotype.Service;

import com.fronchak.animeflix.dtos.role.RoleOutputDTO;
import com.fronchak.animeflix.dtos.user.UserOutputDTO;
import com.fronchak.animeflix.entities.User;

@Service
public class UserMapper {

	public UserOutputDTO convertEntityUserToUserOutputDTO(User entity) {
		UserOutputDTO dto = new UserOutputDTO(entity);
		entity.getRoles()
			.forEach((role) -> dto.AddRole(new RoleOutputDTO(role)));
		return dto;
	}
}
