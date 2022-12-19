package com.tweetapp.service;

import java.util.List;

import com.tweetapp.modal.UserModal;


public interface RegisterService {
	
	public UserModal addUser(UserModal userdata);
	public List<UserModal> getAllUser();
	public UserModal getUserData(String email);

}
