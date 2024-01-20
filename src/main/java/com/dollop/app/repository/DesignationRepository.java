package com.dollop.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.app.entity.Department;
import com.dollop.app.entity.Designation;

public interface DesignationRepository extends JpaRepository<Designation, Integer> {

	public List<Designation> findByDepartment(Department departmentId);

	public List<Designation> findByIsDeleted(Boolean isDeleted);

	public Optional<Designation> findByIdAndIsDeleted(Integer id, boolean b);

	public boolean existsByTitle(String title);
	public Optional<Designation> findByTitle(String title);

}
