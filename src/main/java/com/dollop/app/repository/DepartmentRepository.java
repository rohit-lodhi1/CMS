package com.dollop.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.Attendance;
import com.dollop.app.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	public Optional<Department> findByTitle(String title);

	public List<Department> findByIsDeleted(Boolean isDeleted);

	public Optional<Department> findByIdAndIsDeleted(Integer id, boolean b);

	public boolean existsByTitle(String title);

}
