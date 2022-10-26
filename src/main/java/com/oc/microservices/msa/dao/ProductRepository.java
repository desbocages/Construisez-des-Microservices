package com.oc.microservices.msa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.oc.microservices.msa.entities.Product;

@Repository
public class ProductRepository implements ProductDao{
	private static final List<Product> liste = new ArrayList<>();

	static {
		liste.addAll(Stream.of(new Product(1, "Produit 1", 250), new Product(2, "Produit 2", 500),
				new Product(3, "Produit 3", 250), new Product(4, "Produit 4", 750)).toList());
	}

	@Override
	public List<Product> findAll() {
		return liste;
	}

	@Override
	public Product findById(long id) {
		if (liste.stream().anyMatch(e -> e.getId() == id))
			return liste.stream().filter(e -> e.getId() == id).findFirst().get();
		return null;
	}

	@Override
	public Product save(Product product) {
		if (product == null)
			return null;
		liste.add(product);
		return product;
	}
	
	public Product remove(long id) {
		Product p = findById(id);
		if(p==null) {
			return null;
		}
		liste.removeIf(e -> e.getId() == id);
		return p;
	}

	@Override
	public Product remove(Product p) {
		if(p==null||p.getId()==0)return null;
		return remove(p.getId());
	}

}
