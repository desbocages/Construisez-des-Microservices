package com.oc.microservices.msa.controllers;

import java.util.List;

import org.springframework.stereotype.Service;

import com.oc.microservices.msa.dao.ProductRepository;
import com.oc.microservices.msa.entities.Product;

@Service
public class ProductService implements IService {
	
	ProductRepository repo;
	

	public ProductService(ProductRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Product save(Product product) {
		return repo.save(product);
	}

	@Override
	public List<Product> findAll() {
		return repo.findAll();
	}

	@Override
	public Product findById(long id) {
		return repo.findById(id);
	}

	@Override
	public Product remove(long id) {
		return repo.remove(id);
	}

}
