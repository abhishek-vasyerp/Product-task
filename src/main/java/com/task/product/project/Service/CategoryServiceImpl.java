package com.task.product.project.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.product.project.Dto.CategoryDto;
import com.task.product.project.Exceptions.CategoryNotFoundException;
import com.task.product.project.Model.Category;
import com.task.product.project.Repository.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public List<CategoryDto> getAllCategory() {
		// TODO Auto-generated method stub
		List<CategoryDto> list = new ArrayList<>();
        List<Category> categoryList = categoryRepo.findAll();
        for (Category category : categoryList) {
            CategoryDto categoryDTO = new CategoryDto();
            categoryDTO.setCategoryname(category.getCategoryName());
            categoryDTO.setCategoryid(category.getCategoryId());

            list.add(categoryDTO);
        }
       
		return list;
	}

	@Override
	public CategoryDto getCategoryById(int id) {
		// TODO Auto-generated method stub
		
		 Category category = categoryRepo.findById(id)
	                .orElseThrow(() -> new CategoryNotFoundException("Category Id not found: " + id));
	        CategoryDto categoryDTO = new CategoryDto();
	        categoryDTO.setCategoryid(category.getCategoryId());
	        categoryDTO.setCategoryname(category.getCategoryName());
	        return categoryDTO;
		
	}

	@Override
	public CategoryDto addCategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		Category category = new Category();
        Category save = categoryRepo.save(category);
        return new CategoryDto(save);
  
	}

	@Override
	public CategoryDto updateCategory(int id, CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		 Category category = categoryRepo.findById(id)
	                .orElseThrow(() -> new CategoryNotFoundException("category id is not found: " + id));
	        if (categoryDto.getCategoryid() != 0) {
	            category.setCategoryId(categoryDto.getCategoryid());
	        }
	        if (categoryDto.getCategoryname() != null) {
	            category.setCategoryName(categoryDto.getCategoryname());
	        }
	        Category save = categoryRepo.save(category);
	        return new CategoryDto(save);
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
        Category category = categoryRepo.findById(id)
                .orElseThrow(()-> new CategoryNotFoundException("not found"));
        categoryRepo.deleteById(id);

    }

		
	}
	
	
