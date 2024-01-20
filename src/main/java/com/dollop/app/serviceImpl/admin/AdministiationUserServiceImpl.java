package com.dollop.app.serviceImpl.admin;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.UsersRequest;
import com.dollop.app.entity.payload.admin.AdministiationUserRequest;
import com.dollop.app.entity.payload.admin.AdministiationUserResponse;
import com.dollop.app.exception.UserNotFoundException;
import com.dollop.app.repository.UsersRepository;
import com.dollop.app.service.admin.IAdministiationUserService;

@Service
public class AdministiationUserServiceImpl implements IAdministiationUserService {

	@Autowired
	public UsersRepository usersRepository;

	@Autowired
	private ModelMapper modelMapper;

	public AdministiationUserResponse administiationUserToAdministiationUserResponse(Users user) {
		return this.modelMapper.map(user, AdministiationUserResponse.class);
	}

	public Users administiationUserRequestToAdministiationUser(AdministiationUserRequest usersRequest) {
		return this.modelMapper.map(usersRequest, Users.class);
	}

	@Override
	public AdministiationUserResponse updateUser(AdministiationUserRequest users) {
		Users user = this.usersRepository.findById(users.getId())
				.orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND_ + users.getId()));
		user.setEmail(users.getEmail());
		user.setFirstName(users.getFirstName());
		user.setLastName(users.getLastName());
		user.setCreatedAt(users.getCreatedAt());

		return this.administiationUserToAdministiationUserResponse(this.usersRepository.save(user));

	}

	@Override
	public AdministiationUserResponse getUsersById(Integer id) {
		Users user = this.usersRepository.findByIdAndDeleted(id, false)
				.orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND_ + id));
		return this.administiationUserToAdministiationUserResponse(user);
	}

	@Override
	public Page<AdministiationUserResponse> getAllUsers(Integer pageNo, Integer pageSize) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Page<Users> page = this.usersRepository.findByDeleted(pageRequest, false);
		return page.map(u -> this.administiationUserToAdministiationUserResponse(u));
	}

	@Override
	public Boolean deleteUsers(Integer id) {
		Users user = this.usersRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND_ + id));
		user.setDeleted(true);
		this.usersRepository.save(user);
		return true;

	}

	@Override
	public Page<AdministiationUserResponse> searchUser(Integer pageNo, Integer pageSize, UsersRequest user) {
		// TODO Auto-generated method stub
		return null;
	}

}
