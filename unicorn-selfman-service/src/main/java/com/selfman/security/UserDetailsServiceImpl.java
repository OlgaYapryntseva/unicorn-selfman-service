package com.selfman.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.selfman.provider.dao.ProviderRepository;
import com.selfman.provider.model.Provider;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
	final ProviderRepository providerRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Provider provider = providerRepository.findById(email)
				.orElseThrow(() -> new UsernameNotFoundException(email));
		String[] roles = provider.getRoles()
										.stream()
										.map(r -> "ROLE_" + r.toUpperCase())
										.toArray(String[]::new);
		return new User(provider.getEmail(), provider.getPassword(), AuthorityUtils.createAuthorityList(roles));
	}
}
