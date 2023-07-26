package com.securitydemo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.securitydemo.model.Customer;
import com.securitydemo.repository.CustomerRepository;

@Service
public class UserDetails implements UserDetailsService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
		String userName=null, password=null;
		List<GrantedAuthority> authorirties = null;
		List<Customer> customer= customerRepository.findByEmail(username);
		if(customer.size()==0) {
			throw new UsernameNotFoundException("With this Details User not available: "+username);
		}else {
			userName = customer.get(0).getEmail();
			password = customer.get(0).getPwd();
			authorirties = new ArrayList<>();
			authorirties.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
		}
		
		return new User(username,password,authorirties);
	}

}
