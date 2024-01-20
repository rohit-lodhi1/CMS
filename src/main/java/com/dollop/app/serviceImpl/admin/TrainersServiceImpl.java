package com.dollop.app.serviceImpl.admin;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.Trainers;
import com.dollop.app.entity.TrainingList;
import com.dollop.app.entity.payload.TrainerRequest;
import com.dollop.app.entity.payload.TrainerResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.TrainersRepository;
import com.dollop.app.service.admin.ITrainersService;


@Service
public class TrainersServiceImpl implements ITrainersService {
	@Autowired
	private TrainersRepository trainersRepository;

	@Autowired
	private ModelMapper modelMapper;

	public TrainerResponse trainerToTrainerResponse(Trainers trainer) {
		return this.modelMapper.map(trainer, TrainerResponse.class);
	}

	public Trainers trainerResquestToTrainer(TrainerRequest trainerRequest) {
		return this.modelMapper.map(trainerRequest, Trainers.class);
	}

	// Create Trainers
	@Override
	public TrainerResponse addTrainers(TrainerRequest trainers) {
		Trainers trainer = this.trainersRepository.save(this.trainerResquestToTrainer(trainers));
		return this.trainerToTrainerResponse(trainer);
	}

	// Trainers get by id
	@Override
	public TrainerResponse getTrainersById(Integer id) {
		Trainers trainers = this.trainersRepository.findByIdAndIsDeleted(id,false)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.TRAINERS_NOT_FOUND + id));
           System.err.println(trainers);
		return this.trainerToTrainerResponse(trainers);
	}

	// Update Trainers
	@Override
	public TrainerResponse updateTrainers(TrainerRequest trainers) {
		Trainers trainer = this.trainersRepository.findById(trainers.getId())
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.TRAINERS_NOT_FOUND + trainers.getId()));
		trainer.setFirstName(trainers.getFirstName());
		trainer.setLastName(trainers.getLastName());
		trainer.setPhone(trainers.getPhone());
		trainer.setDescription(trainers.getDescription());
		trainer.setEmail(trainers.getEmail());
		trainer.setStatus(trainers.getStatus());
		return this.trainerToTrainerResponse(this.trainersRepository.save(trainer));
	}

	// Trainers git all list
	@Override
	public Page<TrainerResponse> getAllTrainers(Integer pageNo, Integer pageSize) {
		PageRequest page = PageRequest.of(pageNo, pageSize);
		Page<Trainers> trainers = this.trainersRepository.findByIsDeleted(page,false);

		return trainers.map( t -> this.trainerToTrainerResponse(t));
	}

// Trainers delete by id 
	@Override
	public Boolean deleteTrainers(Integer id) {
			Trainers trainers = this.trainersRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.TRAINERS_NOT_FOUND + id));

		trainers.setIsDeleted(true);
		this.trainersRepository.save(trainers);
		return true;
	}

	@Override
	public TrainerResponse getTrainingListByStatus(Integer id, String status) {
		Trainers trainingLis = this.trainersRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.TRAINERS_NOT_FOUND + id));
		trainingLis.setStatus(status);
		return this.trainerToTrainerResponse(this.trainersRepository.save(trainingLis));

	}


}
