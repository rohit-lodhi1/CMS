package com.dollop.app.serviceImpl.admin;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.Assets;
import com.dollop.app.entity.TrainingType;
import com.dollop.app.entity.payload.AssetsRequest;
import com.dollop.app.entity.payload.AssetsResponse;
import com.dollop.app.entity.payload.TrainingTypeRequest;
import com.dollop.app.entity.payload.TrainingTypeResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.TrainingTypeRepository;
import com.dollop.app.service.admin.ITrainingTypeService;

@Service
public class TrainingTypeServiceImpl implements ITrainingTypeService {
	@Autowired
	private TrainingTypeRepository trainingTypeRepository;

	@Autowired
	private ModelMapper modelMapper;

	public TrainingTypeResponse trainingTypeToTrainingTypeResponse(TrainingType trainingType) {
		return this.modelMapper.map(trainingType, TrainingTypeResponse.class);
	}

	public TrainingType trainingTypeRequestToTrainingType(TrainingTypeRequest trainingTypeRequest) {
		return this.modelMapper.map(trainingTypeRequest, TrainingType.class);
	}

	@Override
	public TrainingTypeResponse addTrainingType(TrainingTypeRequest trainingTypeRequest) {
		TrainingType trainingType = this.trainingTypeRequestToTrainingType(trainingTypeRequest);
		return this.trainingTypeToTrainingTypeResponse(this.trainingTypeRepository.save(trainingType));

	}

	@Override
	public TrainingTypeResponse getTrainingTypeById(Integer id) {
		TrainingType trainingType = this.trainingTypeRepository.findByIdAndIsDelete(id,false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.TRAINING_TYPE_NOT_FOUND_WITH_ID + id));
		return this.trainingTypeToTrainingTypeResponse(trainingType);

	}

	@Override
	public TrainingTypeResponse updateTrainingType(TrainingTypeRequest trainingTypeRequest) {
		TrainingType trainingType = this.trainingTypeRepository.findById(trainingTypeRequest.getId())
				.orElseThrow(() -> new ResourceNotFoundException(
						AppConstants.TRAINING_TYPE_NOT_FOUND_WITH_ID  + trainingTypeRequest.getId()));
		trainingType.setDescription(trainingTypeRequest.getDescription());
		trainingType.setType(trainingTypeRequest.getType());
		trainingType.setIsDelete(trainingTypeRequest.getIsDelete());

		return this.trainingTypeToTrainingTypeResponse(this.trainingTypeRepository.save(trainingType));
	}

	@Override
	public Page<TrainingTypeResponse> getAllTrainingType(Integer pageNo, Integer pageSize) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Page<TrainingType> page = this.trainingTypeRepository.findByIsDelete(pageRequest, false);

		return page.map(c -> this.trainingTypeToTrainingTypeResponse(c));
	}

	@Override
	public Boolean deleteTrainingType(Integer id) {
		TrainingType trainingType = this.trainingTypeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.TRAINING_TYPE_NOT_FOUND_WITH_ID + id));
		trainingType.setIsDelete(true);
		this.trainingTypeRepository.save(trainingType);
		return true;
	}

	@Override
	public TrainingTypeResponse getTrainingTypeByStatus(Integer id, String status) {
		TrainingType trainingType = this.trainingTypeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.TRAINING_TYPE_NOT_FOUND_WITH_ID + id));
		trainingType.setStatus(status);
		return this.trainingTypeToTrainingTypeResponse(this.trainingTypeRepository.save(trainingType));

	}

}
