package com.dollop.app.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.Attendance;
import com.dollop.app.entity.Clients;

public interface ClientsRepository extends JpaRepository<Clients,Integer> {

	public Page<Clients> findByDeleted(PageRequest page,Boolean deleted);
	
	public	Optional<Clients> findByIdAndDeleted(Integer id, boolean b);
	
	
}
