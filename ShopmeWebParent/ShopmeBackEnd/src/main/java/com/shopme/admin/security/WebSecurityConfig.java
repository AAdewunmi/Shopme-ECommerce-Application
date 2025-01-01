package com.shopme.admin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Bean 
	UserDetailsService userDetailsService() {
		return new ShopmeUserDetailsService();
	}
	
	@Bean 
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
	@Bean DaoAuthenticationProvider authenticationProvider() {
		 DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		 authProvider.setUserDetailsService(userDetailsService());
		 authProvider.setPasswordEncoder(passwordEncoder()); 
		 return authProvider; 
	}
	
	@Bean
	  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http.authorizeHttpRequests(auth -> auth
	            .requestMatchers("/users/**").hasAuthority("Admin")
	            .requestMatchers("/categories/**", "/brands/**").hasAnyAuthority("Admin", "Editor")
	            .requestMatchers("/products/new", "/products/delete/**").hasAnyAuthority("Admin", "Editor")
	            .requestMatchers("/products/edit/", "/products/save", 
	            		"/products/check_unique").hasAnyAuthority("Admin", "Editor", "Salesperson")
	            .requestMatchers("/products", "/products/", "/products/detail/**",
	            		"/products/page/**").hasAnyAuthority("Admin", "Editor", "Salesperson", "Shipper")
	            .requestMatchers("/products/**").hasAnyAuthority("Admin", "Editor")
	            
	            .anyRequest().authenticated());
	    http.formLogin(fL -> fL.loginPage("/login").usernameParameter("email").permitAll());
	    http.logout(lOut -> {
	      lOut.invalidateHttpSession(true)
	          .clearAuthentication(true)
	          .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	          .logoutSuccessUrl("/login?logout")
	          .permitAll();
	    });
	    http.rememberMe(rem -> rem
	    		.key("AbcDefgHijKlmnOpqrs_1234567890")
	    		.tokenValiditySeconds(7 * 24 * 60 * 60));
	    return http.build();
	  }
	
	@Bean 
 	WebSecurityCustomizer configureWebSecurity() throws Exception { 
 		return (web) -> web.ignoring().requestMatchers("/images/**","/js/**", "/webjars/**"); 
 	}
}
