package com.tweet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TweetAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TweetAppApplication.class, args);
	}
	
    /*
     * @Bean
     * public ModelMapper modelMapper() {
     * return new ModelMapper();
     * }
     */

}
