package com.fronchak.animeflix.dtos.user;

import javax.validation.constraints.NotBlank;

import com.fronchak.animeflix.validations.user.UserUpdateValid;

@UserUpdateValid
public class UserUpdateDTO extends UserInputDTO {

	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "Old password cannot be empty")
	private String oldPassword;

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
}
