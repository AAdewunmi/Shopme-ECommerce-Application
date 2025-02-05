package com.shopme.admin.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.shopme.admin.setting.country.CountryRepository;

public class CustomerService {
	
public static final int CUSTOMERS_PER_PAGE = 10;
	
	@Autowired 
	private CustomerRepository customerRepo;
	
	@Autowired 
	private CountryRepository countryRepo;	
	
	@Autowired 
	private PasswordEncoder passwordEncoder;
	
	public void listByPage(int pageNum, PagingAndSortingHelper helper) {
		helper.listEntities(pageNum, CUSTOMERS_PER_PAGE, customerRepo);
	}

}
