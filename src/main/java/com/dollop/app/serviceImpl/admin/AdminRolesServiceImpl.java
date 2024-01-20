package com.dollop.app.serviceImpl.admin;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.Roles;
import com.dollop.app.entity.payload.admin.AdminRoleRequest;
import com.dollop.app.entity.payload.admin.AdminRoleResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.exception.ResourcesAlreadyExists;
import com.dollop.app.repository.RolesRepository;
import com.dollop.app.service.admin.IAdminRoleService;
import com.dollop.app.utils.RoleUtils;

@Service
public class AdminRolesServiceImpl implements IAdminRoleService {

	@Autowired
	private RolesRepository rolesRepository;

	@Autowired
	private RoleUtils roleUtils;



	public AdminRoleResponse adminRoleToAdminRoleResponse(Roles roles) {
		AdminRoleResponse roleResponse = new AdminRoleResponse();
		roleResponse.setTitle(roles.getTitle());
		roleResponse.setId(roles.getId());
		roleResponse.setDeleted(roles.getDeleted());
		return roleResponse;
		// return this.modelMapper.map(roles, AdminRoleResponse.class);
	}

	public Roles adminRoleRequestToAdminRole(AdminRoleRequest roles) {
		Roles role = new Roles();
		role.setId(roles.getId());
		role.setTitle(roles.getTitle());
		role.setDeleted(roles.getDeleted());
		return role;
	}

	@Override
	public AdminRoleResponse addRole(AdminRoleRequest request) {
		Boolean isPresent  = this.rolesRepository.existsByTitle(request.getTitle());
		if(isPresent)
        throw new ResourcesAlreadyExists(AppConstants.ROLE_NOT_FOUND+request.getTitle());
		
		Roles role = this.adminRoleRequestToAdminRole(request);
		role.setPermissions(this.roleUtils.getDefaultPermission());
		role = this.rolesRepository.save(role);
		return this.adminRoleToAdminRoleResponse(role);
	}

	@Override
	public AdminRoleResponse updateRole(AdminRoleRequest request) {
		Roles role = this.rolesRepository.findById(request.getId())
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.ROLE_NOT_FOUND + request.getId()));
		role.setTitle(request.getTitle());
		role = this.rolesRepository.save(role);
		return this.adminRoleToAdminRoleResponse(role);
	}

	@Override
	public AdminRoleResponse getRole(Integer id) {
		Roles role = this.rolesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.ROLE_NOT_FOUND + id));
		return this.adminRoleToAdminRoleResponse(role);
	}

	@Override
	public Boolean deleteRoleById(Integer id) {
		if (this.rolesRepository.existsById(id)) {
			this.rolesRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<AdminRoleResponse> getAllRoles() {
		List<Roles> roles = this.rolesRepository.findAll();

		return roles.stream().map(r -> this.adminRoleToAdminRoleResponse(r)).collect(Collectors.toList());
	}

	
}
