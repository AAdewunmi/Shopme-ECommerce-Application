package com.shopme.customer;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.shopme.common.entity.Country;
import com.shopme.common.entity.Customer;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CustomerRepositoryTests {
	
	@Autowired private CustomerRepository repo;
	@Autowired private TestEntityManager entityManager;
	
	@Test
	public void testCreateCustomer1() {
		Integer countryId = 234; // USA
		Country country = entityManager.find(Country.class, countryId);
		
		Customer customer = new Customer();
		customer.setCountry(country);
		customer.setFirstName("David");
		customer.setLastName("Fountaine");
		customer.setPassword("password123");
		customer.setEmail("david.s.fountaine@gmail.com");
		customer.setPhoneNumber("312-462-7518");
		customer.setAddressLine1("1927  West Drive");
		customer.setCity("Sacramento");
		customer.setState("California");
		customer.setPostalCode("95867");
		customer.setCreatedTime(new Date());
		
		Customer savedCustomer = repo.save(customer);
		
		assertThat(savedCustomer).isNotNull();
		assertThat(savedCustomer.getId()).isGreaterThan(0);
	}
	
	
	
}
