package com.task.product.project.Exceptions;


public class CategoryNotFoundException extends RuntimeException{
	
	public CategoryNotFoundException() {
		super();
	}
	
	public CategoryNotFoundException(String message) {
		super(message);
	}

}
