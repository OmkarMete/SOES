package com.jsp.service;

import java.util.Collection;
import java.util.Collections;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.jsp.entity.User;

public class CustomUserDetails implements UserDetails {

	private User user;
	
	public CustomUserDetails(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singletonList(
	            new SimpleGrantedAuthority("ROLE_" + user.getRole())
	        );
	}

	@Override
	public @Nullable String getPassword() {
		 return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}
	
	

}
