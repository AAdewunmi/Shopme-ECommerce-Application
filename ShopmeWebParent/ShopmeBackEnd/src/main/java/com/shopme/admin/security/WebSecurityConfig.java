package com.shopme.admin.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
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
	    		.requestMatchers("/states/list_by_country/**").hasAnyAuthority("Admin", "Salesperson")
	            .requestMatchers("/users/**", "/settings/**", "/countries/**", "/states/**").hasAuthority("Admin")
	            .requestMatchers("/categories/**", "/brands/**").hasAnyAuthority("Admin", "Editor")
	            .requestMatchers("/products/new", "/products/delete/**").hasAnyAuthority("Admin", "Editor")
	            .requestMatchers("/products/edit/", "/products/save", 
	            		"/products/check_unique").hasAnyAuthority("Admin", "Editor", "Salesperson")
	            .requestMatchers("/products", "/products/", "/products/detail/**",
	            		"/products/page/**").hasAnyAuthority("Admin", "Editor", "Salesperson", "Shipper")
	            .requestMatchers("/products/**").hasAnyAuthority("Admin", "Editor")
	            .requestMatchers("/customers/**", "/orders/**", "/get_shipping_cost", "/reports/**").hasAnyAuthority("Admin", "Salesperson")
	            .requestMatchers("/orders", "/orders/**", "/orders/page/**", "/orders/detail/**").hasAnyAuthority("Admin", "Salesperson", "Shipper")
	            .requestMatchers("/orders_shipper/update/**").hasAuthority("Shipper")
	            .requestMatchers("/products/detail/**", "/customers/detail/**").hasAnyAuthority("Admin", "Salesperson", "Shipper", "Assistant")
	            .requestMatchers("/reviews/**").hasAnyAuthority("Admin", "Assistant")
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
	    http.headers(headersCustomizer -> headersCustomizer
	    		.frameOptions(frameOptionsCustomizer -> frameOptionsCustomizer
	    				.sameOrigin()));
	    return http.build();
	  }
	
	@Bean 
 	WebSecurityCustomizer configureWebSecurity() throws Exception { 
 		return (web) -> web.ignoring().requestMatchers("/images/**","/js/**", "/webjars/**"); 
 	}
}
