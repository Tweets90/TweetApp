package com.tweetapp.modal;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="UserTable")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@ToString
public class UserModal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	
	private String firstName;
	private String lastName;
	
	@Column(unique=true)
	private String username;
	
	@Column(unique=true)
	private String email;
	
	private String password;
	
	private String contactNumber;
	
	
}

