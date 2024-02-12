package com.task.product.project.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.product.project.Dto.CategoryDto;
import com.task.product.project.Dto.ProductDto;
import com.task.product.project.Exceptions.CategoryNotFoundException;
import com.task.product.project.Exceptions.ProductNotFoundException;
import com.task.product.project.Model.Category;
import com.task.product.project.Model.ProductModel;
import com.task.product.project.Repository.CategoryRepo;
import com.task.product.project.Repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public List<ProductDto> getAllProducts() {
		List<ProductDto> list = new ArrayList<>();
		List<ProductModel> products = productRepo.findAll();
		for(ProductModel productModel: products) {
			ProductDto productDto = new ProductDto();
			productDto.setProductId(productModel.getProductId());
			productDto.setProductName(productModel.getProductName());
			
			
			Category category = productModel.getCategory();
//			if(category != null) {
//				CategoryDto categoryDto = new CategoryDto();
//				CategoryDto.setCategoryid(productModel.getCategory().getCategoryId());
//				CategoryDto.setCategoryname(productModel.getCategory().getCategoryName());
//				productDto.setCategoryid(category);
//				
//			}
			list.add(productDto);
		}
		
		
		
		
		return list;
	}

	@Override
	public ProductDto getProductById(int id) {
        ProductModel product = productRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product Not Found: " + id));
        Category category = product.getCategory();

        ProductDto productDTO = new ProductDto();
        productDTO.setProductId(product.getProductQuantity());
        productDTO.setProductName(product.getProductName());
       

        if (category != null) {
            CategoryDto categoryDTO = new CategoryDto();
            categoryDTO.setCategoryid(product.getCategory().getCategoryId());
            categoryDTO.setCategoryname(product.getCategory().getCategoryName());
            productDTO.setCategoryid(category);
        }
		return productDTO;
	}

	@Override
	public ProductDto save(ProductDto productDto, int id) {
		// TODO Auto-generated method stub
		
		 if (id == 0) {
	            ProductModel product = new ProductModel();
	            Category category = null; // Allow null library for new student
	            if (productDto.getCategoryid() != null) {
	                category = categoryRepo.findById(productDto.getCategoryid().getCategoryId())
	                        .orElseThrow(() -> new ProductNotFoundException("Product not found"));

//	              category = new Category();
	                category.setCategoryId(productDto.getCategoryid().getCategoryId());
	                category.setCategoryName(productDto.getCategoryid().getCategoryName());
//	              categoryRepository.save(category);
	                product.setCategory(category);
	            }
	            product.setCategory(category);
	            product.setProductName(productDto.getProductName());
	            
	            productRepo.save(product);
	        } else {
	            // For Update Products
	            Optional<ProductModel> optionalProduct = productRepo.findById((int) id);
//	          Product product = optionalProduct.orElseThrow(() -> new ProductNotFoundException("Product ID is not found"));

	            if (optionalProduct.isPresent()) {
	                ProductModel productEdit = optionalProduct
	                        .orElseThrow(() -> new ProductNotFoundException("Product ID is not found"));
	                if (productDto.getProductName() != null) {
	                    productEdit.setProductName(productDto.getProductName());
	                }
	               
	                Category categoryEdit = productEdit.getCategory();
	                if (categoryEdit != null && productDto.getCategoryid() != null) {
	                    categoryEdit.setCategoryId(productDto.getProductId());
	                    categoryEdit.setCategoryName(productDto.getProductName());
	                }
	                productRepo.save(productEdit);
	            }
	        }
	        return productDto;
	}

	@Override
	public ProductDto assignCategoryToProduct(int id, int categoryId) {
		// TODO Auto-generated method stub
		ProductModel product = productRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        if (product.getCategory() != null && product.getCategory().getCategoryId() == categoryId) {
            throw new CategoryNotFoundException("This Category already assigned to this product.");
        }
        
          // Retrieve the category by ID
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + categoryId));
        
        // Assign the category to the product
        product.setCategory(category);

        productRepo.save(product);
        return new ProductDto(product);
	  }

		
		

	@Override
	public void deleteById(int productId) {
		// TODO Auto-generated method stub
		
		   // TODO Auto-generated method stub
        ProductModel product = productRepo.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product  Not Found"));
        productRepo.deleteById(productId);
		
	}
	
	

}
