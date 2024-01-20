package com.dollop.app.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.Tasks;
import com.dollop.app.entity.Termination;

public interface TerminationRepository extends JpaRepository<Termination, Integer> {

	public Page<Termination> findByIsDelete(PageRequest pageRequest, boolean b);

	public Optional<Termination> findByIdAndIsDelete(Integer id, boolean b);

}
