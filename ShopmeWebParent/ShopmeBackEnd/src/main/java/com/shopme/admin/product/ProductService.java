package com.shopme.admin.product;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.shopme.common.entity.Product;

@Service
public class ProductService {
	
	public static final int PRODUCTS_PER_PAGE = 5;
	
	@Autowired private ProductRepository repo;
	
	public List<Product> listAll() {
		return (List<Product>) repo.findAll();
	}
	
	/*
	 * public Page<Product> listByPage(int pageNum, String sortField, String
	 * sortDir, String keyword, Integer categoryId) { Sort sort =
	 * Sort.by(sortField);
	 * 
	 * sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
	 * 
	 * Pageable pageable = PageRequest.of(pageNum - 1, PRODUCTS_PER_PAGE, sort);
	 * 
	 * if (keyword != null && !keyword.isEmpty()) { if (categoryId != null &&
	 * categoryId > 0) { String categoryIdMatch = "-" + String.valueOf(categoryId) +
	 * "-"; return repo.searchInCategory(categoryId, categoryIdMatch, keyword,
	 * pageable); }
	 * 
	 * return repo.findAll(keyword, pageable); }
	 * 
	 * if (categoryId != null && categoryId > 0) { String categoryIdMatch = "-" +
	 * String.valueOf(categoryId) + "-"; return repo.findAllInCategory(categoryId,
	 * categoryIdMatch, pageable); }
	 * 
	 * return repo.findAll(pageable); }
	 */
	
	public Product save(Product product) {
		if (product.getId() == null) {
			product.setCreatedTime(new Date());
		}
		
		if (product.getAlias() == null || product.getAlias().isEmpty()) {
			String defaultAlias = product.getName().replaceAll(" ", "-");
			product.setAlias(defaultAlias);
		} else {
			product.setAlias(product.getAlias().replaceAll(" ", "-"));
		}
		
		product.setUpdatedTime(new Date());
		
		return repo.save(product);
	}
	
}
