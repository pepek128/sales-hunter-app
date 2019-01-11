package com.patryk.application.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.patryk.application.models.User;
import com.patryk.application.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
	@Autowired
	UserRepository userRepository;
 
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
 
		User user = userRepository.findByUsername(username).orElseThrow(
				() -> new UsernameNotFoundException("Nie znaleziono użytkownika" + username));
 
		return UserPrinciple.build(user);
	}
}