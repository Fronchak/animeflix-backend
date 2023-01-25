package com.fronchak.animeflix.dtos.user;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fronchak.animeflix.dtos.role.RoleOutputDTO;
import com.fronchak.animeflix.entities.User;

public class UserOutputDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String email;
	
	private Set<RoleOutputDTO> roles = new HashSet<>();
	
	public UserOutputDTO() {}
	
	public UserOutputDTO(Long id, String email) {
		this.id = id;
		this.email = email;
	}
	
	public UserOutputDTO(User user) {
		this(user.getId(), user.getEmail());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<RoleOutputDTO> getRoles() {
		return roles;
	}

	public void AddRole(RoleOutputDTO role) {
		roles.add(role);
	}
}
