package com.selfman.security;

import java.util.Optional;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.selfman.customer.dao.CustomerRepository;
import com.selfman.customer.model.Customer;
import com.selfman.provider.dao.ProviderRepository;
import com.selfman.provider.model.Provider;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
	final CustomerRepository customerRepository;
	final ProviderRepository providerRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Customer> customerOptional = customerRepository.findById(email);
		if (customerOptional.isPresent()) {
			Customer customer = customerOptional.get();
			String[] roles = customer.getRoles().stream().map(r -> "ROLE_" + r.toUpperCase()).toArray(String[]::new);
			return new User(customer.getEmail(), customer.getPassword(), AuthorityUtils.createAuthorityList(roles));
		}
		
		Optional<Provider> providerOptional = providerRepository.findById(email);
		if (providerOptional.isPresent()) {
			Provider provider = providerOptional.get();
			String[] roles = provider.getRoles().stream().map(r -> "ROLE_" + r.toUpperCase()).toArray(String[]::new);
			return new User(provider.getEmail(), provider.getPassword(), AuthorityUtils.createAuthorityList(roles));
		}
		
		throw new UsernameNotFoundException("User not found with email: " + email);
		
	}

}
