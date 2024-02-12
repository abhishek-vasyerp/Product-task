package com.task.product.project.advice;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.task.product.project.Dto.ResponseDto;
import com.task.product.project.Exceptions.CategoryNotFoundException;
import com.task.product.project.Exceptions.ProductNotFoundException;

@RestControllerAdvice
public class AllExceptionHandler {
	
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler
	public ResponseDto productNotFoundException(ProductNotFoundException e) {
		return new ResponseDto(404,"error",e.getMessage());
	}
	
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler
	public ResponseDto nullPointerException(NullPointerException e) {
		return new ResponseDto(404,"error",e.getMessage());
	}
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler
	public ResponseDto categoryNotFoundException(CategoryNotFoundException e) {
		return new ResponseDto(404,"error",e.getMessage());
	}

}
