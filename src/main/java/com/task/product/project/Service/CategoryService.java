package com.task.product.project.Service;

import java.util.List;

import com.task.product.project.Dto.CategoryDto;


public interface CategoryService {
	
	List<CategoryDto>getAllCategory();
	
	CategoryDto getCategoryById(int id);
	
	
	CategoryDto addCategory(CategoryDto categoryDto );
	
	CategoryDto updateCategory(int id,CategoryDto categoryDto);
	
	void deleteById(int id);
	

}
