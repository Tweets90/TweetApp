package com.tweetapp.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.tweetapp.helper.JwtUtil;
import com.tweetapp.service.CustomUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String requestTokenHeader = request.getHeader("Authorization");
		String email=null;
		String token=null;
		
		
		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer ")) {
			
			token=requestTokenHeader.substring(7);
			try {
				
				
				email=this.jwtUtil.getUsernameFromToken(token);
				System.out.println("filter=>"+email);
				
				
				
				
			}catch(Exception e) {
				e.printStackTrace();
				
			}
			
			// security
			
			UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(email);
			
			if(email!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				
			}
			else {
				System.out.println("Token not valid!!!");
			}
			
			
			
			
			
			
		}
		
		filterChain.doFilter(request, response);
		
	}

}
