package com.fronchak.animeflix.dtos.user;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserInputDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Client's email must be specified")
	@Email(message = "Invalid email format, please try a valid email", 
	regexp = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$")
	private String email;
	
	@NotBlank(message = "Password cannot be empty")
	@Size(min = 6, message = "Password must have at least 6 letters")
	private String password;
	
	@NotBlank(message = "Password cannot be empty")
	@Size(min = 6, message = "Password must have at least 6 letters")
	private String confirmPassword;	
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
