package com.shopme.admin.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shopme.admin.paging.SearchRepository;
import com.shopme.common.entity.User;

public interface UserRepository extends SearchRepository<User, Integer>{
	@Query("SELECT u FROM User u WHERE u.email = :email")
	public User getUserByEmail(@Param("email") String email);
}
