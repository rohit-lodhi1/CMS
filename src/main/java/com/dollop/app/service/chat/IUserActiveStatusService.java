package com.dollop.app.service.chat;

import org.springframework.http.ResponseEntity;

import com.dollop.app.entity.payload.chat.UserStatusResponse;
import com.dollop.app.entity.payload.chat.UserStatusUpdateRequest;

public interface IUserActiveStatusService {
	
	public UserStatusResponse createUserStatus(Integer id);

	UserStatusResponse updateUserStatus(UserStatusUpdateRequest request);

	UserStatusResponse getUserStatusByUserId(Integer id);
}
