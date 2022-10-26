package com.oc.microservices.msa.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oc.microservices.msa.entities.Product;

@RestController
@RequestMapping("/oc-api")
public class ProductController {

	ProductService domainService;
	Logger logger = LoggerFactory.getLogger(getClass());
	
	public ProductController(ProductService domainService) {
		super();
		logger.debug("building the domain service");
		this.domainService = domainService;
		logger.debug("Service built.");
	}
	
	@PostMapping(value="/Produits")
	public Product addAProduct(@RequestBody Product p) {
		logger.debug("Adding a new product method requested. id = "+p.getId());
		
		return domainService.save(p);
		
	}

	@GetMapping(value="/Produits")
	public List<Product> getAllProducts() {
		logger.debug("Getting all products method requested.");
		return domainService.findAll();
	}
	
	@GetMapping(value="/Produits/{id}")
	public Product getAProduct(@PathVariable long id) {
		
		return domainService.findById(id);
	}
	
	@DeleteMapping(value="/Produits/{id}")
	public Product deleteAProduct(@PathVariable long id) {
		
		return domainService.remove(id);
	}
}
