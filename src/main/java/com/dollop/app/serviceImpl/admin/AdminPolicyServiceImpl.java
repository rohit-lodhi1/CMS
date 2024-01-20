package com.dollop.app.serviceImpl.admin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
import com.dollop.app.entity.Policy;
import com.dollop.app.entity.PolicyFiles;
import com.dollop.app.entity.ProjectFiles;
import com.dollop.app.entity.payload.admin.PolicyRequest;
import com.dollop.app.entity.payload.admin.PolicyResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.PolicyRepository;
import com.dollop.app.service.admin.IPolicyService;

@Service
public class AdminPolicyServiceImpl implements IPolicyService {

	@Autowired
	private ModelMapper modelMapper;

	@Value("${policy.file.path}")
	private String DIRECTORY;

	@Autowired
	private PolicyRepository policyRepository;

	private PolicyResponse policyToPolicyResponse(Policy policy) {
		return this.modelMapper.map(policy, PolicyResponse.class);
	}

	private Policy policyRequestToPolicy(PolicyRequest policRequest) {
		return this.modelMapper.map(policRequest, Policy.class);
	}

	// add policy
	@Override
	public PolicyResponse addPolicy(List<MultipartFile> files, PolicyRequest policyRequest) {
		Policy policy = this.policyRequestToPolicy(policyRequest);
		if (policy.getDepartment().getId() == 0)
			policy.setDepartment(null);
		List<PolicyFiles> pfiles = new ArrayList<>();
		if (files != null) {
			for (MultipartFile file : files) {
				PolicyFiles pf = new PolicyFiles();
				pf.setFileName(UUID.randomUUID().toString() + file.getOriginalFilename());
				pf.setOriginalFileName(file.getOriginalFilename());
				pf.setSize(file.getSize());

				// system file upload
				String fileName = StringUtils.cleanPath(pf.getFileName());

				Path path = Paths.get(System.getProperty("user.dir") + DIRECTORY, fileName);
				try {
					Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pfiles.add(pf);

			}
		}

		policy.setFiles(pfiles);
		return this.policyToPolicyResponse(this.policyRepository.save(policy));
	}

	// update policy
	@Override
	public PolicyResponse updatePolicy(List<MultipartFile> files, PolicyRequest policyRequest) {
		Policy policy = this.policyRepository.findById(policyRequest.getId()).orElseThrow(
				() -> new ResourceNotFoundException(AppConstants.POLICY_NOT_FOUND + policyRequest.getId()));
		policy.setDescription(policyRequest.getDescription());
		policy.setName(policyRequest.getName());
		List<PolicyFiles> pfiles = policyRequest.getFiles();
		if (files != null) {
			for (MultipartFile file : files) {
				PolicyFiles pf = new PolicyFiles();
				pf.setFileName(UUID.randomUUID().toString() + file.getOriginalFilename());
				pf.setOriginalFileName(file.getOriginalFilename());
				pf.setSize(file.getSize());

				// system file upload
				String fileName = StringUtils.cleanPath(pf.getFileName());

				Path path = Paths.get(System.getProperty("user.dir") + DIRECTORY, fileName);
				try {
					Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pfiles.add(pf);

			}
		}

		policy.setFiles(pfiles);

		return this.policyToPolicyResponse(this.policyRepository.save(policy));
	}

	// get policy by id
	@Override
	public PolicyResponse getPolicyById(Integer id) {
		Policy policy = this.policyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.POLICY_NOT_FOUND + id));
		return this.policyToPolicyResponse(policy);
	}

	// get all policies
	@Override
	public Page<PolicyResponse> getAllPolicy(Integer pageNo, Integer pageSize) {
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Page<Policy> policies = this.policyRepository.findAll(pageRequest);
		return policies.map(p -> this.policyToPolicyResponse(p));
	}

	// download the policy
	@Override
	public ResponseEntity<Resource> downloadFile(Integer id) {

		return null;
	}

	// delete policy by id
	@Override
	public Boolean deletePolicyById(Integer id) {
		Policy policy = this.policyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.POLICY_NOT_FOUND + id));
		this.policyRepository.delete(policy);
		return true;
	}

}
