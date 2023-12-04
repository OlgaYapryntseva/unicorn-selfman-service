package com.selfman.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.selfman.customer.dao.CustomerRepository;
import com.selfman.customer.model.Customer;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
	final CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Customer customer = customerRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
		String[] roles = customer.getRoles()
										.stream()
										.map(r -> "ROLE_" + r.toUpperCase())
										.toArray(String[]::new);
		 return new User(customer.getEmail(), customer.getPassword(), AuthorityUtils.createAuthorityList(roles));
	}

}
