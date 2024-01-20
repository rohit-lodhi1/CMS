package com.dollop.app.serviceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.AppliedCandidate;
import com.dollop.app.entity.Clients;
import com.dollop.app.entity.ManageJobs;
import com.dollop.app.entity.ProjectFiles;
import com.dollop.app.entity.Projects;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.AppliedCandidateRequest;
import com.dollop.app.entity.payload.AppliedCandidateResponse;
import com.dollop.app.entity.payload.admin.ProjectFilesRequest;
import com.dollop.app.entity.payload.admin.ProjectFilesResponse;
import com.dollop.app.entity.payload.admin.ProjectForAllResponse;
import com.dollop.app.entity.payload.admin.ProjectRequest;
import com.dollop.app.entity.payload.admin.ProjectResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.exception.UserNotFoundException;
import com.dollop.app.repository.AppliedCandidateRepository;
import com.dollop.app.repository.ManageJobsRepository;
import com.dollop.app.repository.ProjectFileRepository;
import com.dollop.app.repository.ProjectRepository;
import com.dollop.app.service.IAppliedCandidateService;
import com.dollop.app.service.admin.IClientsService;
import com.dollop.app.service.admin.IProjectFilesService;

@Service
public class AppliedCandidateServiceImpl implements IAppliedCandidateService {

	@Value("${appliedcandidate.file.path}")
	public String DIRECTORY;

	@Autowired
	private AppliedCandidateRepository candidateRepository;
	@Autowired
	private ManageJobsRepository manageJobsRepository;


	@Autowired
	private ModelMapper modelMapper;

	public AppliedCandidateResponse appliedCandidateToAppliedCandidateResponse(AppliedCandidate candidate) {
	
		return this.modelMapper.map(candidate, AppliedCandidateResponse.class);
	}

	public AppliedCandidate appliedCandidateRequestToAppliedCandidate(AppliedCandidateRequest candidateRequest) {
		return this.modelMapper.map(candidateRequest, AppliedCandidate.class);
	}

	public ProjectForAllResponse projectToProjectForAllResponse(Projects project) {
		return this.modelMapper.map(project, ProjectForAllResponse.class);
	}

	// add candidate
	@Override
	public AppliedCandidateResponse addAppliedCandidate(AppliedCandidateRequest appliedCandidateRequest,
			MultipartFile files) {
		
		ManageJobs manageJobs  = this.manageJobsRepository.findById(appliedCandidateRequest.getManageJobs().getId())
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.MANAGE_JOBS_LIST_NOT_FOUND + appliedCandidateRequest.getManageJobs().getId()));
		if(manageJobs!=null) {
			manageJobs.setTotalAppliedCandidates(manageJobs.getTotalAppliedCandidates()+1);
			this.manageJobsRepository.save(manageJobs);
		AppliedCandidate candidate = this.appliedCandidateRequestToAppliedCandidate(appliedCandidateRequest);      
		candidate.setStatus("new");
		if (files != null)
				candidate.setApplyDate(new Date(System.currentTimeMillis()));
				candidate.setOriginalName(files.getOriginalFilename());

				candidate.setFileName(UUID.randomUUID().toString() + files.getOriginalFilename());

				// system file upload
				String fileName = StringUtils.cleanPath(candidate.getFileName());

				Path path = Paths.get(System.getProperty("user.dir") + DIRECTORY, fileName);

				try {
					Files.copy(files.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		  AppliedCandidate save = this.candidateRepository.save(candidate);
      
		return this.appliedCandidateToAppliedCandidateResponse(save);
		}
		return null;
		}

	// get candidate by id
	@Override
	public AppliedCandidateResponse getAppliedCandidateById(Long id) {
		 AppliedCandidate appliedCandidate = this.candidateRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.CANDIDATE_NOT_FOUND + id));

		return this.appliedCandidateToAppliedCandidateResponse(appliedCandidate);
	}

	// get all candidate
	@Override
	public Page<AppliedCandidateResponse> getAllAppliedCandidates(Integer pageNo, Integer pageSize,Integer mId) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Page<AppliedCandidate> CandidateList;
		if (mId>0) {
			ManageJobs manageJobs  = this.manageJobsRepository.findById(mId)
					.orElseThrow(() -> new ResourceNotFoundException(AppConstants.MANAGE_JOBS_LIST_NOT_FOUND +mId));
		
			CandidateList = this.candidateRepository.findByManageJobs(pageRequest,manageJobs);
		}
		else {
			
			CandidateList = this.candidateRepository.findAll(pageRequest);
		}
		

		return CandidateList.map(c -> this.appliedCandidateToAppliedCandidateResponse(c));
	}

	// update candidate status by id
	@Override
	public AppliedCandidateResponse updateAppliedCandidateStatus(String status, Long id) {
		 AppliedCandidate candidate = this.candidateRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.CANDIDATE_NOT_FOUND + id));
		 candidate.setStatus(status);
		 candidate = this.candidateRepository.save(candidate);
		return this.appliedCandidateToAppliedCandidateResponse(candidate);
	}

	// for system upload
	public ProjectResponse systemUpload(AppliedCandidateRequest appliedCandidateRequest, List<MultipartFile> files) {
		// save only path of file and save the file in local folder

		for (MultipartFile file : files) {
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			Path path = Paths.get(DIRECTORY, fileName);
			try {
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public ResponseEntity<Resource> downloadFile(Long id){
		AppliedCandidate file = this.candidateRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(AppConstants.CANDIDATE_NOT_FOUND +id));
		try {
			Path path = Paths.get(System.getProperty("user.dir") + DIRECTORY).toAbsolutePath().normalize().resolve(file.getFileName());
			if(!Files.exists(path))
			throw new ResourceNotFoundException("FIle not Found "+path);
			Resource resource = new UrlResource(path.toUri());
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("File-Name",file.getFileName());
    httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION,"attachment;File-Name="+file.getFileName());
    return ResponseEntity.ok()
    		.contentType(MediaType.parseMediaType(Files.probeContentType(path)))
    		.headers(httpHeaders)
    		.body(resource);
    		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


}
