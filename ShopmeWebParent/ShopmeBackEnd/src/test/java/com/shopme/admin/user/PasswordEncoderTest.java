package com.shopme.admin.user;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {
	@Test
	public void testEncodePassword() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String rawPassword = "12345678";
		String encodedPassword = passwordEncoder.encode(rawPassword);
		System.out.println(encodedPassword);
		boolean matches = passwordEncoder.matches(rawPassword, encodedPassword);
		assertThat(matches).isTrue();
	}
	
	@Test
	public void testEncodePassword1() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String rawPassword = "bb2024";
		String encodedPassword = passwordEncoder.encode(rawPassword);
		
		System.out.println(encodedPassword);
		
		boolean matches = passwordEncoder.matches(rawPassword, encodedPassword);
		
		assertThat(matches).isTrue();
	}
}
