package com.shopme.admin.review;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.shopme.common.entity.Customer;
import com.shopme.common.entity.Review;
import com.shopme.common.entity.product.Product;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ReviewRepositoryTests {
	
	@Autowired 
	private ReviewRepository repo;
	
	@Test
	public void testCreateReview() {
		Integer productId = 1;
		Product product = new Product(productId);
		
		Integer customerId = 5;
		Customer customer = new Customer(customerId);
		
		Review review = new Review();
		review.setProduct(product);
		review.setCustomer(customer);
		review.setReviewTime(new Date());
		review.setHeadline("Perfect for my needs. Loving it!");
		review.setComment("Nice to have: wireless remote, iOS app, GPS...");
		review.setRating(5);
		
		Review savedReview = repo.save(review);
		
		assertThat(savedReview).isNotNull();
		assertThat(savedReview.getId()).isGreaterThan(0);		
	}

}
