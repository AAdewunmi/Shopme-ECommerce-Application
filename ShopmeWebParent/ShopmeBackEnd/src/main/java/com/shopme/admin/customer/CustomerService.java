package com.shopme.admin.customer;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.shopme.admin.PagingAndSortingHelper;
import com.shopme.admin.setting.country.CountryRepository;
import com.shopme.common.exception.CustomerNotFoundException;

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
	
	public void updateCustomerEnabledStatus(Integer id, boolean enabled) {
		customerRepo.updateEnabledStatus(id, enabled);
	}
	
	public Customer get(Integer id) throws CustomerNotFoundException {
		try {
			return customerRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			throw new CustomerNotFoundException("Could not find any customers with ID " + id);
		}
	}

}
