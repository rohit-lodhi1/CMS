package com.dollop.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dollop.app.entity.chat.UserActiveStatus;

@Repository
public interface UserActiveStatusRepository extends JpaRepository<UserActiveStatus, Integer>{

	@Query("SELECT s FROM UserActiveStatus s WHERE s.user.id=:userId")
	Optional<UserActiveStatus> findByUserId(Integer userId);
	
}
