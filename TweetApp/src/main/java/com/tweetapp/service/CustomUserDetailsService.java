package com.tweetapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tweetapp.modal.CustomUserDetails;
import com.tweetapp.modal.UserModal;
import com.tweetapp.repository.UserRepository;



@Service
public class CustomUserDetailsService  implements UserDetailsService{
	
	@Autowired
	private UserRepository registerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		// TODO Auto-generated method stub
		UserModal data=this.registerRepository.findByUsername(username);
		
		
		System.out.println("data"+data);
		
		if(data==null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		
		return new CustomUserDetails(data);
		
	}

}
