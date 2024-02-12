package com.task.product.project.Dto;

import com.task.product.project.Model.Category;
import com.task.product.project.Model.ProductModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
	
	
	public ProductDto(ProductModel productModel) {
		
	}
	private int productId;
	private String ProductName;
	
	private Category categoryid;
	
}
