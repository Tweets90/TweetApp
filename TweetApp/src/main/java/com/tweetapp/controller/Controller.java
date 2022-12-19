package com.tweetapp.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.helper.JwtRequest;
import com.tweetapp.helper.JwtResponse;
import com.tweetapp.helper.JwtUtil;
import com.tweetapp.modal.UserModal;
import com.tweetapp.service.CustomUserDetailsService;
import com.tweetapp.serviceImplementation.RegisterServiceImplementation;


@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class Controller {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	

	
	@Autowired
	private JwtUtil jwtUtil;
	
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	
	@GetMapping("/check")
	private String check() {
		return "hello";
	}
	
	
	
	
	@Autowired
	private RegisterServiceImplementation registerService;

	@PostMapping("/user-register")
	public ResponseEntity<UserModal> userRegisterData(@RequestBody UserModal userdata) {
		
		UserModal user=this.registerService.addUser(userdata);

		return  new ResponseEntity<UserModal>(user,HttpStatus.OK);
	}
	
	@PostMapping("/token")
	public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest jwtRequest) throws Exception {
		
		System.out.println("jwt"+jwtRequest);
		
		try {
			
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
			
			
		}catch(UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("User Not Found");
		}catch(BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials!!!");
		}
		
		UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		System.out.println("-->>."+userDetails);
		String token = this.jwtUtil.generateToken(userDetails);
		String username=userDetails.getUsername();
		String password=userDetails.getPassword();
		Collection<? extends GrantedAuthority> authority=userDetails.getAuthorities();
		
	
		
		
		return ResponseEntity.ok(new JwtResponse(token,username,password));
//		return null;
		
		
	}

}
