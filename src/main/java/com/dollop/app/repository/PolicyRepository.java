package com.dollop.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Integer>{
	
	

}
