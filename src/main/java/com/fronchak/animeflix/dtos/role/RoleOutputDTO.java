package com.fronchak.animeflix.dtos.role;

import java.io.Serializable;

import com.fronchak.animeflix.entities.Role;

public class RoleOutputDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String authority;
	
	public RoleOutputDTO() {}
	
	public RoleOutputDTO(Long id, String authority) {
		this.id = id;
		this.authority = authority;
	}
	
	public RoleOutputDTO(Role role) {
		this(role.getId(), role.getAuthority());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
