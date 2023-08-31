package com.inventory.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	StrictHttpFirewall httpFirewall() {
		StrictHttpFirewall firewall = new StrictHttpFirewall();
		firewall.setAllowedHttpMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
		return firewall;
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests(
				(authorizeRequests) -> authorizeRequests.requestMatchers("/user/**", "/**").hasAnyAuthority("USER"))
				.httpBasic(withDefaults()).csrf().disable();
		return http.build();
	}

	@Bean
	WebSecurityCustomizer ignoringCustomizer() {
		return (web) -> web.ignoring().requestMatchers(HttpMethod.GET).requestMatchers("/user");
	}
}
