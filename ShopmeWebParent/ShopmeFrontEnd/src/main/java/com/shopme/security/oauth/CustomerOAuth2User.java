package com.shopme.security.oauth;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class CustomerOAuth2User implements OAuth2User {

	private String clientName;
	private String fullName;
	private OAuth2User oauth2User;
	
	public CustomerOAuth2User(OAuth2User user, String clientName) {
		this.oauth2User = user;
		this.clientName = clientName;
	}

	@Override
	public Map<String, Object> getAttributes() {
		return oauth2User.getAttributes();
	}
}
