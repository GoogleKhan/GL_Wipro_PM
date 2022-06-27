package com.wipro.MongoDB.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.MongoDB.model.Product;
import com.wipro.MongoDB.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/product")
	public Product save(@RequestBody Product product) {
		return productService.save(product);
	}

	@PutMapping("/product")
	public Product update(@RequestBody Product product) {
		return productService.update(product);
	}

	@GetMapping("/product/{id}")
	public Optional<Product> getProduct(@PathVariable long id) {
		return productService.getProduct(id);
	}

	@GetMapping("/product")
	public List<Product> getAllProduct() {
		return productService.getAllProduct();
	}

	@DeleteMapping("/product/{id}")
	public void deleteProduct(@PathVariable long id) {
		productService.deleteProduct(id);
	}

}
