package com.task.product.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.product.project.Model.ProductModel;

public interface  ProductRepo extends JpaRepository<ProductModel, Integer> {
	
	
	

}
