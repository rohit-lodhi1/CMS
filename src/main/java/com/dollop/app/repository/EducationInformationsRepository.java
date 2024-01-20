package com.dollop.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.EducationInformations;
import com.dollop.app.entity.PersonalInformations;
import com.dollop.app.entity.Users;

public interface EducationInformationsRepository extends JpaRepository<EducationInformations,Integer>{
	
	public	Optional<EducationInformations> findByIdAndIsDelete(Integer id, boolean b);

	
	public List<EducationInformations> findByUserAndIsDelete(Users users,boolean deleted);

}
