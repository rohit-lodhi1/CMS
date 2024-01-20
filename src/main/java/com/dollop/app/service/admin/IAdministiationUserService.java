package com.dollop.app.service.admin;

import org.springframework.data.domain.Page;
import com.dollop.app.entity.payload.UsersRequest;
import com.dollop.app.entity.payload.admin.AdministiationUserRequest;
import com.dollop.app.entity.payload.admin.AdministiationUserResponse;


public interface IAdministiationUserService {

	  public AdministiationUserResponse updateUser(AdministiationUserRequest users);
	   
      public AdministiationUserResponse getUsersById(Integer id);
      
  	public Page<AdministiationUserResponse> getAllUsers(Integer pageNo, Integer pageSize);

  	public Boolean deleteUsers(Integer id);
  	

	public Page<AdministiationUserResponse> searchUser(Integer pageNo, Integer pageSize, UsersRequest user);

  	
  	

	 
}
