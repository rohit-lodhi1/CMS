package com.dollop.app.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.TimeSheets;
import com.dollop.app.entity.Trainers;

public interface TrainersRepository extends JpaRepository<Trainers, Integer> {
	public Page<Trainers> findByStatus(PageRequest pageRequest, String status);

	public Optional<Trainers> findByIdAndIsDeleted(Integer id, boolean b);

	public Page<Trainers> findByIsDeleted(PageRequest page, boolean b);

}
