package com.task.product.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.product.project.Dto.ProductDto;
import com.task.product.project.Service.ProductService;

@RestController
@RequestMapping("/api/")
public class ProductController {
	
	@Autowired
    private ProductService productService;
	
	
	
	@GetMapping("/getAllProducts")
    public ResponseEntity<?> list() {
        List<ProductDto> list = productService.getAllProducts();

        return ResponseEntity.ok().body(list);
    }
	
	
	
	@GetMapping("/getProductsById/{id}")
    public ResponseEntity<?> getProductsById(@PathVariable int id) {
        ProductDto productById = productService.getProductById(id);
        return ResponseEntity.ok().body(productById);
    }

	
	@PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody ProductDto productDto) {
        ProductDto productDTO1 = productService.save(productDto, 0);
        return ResponseEntity.ok().body(productDTO1);
    }

	 @PostMapping("/updateProduct/{id}")
	    public ResponseEntity<?> updateProduct(@RequestBody ProductDto productDTO, @PathVariable int id) {
	        ProductDto productDTO1 = productService.save(productDTO, id);
	        return ResponseEntity.ok().body(productDTO1);
	    }
	 
	 
	 @DeleteMapping("/deleteProduct/{productId}")
	    public String deleteProduct(@PathVariable int productId) {
	        productService.deleteById(productId);
	        return "id is deleted";
	    }
	 
	 @PostMapping("/{productId}/assignCategory/{categoryId}")
	    public ResponseEntity<?> assignCategoryToProduct(@PathVariable int productId, @PathVariable int categoryId) {
	        ProductDto productDto = productService.assignCategoryToProduct(productId, categoryId);
	        return ResponseEntity.ok("Category Assigned TO Products");
	    }
	 

}


