package com.dollop.app.service.admin;

import java.security.Principal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.UsersRequest;
import com.dollop.app.entity.payload.UsersResponse;
import com.dollop.app.listPayloads.UserListResponse;

public interface IUsersService {

	public  UsersResponse userToUserResponse(Users user);
	
	public  Users userRequestToUser(UsersRequest usersRequest);
	
	public UsersResponse addUser(UsersRequest users,String role,MultipartFile file);
	
	public UsersResponse addUserBasicDetails(UsersRequest users,MultipartFile file);


	public UsersResponse updateUser(UsersRequest users);

	
	Page<UsersResponse> getAllUsers(Integer pageNo, Integer pageSize, Principal p);

	public Boolean deleteUsers(Integer id);

	public UsersResponse getUserByfirstName(String firstName);

	public UsersResponse getUserByjobTitle(String jobTitle);

	public Page<UsersResponse> searchUser(Integer pageNo, Integer pageSize, UsersRequest user);

//	public Page<UsersResponse> getAllOwner(Integer pageNo,Integer pageSize);
	
	
	public List<UsersResponse> getByUserRole(String role);
	

	
	public List<Object[]> fetchAdminDashboardDetails();

	UsersResponse getUserById(Integer id);

	Page<UserListResponse> getAllUserByRole(Integer pageNo, Integer pageSize, Integer roleId,String currentUserEmail);



}
