package com.shopme.admin.brand;

import org.springframework.data.repository.CrudRepository;
import com.shopme.common.entity.Brand;

public interface BrandRepository extends CrudRepository<Brand, Integer>{
	public Long countById(Integer id);
}
