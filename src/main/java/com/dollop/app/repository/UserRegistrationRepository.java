package com.dollop.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dollop.app.entity.UserRegistration;

public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Integer>{

	public Optional<UserRegistration> findByEmail(String email);
	
	public Boolean existsByEmail(String email);
	
	public Boolean existsByEmailAndActive(String email,Boolean active);
	
	public Optional<UserRegistration> findByEmailAndActive(String email,Boolean active);

	
}
