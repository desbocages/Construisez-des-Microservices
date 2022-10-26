package com.oc.microservices.msa.controllers;

import java.util.List;

import com.oc.microservices.msa.entities.Product;

public interface IService {
	public Product save(Product product);
	public List<Product> findAll();
	public Product findById(long id);
	public Product remove(long id);
}
