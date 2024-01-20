package com.dollop.app.serviceImpl.admin;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.Roles;
import com.dollop.app.entity.UserRoles;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.admin.UserRoleRequest;
import com.dollop.app.entity.payload.admin.UserRoleResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.exception.UserNotFoundException;
import com.dollop.app.repository.RolesRepository;
import com.dollop.app.repository.UserRolesRepository;
import com.dollop.app.repository.UsersRepository;
import com.dollop.app.service.admin.IAdminUserRolesService;

@Service
public class AdminUserRolesServiceImpl implements IAdminUserRolesService{

	@Autowired
	private UserRolesRepository userRolesRepository;
	
	@Autowired
	private RolesRepository rolesRepository;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public UserRoleResponse userRoleToUserRoleResponse(UserRoles roles) {
		return this.modelMapper.map(roles, UserRoleResponse.class);
	}
	
	
	
	@Override
	public UserRoleResponse addUserRole(UserRoleRequest userRole) {

		Roles role = this.rolesRepository.findById(userRole.getRoleId()).orElseThrow(() -> new ResourceNotFoundException(AppConstants.ROLE_NOT_FOUND+userRole.getRoleId()));		
UserRoles  usRole = new UserRoles();
usRole.setRoles(role);
if(Objects.nonNull(userRole.getUserId()) && this.usersRepository.existsById(userRole.getUserId()))
{
	Users user = new Users();
	user.setId(userRole.getUserId());
	usRole.setUser(user);
}
else
	throw new UserNotFoundException(AppConstants.USER_NOT_FOUND+userRole.getUserId());
    usRole = this.userRolesRepository.save(usRole);

		return this.userRoleToUserRoleResponse(usRole);
	}

	@Override
	public UserRoleResponse updateUserRole(UserRoleRequest userRole) {
	    UserRoles usRole = this.userRolesRepository.findById(userRole.getId()).orElseThrow(() -> new ResourceNotFoundException(AppConstants.USER_ROLES_NOT_FOUND+ userRole.getId()));
		Roles role = this.rolesRepository.findById(userRole.getRoleId()).orElseThrow(() -> new ResourceNotFoundException(AppConstants.ROLE_NOT_FOUND+userRole.getRoleId()));		
		usRole.setRoles(role);
		if(!  this.usersRepository.existsById(usRole.getUser().getId()))
		      	throw new UserNotFoundException(AppConstants.USER_NOT_FOUND+userRole.getUserId());
		
		return this.userRoleToUserRoleResponse(this.userRolesRepository.save(usRole));
	}
	


	@Override
	public List<UserRoleResponse> getAllUserRole() {
		 List<UserRoles> list = this.userRolesRepository.findAll();

		return list.stream().map(ur -> this.userRoleToUserRoleResponse(ur)).collect(Collectors.toList());
				}



	@Override
	public UserRoleResponse getUserRoleById(Integer id) {
		   UserRoles usRole = this.userRolesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(AppConstants.USER_ROLES_NOT_FOUND+ id));
		   
		return this.userRoleToUserRoleResponse(usRole);
	}



	@Override
	public Boolean deleteUserRole(Integer id) {
       UserRoles userRole = this.userRolesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(AppConstants.USER_ROLES_NOT_FOUND + id) );
       this.userRolesRepository.deleteUserRoleById(id);
       return true;
       
	}



	@Override
	public List<UserRoleResponse> getUserRolesOfUser(Integer id) {
		Users user = new Users();
		user.setId(id);
		List<UserRoles> userRoles = this.userRolesRepository.findByUser(user);
	
		return userRoles.stream().map(u ->{
		   u.setUser(user);
		   return this.userRoleToUserRoleResponse(u);
		}		).collect(Collectors.toList());
		
	}

}
