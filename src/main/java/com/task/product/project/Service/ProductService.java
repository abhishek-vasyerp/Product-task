package com.task.product.project.Service;

import java.util.List;


import com.task.product.project.Dto.ProductDto;

public interface ProductService {
	
	public List<ProductDto>getAllProducts();
	
	public ProductDto getProductById(int id);
	
	
	public ProductDto save(ProductDto productDto, int id );
	
	ProductDto assignCategoryToProduct(int id,int categoryId);
	
	public void deleteById(int productId);

}
