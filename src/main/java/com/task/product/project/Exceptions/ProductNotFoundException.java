package com.task.product.project.Exceptions;

public class ProductNotFoundException extends RuntimeException{
	public ProductNotFoundException() {
		super();
	}
	public ProductNotFoundException(String message) {
		super(message);
	}

}
