package com.tweetapp.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetapp.modal.UserModal;
import com.tweetapp.repository.UserRepository;
import com.tweetapp.service.RegisterService;



@Service
public class RegisterServiceImplementation implements RegisterService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserModal addUser(UserModal userdata) {
		// TODO Auto-generated method stub
		return this.userRepository.save(userdata);
	}

	@Override
	public List<UserModal> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserModal getUserData(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
