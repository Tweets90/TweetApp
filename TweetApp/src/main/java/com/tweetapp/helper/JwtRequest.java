package com.tweetapp.helper;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class JwtRequest {
	
	private String username;
	private String password;
	

}
