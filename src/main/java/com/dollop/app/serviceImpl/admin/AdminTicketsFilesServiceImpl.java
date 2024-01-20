package com.dollop.app.serviceImpl.admin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.ProjectFiles;
import com.dollop.app.entity.Tickets;
import com.dollop.app.entity.TicketsFiles;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.admin.TicketsFilesRequest;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.ProjectFileRepository;
import com.dollop.app.repository.ProjectRepository;
import com.dollop.app.repository.TicketsFileRepository;
import com.dollop.app.repository.TicketsRepository;
import com.dollop.app.repository.UsersRepository;
import com.dollop.app.service.admin.ITicketsFilesService;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             

public class AdminTicketsFilesServiceImpl implements ITicketsFilesService{

	@Value("${tickets.file.path}")
	private String DIRECTORY;

	@Autowired
	private TicketsFileRepository ticketsFileRepository;
	@Autowired
	private TicketsRepository ticketsRepository;
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private TicketsFiles ticketsfilesRequestToTicketsFiles(TicketsFilesRequest ticketsFilesRequest)
	{
		return this.modelMapper.map(ticketsFilesRequest, TicketsFiles.class);
		
	}
	
	@Override
	public List<TicketsFiles> addTicketsFiles(List<MultipartFile> files, Integer TicketsId, Integer uploadedBy) {
		
		Tickets tickets=this.ticketsRepository.findById(TicketsId).orElseThrow(()->new ResourceNotFoundException(AppConstants.TICKETS_NOT_FOUND+ TicketsId));
		Users user=this.usersRepository.findById(TicketsId).orElseThrow(()-> new ResourceNotFoundException(AppConstants.USER_NOT_FOUND+uploadedBy));
		// TODO Auto-generated method stub
		List<TicketsFiles>tFiles=new ArrayList<>();
		if(files!=null)
			for (MultipartFile a : files) {

				TicketsFiles tf=new TicketsFiles();
				tf.setCreatedAt(new Date(System.currentTimeMillis()));
				tf.setOriginalName(a.getOriginalFilename());
				tf.setFileSize((double) a.getSize());
//				tf.setTickets(tickets);
				tf.setFileName(UUID.randomUUID().toString() + a.getOriginalFilename());
				tf.setUploadedBy(user);
				// system file upload
				String fileName = StringUtils.cleanPath(tf.getFileName());

				Path path = Paths.get(System.getProperty("user.dir") + DIRECTORY, fileName);
				try {
					Files.copy(a.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {

					e.printStackTrace();
				}
				tFiles.add(tf);

			}
			
		tFiles= this.ticketsFileRepository.saveAll(tFiles);

		return tFiles;
			
		
}


	
	
	
}
