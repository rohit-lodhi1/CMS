package com.dollop.app.serviceImpl.admin;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.Department;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.DepartmentRequest;
import com.dollop.app.entity.payload.DepartmentResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.exception.ResourcesAlreadyExists;
import com.dollop.app.repository.DepartmentRepository;
import com.dollop.app.service.admin.IDepartmentService;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private ModelMapper modelMapper;

	public DepartmentResponse departmentToDepartmentResponse(Department department) {
		return this.modelMapper.map(department, DepartmentResponse.class);
	}

	public Department departmentRequestToDepartment(DepartmentRequest department) {
		return this.modelMapper.map(department, Department.class);
	}

	// add Department
	@Override
	public DepartmentResponse createDepartment(DepartmentRequest department) {

		department.setIsDeleted(false);
		department.setIsActive(true);
		Optional<Department> d = this.departmentRepository.findByTitle(department.getTitle());
		if (!this.departmentRepository.existsByTitle(department.getTitle())) {
			Department dept = this.departmentRepository.save(this.modelMapper.map(department, Department.class));
			return this.departmentToDepartmentResponse(dept);

		}
		throw new ResourcesAlreadyExists(AppConstants.DEPARTMENT_ALREADY_EXIST + department.getTitle());
	}

	// update Department
	@Override
	public DepartmentResponse updateDepartment(DepartmentRequest department) {
		Department dept = this.departmentRepository.findById(department.getId()).orElseThrow(
				() -> new ResourceNotFoundException(AppConstants.DEPARTMENT_NOT_FOUND + department.getId()));
		dept.setTitle(department.getTitle());
		dept.setDescription(department.getDescription());
		dept.setIsActive(department.getIsActive());
		dept.setTitle(department.getTitle());

		return this.departmentToDepartmentResponse(this.departmentRepository.save(dept));
	}

	// get Department by id
	@Override
	public DepartmentResponse getDepartmentById(Integer departmentId) {
		Department department = this.departmentRepository.findByIdAndIsDeleted(departmentId, false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.DEPARTMENT_NOT_FOUND + departmentId));
			return this.departmentToDepartmentResponse(department);
	}

	// get all department
	@Override
	public List<DepartmentResponse> getAllDeparments() {
		List<Department> departments = this.departmentRepository.findByIsDeleted(false);

		return departments.stream().map(dept -> this.departmentToDepartmentResponse(dept)).collect(Collectors.toList());

	}

	// delete Department
	@Override
	public Boolean deleteDepartment(Integer id) {
		Department department = this.departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.DEPARTMENT_NOT_FOUND + id));
		department.setIsDeleted(true);
		this.departmentRepository.save(department);
		return true;
	}

	// filter search
	@Override
	public Page<DepartmentResponse> searchDepartment(Integer pageNo, Integer pageSize,
			DepartmentRequest departmentRequest) {

		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues() // ignoring null values of variable
				.withIgnoreCase() // ignoring case of letters
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) // contains for string
				.withMatcher("id", match -> match.transform(value -> value.map(id -> ((Integer) id == 0) ? null : id))); // for

		// for

		Example<Department> example = Example.of(this.departmentRequestToDepartment(departmentRequest), matcher);
		List<Department> list = this.departmentRepository.findAll(example);

		return new PageImpl<DepartmentResponse>(
				list.stream().map(d -> this.departmentToDepartmentResponse(d)).collect(Collectors.toList()));
	}

}
