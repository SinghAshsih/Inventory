package com.inventory.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity // 1
public class WebSecurityConfig {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	WebSecurityCustomizer ignoringCustomizer() { // 3
		return (web) -> web.ignoring().requestMatchers(HttpMethod.GET).requestMatchers("/user");
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.cors(corsConfigurer -> corsConfigurer.configurationSource(corsConfiguration()))
				.csrf(AbstractHttpConfigurer::disable);
		http.authorizeHttpRequests(
				authorizeRequests -> authorizeRequests.requestMatchers("/**").hasAnyAuthority("USER"))
				.httpBasic(withDefaults());
		return http.build();
	}

	@Bean
	CorsConfigurationSource corsConfiguration() {
		return request -> {
			org.springframework.web.cors.CorsConfiguration config = new org.springframework.web.cors.CorsConfiguration();
			config.setAllowedHeaders(Collections.singletonList("*"));
			config.setAllowedMethods(Collections.singletonList("*"));
			config.setAllowedOriginPatterns(Collections.singletonList("*"));
			config.setAllowCredentials(true);
			return config;
		};
	}
}
