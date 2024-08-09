package com.example.productcategory.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.productcategory.entities.Category;
import com.example.productcategory.entities.Product;
import com.example.productcategory.repository.CategoryRepository;
import com.example.productcategory.repository.ProductRepository;
import com.example.productcategory.dtos.ProductDto;

@Service
public class ProductService {
	
	    @Autowired
	    private ProductRepository productRepository;
	    
	    @Autowired
	    private CategoryRepository categoryRepository;

	    public Page<Product> getAllProducts(int page, int size) {
	        return productRepository.findAll(PageRequest.of(page, size));
	    }

	    public Product createProduct(ProductDto productDTO) {
	        Category category = categoryRepository.findById(productDTO.getCategoryId())
	                .orElseThrow(() -> new RuntimeException("Category not found"));
	        
	        Product product = new Product();
	        product.setName(productDTO.getName());
	        product.setPrice(productDTO.getPrice());
	        product.setCategory(category);
	
	       
	        return productRepository.save(product);
	    }
	    
	   

	    public Optional<Product> getProductById(Long id) {
	        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("product not found"));
	        return productRepository.findById(id);
	    }

	    public Product updateProduct(Long id, ProductDto productDto) {
	        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("product not found"));
	        Category category = categoryRepository.findById(productDto.getCategoryId())
	                .orElseThrow(() -> new RuntimeException("Category not found"));
	        product.setName(productDto.getName());
	        product.setPrice(productDto.getPrice());
	        product.setCategory(category);
	        return productRepository.save(product);
	    }

	    public void deleteProduct(Long id) {
	        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("product not found"));
	        productRepository.deleteById(id);
	    } 

}
