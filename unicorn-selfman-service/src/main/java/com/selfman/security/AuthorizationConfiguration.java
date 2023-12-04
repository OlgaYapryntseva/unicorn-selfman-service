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
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS));
        http.authorizeHttpRequests(authorize -> authorize.
        		dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR).permitAll()
				.requestMatchers("/customer/register")
					.permitAll()
				.requestMatchers("/customer/user/{email}/role/{role}")
					.hasRole("ADMINISTRATOR")
				.requestMatchers(HttpMethod.PUT, "/customer/login/{email}")
					.access(new WebExpressionAuthorizationManager("#email == authentication.name"))
				.requestMatchers(HttpMethod.DELETE, "/customer/user/{email}")
					.access(new WebExpressionAuthorizationManager("#email == authentication.name or hasRole('ADMINISTRATOR')"))
				.anyRequest()
					.authenticated()
		);
		return http.build();
	}
}