package com.dollop.app.service.employee;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.UsersRequest;
import com.dollop.app.entity.payload.UsersResponse;

public interface IUsersService {
	
       public UsersResponse addUser(UsersRequest users,MultipartFile profile); 
	   
       public UsersResponse updateUser(UsersRequest users, MultipartFile file);
	   
       public UsersResponse getUsersById(Integer id);
       
       public Page<UsersResponse>searchUsers(int pageNO,int pageSize, UsersRequest usersRequest);
       


	   
}
