package com.dollop.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.EducationInformations;
import com.dollop.app.entity.ExperienceInformations;
import com.dollop.app.entity.Users;

public interface ExperienceInformationsRepository extends JpaRepository<ExperienceInformations,Integer> {
	
	public	Optional<ExperienceInformations> findByIdAndIsDelete(Integer id, boolean b);
	

	public List<ExperienceInformations> findByUser(Users users);

}
