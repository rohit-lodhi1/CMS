package com.dollop.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.EmergencyContact;
import com.dollop.app.entity.PersonalInformations;
import com.dollop.app.entity.Users;

public interface EmergencyContactRepository extends JpaRepository<EmergencyContact,Integer>{



public Optional<EmergencyContact> findByUserAndIsDelete(Users users, boolean b);


}
