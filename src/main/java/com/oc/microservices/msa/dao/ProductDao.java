package com.oc.microservices.msa.dao;

import java.util.List;

import com.oc.microservices.msa.entities.Product;

public interface ProductDao {
	public List<Product> findAll();
	public Product findById(long id);
	public Product save(Product p);
	public Product remove(Product p);
}
