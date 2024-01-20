package com.dollop.app.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.PersonalInformations;
import com.dollop.app.entity.Users;

public interface PersonalInformationsRepository extends JpaRepository<PersonalInformations,Integer>{
	


public Optional<PersonalInformations> findByUserAndIsDelete(Users users, boolean b);


}
