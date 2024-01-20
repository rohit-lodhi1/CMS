package com.dollop.app.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.EducationInformations;
import com.dollop.app.entity.ExperienceInformations;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.EducationInformationsRequest;
import com.dollop.app.entity.payload.ExperienceInformationsRequest;
import com.dollop.app.entity.payload.ExperienceInformationsResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.ExperienceInformationsRepository;
import com.dollop.app.repository.UsersRepository;
import com.dollop.app.service.IExperienceInformationsService;

@Service
public class ExperienceInformationsServiceImpl implements IExperienceInformationsService {

	@Autowired
	public UsersRepository usersRepository;

	@Autowired
	public ExperienceInformationsRepository experienceInformationsRepository;

	@Autowired
	private ModelMapper modelMapper;

	public ExperienceInformationsResponse experienceInformationsToExperienceInformationsResponse(
			ExperienceInformations experienceInformations) {
		return this.modelMapper.map(experienceInformations, ExperienceInformationsResponse.class);
	}

	public ExperienceInformations experienceInformationsRequestToExperienceInformations(
			ExperienceInformationsRequest experienceInformationsRequest) {
		return this.modelMapper.map(experienceInformationsRequest, ExperienceInformations.class);
	}

	@Override
	public List<ExperienceInformationsResponse> addExperienceInformations(
			List<ExperienceInformationsRequest> experienceInformationsRequests, Integer userId) {

		Users users = this.usersRepository.findByIdAndDeleted(userId, false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.USER_NOT_FOUND + userId));
		List<ExperienceInformationsResponse> list = new ArrayList<>();

		experienceInformationsRequests.stream().forEach(m -> {
			ExperienceInformations experienceInformations = this
					.experienceInformationsRequestToExperienceInformations(m);
			experienceInformations.setUser(users);
			list.add(this.experienceInformationsToExperienceInformationsResponse(
					this.experienceInformationsRepository.save(experienceInformations)));
		});

		return list;
	}

	@Override
	public List<ExperienceInformationsResponse> getAllExperienceInformations(Integer userProfileId) {

		List<ExperienceInformations> experienceInformations = this.experienceInformationsRepository
				.findByUser(new Users(userProfileId));

		return experienceInformations.stream()
				.map(ef -> this.experienceInformationsToExperienceInformationsResponse(ef))
				.collect(Collectors.toList());
	}

	@Override
	public ExperienceInformationsResponse getExperienceInformationsByID(Integer id) {
		ExperienceInformations educationInformations = this.experienceInformationsRepository
				.findByIdAndIsDelete(id, false).orElseThrow(
						() -> new ResourceNotFoundException(AppConstants.EXPERIENCE_IN_FORMMATIONS_NOT_FOUND + id));
		return this.experienceInformationsToExperienceInformationsResponse(educationInformations);

	}
}
