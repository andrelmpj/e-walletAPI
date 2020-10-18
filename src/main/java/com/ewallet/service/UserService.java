package com.ewallet.service;

import java.util.Optional;

import com.ewallet.entity.User;

public interface UserService {

	 User save(User u);
	 
	 Optional<User> findByEmail(String email);
}
