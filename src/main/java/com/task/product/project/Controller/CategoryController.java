package com.task.product.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.product.project.Dto.CategoryDto;
import com.task.product.project.Service.CategoryService;

@RestController
@RequestMapping("/api/")
public class CategoryController {
	
	
	@Autowired
    private CategoryService categoryService;
    
    @GetMapping("/getAllCategory")
    public ResponseEntity<List<CategoryDto>> getAllCategory() {
        List<CategoryDto> allCategory = categoryService.getAllCategory();
        return ResponseEntity.ok(allCategory);
    }
    
    @GetMapping("/getCategoryById/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable int id) {
        CategoryDto categoryById = categoryService.getCategoryById(id);
        return ResponseEntity.ok(categoryById);
       }
	
    @PostMapping("/addCategory")
    public ResponseEntity<?> addCategory(@RequestBody CategoryDto categoryDTO)
    {
        CategoryDto categoryDto = categoryService.addCategory(categoryDTO);
        return ResponseEntity.ok("Category is added");
    }
    
    @PutMapping("/updateCategoryById/{id}")
    public ResponseEntity<?> updateCategoryById(@PathVariable int id,@RequestBody CategoryDto categoryDTO)
    {
        categoryService.updateCategory(id,categoryDTO);
        return ResponseEntity.ok("updated SucessFully: "+id+categoryDTO);
    }
    
    @DeleteMapping("/deleteCategoryById/{id}")
    public String deleteCategoryById(@PathVariable int id)
    {
        categoryService.deleteById(id);
        return "Id is Deleted: "+id;
    }
		
	
}


	
	