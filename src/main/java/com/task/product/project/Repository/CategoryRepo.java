package com.task.product.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.product.project.Model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{
	

}
