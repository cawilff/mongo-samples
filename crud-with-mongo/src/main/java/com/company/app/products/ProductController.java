package com.company.app.products;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/all")
	public List<Product> getProducts() {
		LOGGER.info("Retrieving products ... ");
		return productRepository.findAll();

	}

	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Product product) {
		LOGGER.info("Adding new product = {}", product);
		productRepository.save(product);
		return "Product added: " + product.getIdProduct();
	}

	@PutMapping("/updateProduct")
	public void updateProduct(@RequestBody Product product) {
		LOGGER.info("Updating product= {}", product);
		Product productbd = productRepository.findById(product.getIdProduct()).get();
		productbd.setName(product.getName());
		productbd.setPrice(product.getPrice());
		LOGGER.info("Update product with values {}", productbd);
		productRepository.save(productbd);
	}

	@GetMapping("/getProduct/{id}")
	public Optional<Product> getProduct(@PathVariable Long id) {
		LOGGER.info("Retrieving product with id={}", id);
		return productRepository.findById(id);

	}

	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable Long id) {
		LOGGER.info("Deleting product with id={}", id);
		productRepository.deleteById(id);
		return "product delete: " + id;
	}
}
