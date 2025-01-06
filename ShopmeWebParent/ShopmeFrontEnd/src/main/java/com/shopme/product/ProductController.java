package com.shopme.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.shopme.category.CategoryService;
import com.shopme.common.entity.Category;

@Controller
@CrossOrigin
public class ProductController {
	
	@Autowired 
	private CategoryService categoryService;
	
	@GetMapping("/c/{category_alias}")
	public String viewCategoryFirstPage(@PathVariable("category_alias") String alias) {
		Category category = categoryService.getCategory(alias);
		if (category == null) {
			return "error/404";
		}
		return "products_by_category";
	}
	
}
