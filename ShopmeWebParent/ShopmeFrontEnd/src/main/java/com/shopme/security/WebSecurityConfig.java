package com.shopme.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.shopme.security.oauth.CustomerOAuth2UserService;
import com.shopme.security.oauth.OAuth2LoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Autowired
	private CustomerOAuth2UserService customerOAuth2UserService;
	@Autowired
	private OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;
	@Autowired
	DatabaseLoginSuccessHandler databaseLoginSuccessHandler;

    @Bean
    PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
    
    @Bean 
	UserDetailsService userDetailsService() {
		return new CustomerUserDetailsService();
	}
    
    @Bean 
    DaoAuthenticationProvider authenticationProvider() {
		 DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		 authProvider.setUserDetailsService(userDetailsService());
		 authProvider.setPasswordEncoder(passwordEncoder()); 
		 return authProvider; 
	}
    
    @Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http.authorizeHttpRequests(auth -> auth
	    		.requestMatchers("/account_details/**", 
	    				"/orders/**",
	    				"/update_account_details/**",
	    				"/cart",
	    				"/address_book/**",
	    				"/checkout",
	    				"/placeorder/**",
	    				"/process_paypal_order/**"
	    			    ).permitAll()
	    		.anyRequest().authenticated());
	    http.formLogin(fL -> fL.loginPage("/login").usernameParameter("email")
	    		.defaultSuccessUrl("/", true)
	    		.successHandler(databaseLoginSuccessHandler)
	    		.permitAll());
	    http.logout(lOut -> {
	      lOut.permitAll();
	    try {
	    	//http.oauth2Login(oauth2 -> oauth2
                //.loginPage("/login") // Custom login page
                //.userInfoEndpoint(userInfo -> userInfo
                    //.userService(customerOAuth2UserService) // Custom OAuth2UserService
	    			//.successHandler(oAuth2LoginSuccessHandler); 
                //)
            //);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    });
	    http.rememberMe(rem -> rem
	    		.key("AbcDefgHijKlmnOpqrs_1234567890")
	    		.tokenValiditySeconds(7 * 24 * 60 * 60));
	    http.sessionManagement((session) -> session
	    		.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
	    		);
	    return http.build();
	  }
    
    @Bean
	WebSecurityCustomizer configureWebSecurity() throws Exception { 
 		return (web) -> web.ignoring().requestMatchers("/images/**","/js/**", "/webjars/**","/site-logo/**"); 
 	}

}
