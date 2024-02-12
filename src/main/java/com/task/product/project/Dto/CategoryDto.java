package com.task.product.project.Dto;

import com.task.product.project.Model.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	
	public CategoryDto(Category category) {
	
	}
	private int categoryid;
	private String categoryname;
	

}
