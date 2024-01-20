package com.dollop.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.BankInformation;
import com.dollop.app.entity.FamilyInformations;
import com.dollop.app.entity.Users;

public interface BankInformationRepository extends JpaRepository<BankInformation,Integer> {


	public	Optional<BankInformation> findByIdAndIsDelete(Integer id, boolean b);

	public Optional<BankInformation> findByUserAndIsDelete(Users users, boolean b);
	

}
