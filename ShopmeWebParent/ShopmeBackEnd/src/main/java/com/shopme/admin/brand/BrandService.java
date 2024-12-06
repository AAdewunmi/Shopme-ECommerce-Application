package com.shopme.admin.brand;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.LongToDoubleFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopme.common.entity.Brand;

@Service
public class BrandService {
	
	public static final int BRANDS_PER_PAGE = 10;
	
	@Autowired
	private BrandRepository repository;
	
	public Brand save(Brand brand) {
		return repository.save(brand);
	}
	
	public List<Brand> listAll(){
		return (List<Brand>) repository.findAll();
	}
	
	public Brand get(Integer id) throws BrandNotFoundException {
		try {
			return repository.findById(id).get();
		} catch (NoSuchElementException ex) {
			throw new BrandNotFoundException("Could not find any brand with ID " + id);
		}
	}
	
	public void delete(Integer id) throws BrandNotFoundException{
		Long countById = repository.countById(id);
		if (countById == null || countById == 0) {
			throw new BrandNotFoundException("Could not find any brand with ID " + id);
		}
		repository.deleteById(id);
	}
}
