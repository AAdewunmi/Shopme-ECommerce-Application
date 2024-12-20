package com.shopme.admin.product;

import org.springframework.data.repository.CrudRepository;

import com.shopme.common.entity.Product;


public interface ProductRepository extends CrudRepository<Product, Integer>{
	
	public Product findByName(String name);

}
