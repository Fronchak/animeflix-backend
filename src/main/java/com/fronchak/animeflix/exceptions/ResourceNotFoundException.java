package com.fronchak.animeflix.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String msg) {
		super(msg);
	}
	
	public ResourceNotFoundException(String entity, String id) {
		this(entity + " not found by ID: " + id);
	}
	
	public static String getError() {
		return "Entity not found";
	}
}
