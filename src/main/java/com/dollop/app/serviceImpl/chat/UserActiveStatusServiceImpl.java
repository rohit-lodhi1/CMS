package com.dollop.app.serviceImpl.chat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.constant.UserChatStatus;
import com.dollop.app.entity.UserRegistration;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.chat.UserActiveStatus;
import com.dollop.app.entity.payload.chat.UserStatusResponse;
import com.dollop.app.entity.payload.chat.UserStatusUpdateRequest;
import com.dollop.app.exception.UserNotFoundException;
import com.dollop.app.repository.UserActiveStatusRepository;
import com.dollop.app.repository.UsersRepository;
import com.dollop.app.service.chat.IUserActiveStatusService;

@Service
public class UserActiveStatusServiceImpl implements IUserActiveStatusService{

	@Autowired
	private UserActiveStatusRepository statusRepository;
	
	@Autowired
	private UsersRepository userRepository;
	
	
	@Override
	public UserStatusResponse updateUserStatus(UserStatusUpdateRequest request) {
		Optional<UserActiveStatus> userActiveStatus = this.statusRepository.findByUserId(request.getUserId());
		if(userActiveStatus.isEmpty()) {
		    return this.createUserStatus(request.getUserId());
		}
		
		UserActiveStatus status = userActiveStatus.get();
		System.err.println(request.getStatus());
		if(request.getStatus().equals(UserChatStatus.Online.toString()))
			status.setStatus(UserChatStatus.Online);
		else {
			status.setStatus(UserChatStatus.Offline);
			status.setLastActive(LocalDateTime.now());
		}
		
		 status=this.statusRepository.save(status);
	
		return this.userStatusToUserStatusResponse(status);
	}
	
	public UserStatusResponse userStatusToUserStatusResponse(UserActiveStatus status) {
		UserStatusResponse response =new UserStatusResponse();
		response.setLastActive(status.getLastActive().toString());
		response.setIsShowable(status.getIsShowable());
		response.setStatus(status.getStatus().toString());
		response.setUserId(status.getUser().getId());
		return response;
	}

	@Override
	public UserStatusResponse createUserStatus(Integer id) {
		UserActiveStatus status = new UserActiveStatus();
		status.setLastActive(LocalDateTime.now());
		Users user = this.userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND));
		status.setUser(user);
		status.setStatus(UserChatStatus.Offline);
		this.statusRepository.save(status);
		return this.userStatusToUserStatusResponse(status);
	}

	@Override
	public UserStatusResponse getUserStatusByUserId(Integer id) {
		Optional<UserActiveStatus> status = this.statusRepository.findByUserId(id);
		if(status.isEmpty())
			return null;
			
		return this.userStatusToUserStatusResponse(status.get());
	}
	
}
