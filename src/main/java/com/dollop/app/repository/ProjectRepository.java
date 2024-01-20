package com.dollop.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dollop.app.entity.Clients;
import com.dollop.app.entity.Projects;
import com.dollop.app.entity.Users;

public interface ProjectRepository extends JpaRepository<Projects, Integer>{

	public Page<Projects> findByClientId(Pageable pageable,Clients client);
	
	public Page<Projects> findByDeleted(Pageable pageable,Boolean deleted);


    public Optional<Projects> findByIdAndDeleted(Integer id, boolean b);


}
