package com.securitydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

	@Bean
	public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeHttpRequests().requestMatchers("/get","/update").authenticated()
	    .requestMatchers("/delete","/add","/register").permitAll();
		http.formLogin();
		http.httpBasic();
				
		return http.build();
	}
	
	public UserDetailsService userDetailsService(){
		return new JdbcUserDetailsManager();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
		
	}
	
	
//	@Bean
//	public InMemoryUserDetailsManager userDetailsService() {
//		
//		UserDetails admin = User.withDefaultPasswordEncoder().username("pradip").password("12345").roles("admin")
//				.build();
//		UserDetails user = User.withDefaultPasswordEncoder().username("akash").password("54321").roles("user")
//				.build();
//		return new InMemoryUserDetailsManager(admin, user);
//		
//	}
//	
	
//	@Bean
//	public InMemoryUserDetailsManager userDetailsService() {
//		InMemoryUserDetailsManager inMemoryUserDetailsManager=new InMemoryUserDetailsManager();
//		UserDetails admin=User.withUsername("pradip").password("12345").authorities("admin").build();
//		UserDetails user= User.withUsername("akash").password("54321").authorities("user").build();
//		inMemoryUserDetailsManager.createUser(admin);
//		inMemoryUserDetailsManager.createUser(user);
//		return inMemoryUserDetailsManager;	
//	}
	
	
	
}
