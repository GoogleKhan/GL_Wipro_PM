package com.wipro.MongoDB.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.MongoDB.model.Product;
import com.wipro.MongoDB.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product save(Product product) {
		//So much work
		return productRepository.save(product);
	}

	public Product update(Product product) {
		return productRepository.save(product);
	}

	public Optional<Product> getProduct(long id) {
		return productRepository.findById(id);
	}

	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	public void deleteProduct(long id) {
		productRepository.deleteById(id);
	}

}
