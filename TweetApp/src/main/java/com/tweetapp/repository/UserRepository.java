package com.tweetapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tweetapp.modal.UserModal;


@Repository
public interface UserRepository extends JpaRepository<UserModal, Integer> {
	
	public UserModal findByUsername(String username);
}
