package com.selfman.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;

import jakarta.servlet.DispatcherType;


@Configuration
@EnableWebSecurity
public class AuthorizationConfiguration {

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.authorizeHttpRequests(authorize -> authorize.
//        		dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR).permitAll()
        		dispatcherTypeMatchers(DispatcherType.ERROR).permitAll()
				.requestMatchers("/customer/register", "/provider/register")
					.permitAll()
					
				.requestMatchers("/customer/user/{email}/role/{role}")
					.hasRole("ADMINISTRATOR")
				.requestMatchers(HttpMethod.PUT, "/customer/user/{email}")
					.access(new WebExpressionAuthorizationManager("#email == authentication.name"))
				.requestMatchers(HttpMethod.DELETE, "/customer/user/{email}")
					.access(new WebExpressionAuthorizationManager("#email == authentication.name or hasRole('ADMINISTRATOR')"))
	
				.requestMatchers(HttpMethod.PUT, "/provider/{email}/")
					.access(new WebExpressionAuthorizationManager("#email == authentication.name"))
				.requestMatchers(HttpMethod.DELETE, "/provider/{email}")
					.access(new WebExpressionAuthorizationManager("#email == authentication.name or hasRole('ADMINISTRATOR')"))
				
				.requestMatchers(HttpMethod.POST, "/business")
					.access(new WebExpressionAuthorizationManager("hasRole('CUSTOMER') and hasRole('VERIFIED') or hasRole('ADMINISTRATOR')"))
				.requestMatchers(HttpMethod.PUT, "/business/{id}/{status}")
					.access(new WebExpressionAuthorizationManager("hasRole('PROVIDER') and hasRole('VERIFIED') or hasRole('ADMINISTRATOR')"))
				.requestMatchers(HttpMethod.GET, "/business/customer/{email}")
					.access(new WebExpressionAuthorizationManager("#email == authentication.name or hasRole('ADMINISTRATOR')"))
				.requestMatchers(HttpMethod.GET, "/business/provider/{email}")
					.access(new WebExpressionAuthorizationManager("#email == authentication.name or hasRole('ADMINISTRATOR')"))	
					
//				.requestMatchers("/business","/business/**").hasAnyRole("CUSTOMER", "PROVIDER")
				.requestMatchers("/provider/{email}/items", "/provider/{email}/item/**", "/provider/items/**").authenticated()
				.anyRequest()
					.authenticated()
		);
		return http.build();
	}
	
	
}