package com.shopme.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		Role roleAdminRole = entityManager.find(Role.class, 1);
		User userName = new User("a@a.com", "aa2024", "Abel", "Dudu");
		userName.addRole(roleAdminRole);
		repo.save(userName);
		User savedUser = repo.save(userName);
		assertThat(savedUser.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testCreateNewUserWithTwoRoles() {
		User userRavi = new User("ravi@gmail.com", "ravi2020", "Ravi", "Kumar");
		Role roleEditor = new Role(3);
		Role roleAssistant = new Role(5);
		userRavi.addRole(roleEditor);
		userRavi.addRole(roleAssistant);
		User savedUser = repo.save(userRavi);
		assertThat(savedUser.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testListAllUsers() {
		Iterable<User> listUsers = repo.findAll();
		listUsers.forEach(user -> System.out.println(user));
	}
	
	@Test
	public void testGetUserById() {
		User userNam = repo.findById(1).get();
		System.out.println(userNam);
		assertThat(userNam).isNotNull();
	}
	
	@Test
	public void testUpdateUserDetails() {
		User userNam = repo.findById(1).get();
		userNam.setEnabled(true);
		userNam.setEmail("a@a.com");
		repo.save(userNam);
	}
	
	@Test
	public void testUpdateUserRoles() {
		User userRavi = repo.findById(2).get();
		Role roleEditor = new Role(3);
		Role roleSalesperson = new Role(2);
		userRavi.getRoles().remove(roleEditor);
		userRavi.addRole(roleSalesperson);
		repo.save(userRavi);
	}
	
	@Test
	public void testDeleteUser() {
		Integer userId = 2;
		repo.deleteById(userId);
	}
}