package com.dollop.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.Assets;
import com.dollop.app.entity.ExperienceInformations;
import com.dollop.app.entity.FamilyInformations;
import com.dollop.app.entity.Users;

public interface FamilyInformationsRepository extends JpaRepository<FamilyInformations,Integer>{
	
	public	Optional<FamilyInformations> findByIdAndIsDelete(Integer id, boolean b);
	
	public	Page<FamilyInformations> findByIsDelete(PageRequest pageRequest, boolean b);

	public List<FamilyInformations> findByUserAndIsDelete(Users users, boolean b);


}
