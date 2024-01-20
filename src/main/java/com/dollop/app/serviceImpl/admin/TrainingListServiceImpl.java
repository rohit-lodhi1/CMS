package com.dollop.app.serviceImpl.admin;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.TrainingList;
import com.dollop.app.entity.TrainingType;
import com.dollop.app.entity.payload.TrainingListRequest;
import com.dollop.app.entity.payload.TrainingListResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.TrainingListRepository;
import com.dollop.app.service.admin.ITrainingListService;

@Service
public class TrainingListServiceImpl implements ITrainingListService {
	@Autowired
	private TrainingListRepository trainingListRepository;

	@Autowired
	private ModelMapper modelMapper;

	public TrainingListResponse trainingListToTrainingListResponse(TrainingList trainingList) {
		return this.modelMapper.map(trainingList, TrainingListResponse.class);
	}

	public TrainingList trainerListResquestToTrainerList(TrainingListRequest trainerRequest) {
		return this.modelMapper.map(trainerRequest, TrainingList.class);
	}

	@Override
	public TrainingListResponse addTrainingList(TrainingListRequest trainingListRequest) {
		
		TrainingList trainingList = this.trainerListResquestToTrainerList(trainingListRequest);
		return this.trainingListToTrainingListResponse(this.trainingListRepository.save(trainingList));
	}

	@Override
	public TrainingListResponse getTrainingListById(Integer id) {
		TrainingList trainingLis = this.trainingListRepository.findByIdAndDeleted(id, false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.TRAINING_LIST_NOT_FOUND + id));

		return this.trainingListToTrainingListResponse(trainingLis);

	}

	@Override
	public TrainingListResponse updateTrainingList(TrainingListRequest trainingListRequest) {
		TrainingList trainingLis = this.trainingListRepository.findById(trainingListRequest.getId())
				.orElseThrow(() -> new ResourceNotFoundException(
						AppConstants.TRAINING_LIST_NOT_FOUND + trainingListRequest.getId()));

		trainingLis.setEmployee(trainingListRequest.getEmployee());
		trainingLis.setEndDate(trainingListRequest.getEndDate());
		trainingLis.setStartDate(trainingListRequest.getStartDate());
		trainingLis.setStatus(trainingListRequest.getStatus());
		trainingLis.setTrainerCost(trainingListRequest.getTrainerCost());
		trainingLis.setTrainingType(trainingListRequest.getTrainingType());
		trainingLis.setTrainers(trainingListRequest.getTrainers());
		trainingLis.setDescription(trainingListRequest.getDescription());
		return this.trainingListToTrainingListResponse(this.trainingListRepository.save(trainingLis));
	}

	@Override
	public Page<TrainingListResponse> getAllTrainingList(Integer pageNo, Integer pageSize) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Page<TrainingList> page = this.trainingListRepository.findByDeleted(pageRequest, false);

		return page.map(c -> this.trainingListToTrainingListResponse(c));

	}

	@Override
	public Boolean deleteTrainingList(Integer id) {
		TrainingList trainingLis = this.trainingListRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.TRAINING_LIST_NOT_FOUND + id));
		trainingLis.setDeleted(true);
		this.trainingListRepository.save(trainingLis);
		return true;

	}

	@Override
	public TrainingListResponse getTrainingListByStatus(Integer id, String status) {
		TrainingList trainingLis = this.trainingListRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.TRAINING_LIST_NOT_FOUND + id));
		trainingLis.setStatus(status);
		return this.trainingListToTrainingListResponse(this.trainingListRepository.save(trainingLis));

	}

}
