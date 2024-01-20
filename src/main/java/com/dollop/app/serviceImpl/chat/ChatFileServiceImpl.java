package com.dollop.app.serviceImpl.chat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.ProjectFiles;
import com.dollop.app.entity.chat.ChatFiles;
import com.dollop.app.entity.chat.Conversation;
import com.dollop.app.entity.chat.Message;
import com.dollop.app.entity.payload.chat.ChatFileRequest;
import com.dollop.app.entity.payload.chat.ChatFileResponse;
import com.dollop.app.entity.payload.chat.ConversationRequest;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.repository.ChatFilesRepository;
import com.dollop.app.repository.ConversationRepository;
import com.dollop.app.repository.MessageRepository;
import com.dollop.app.service.chat.IChatFilesService;

@Service
public class ChatFileServiceImpl implements IChatFilesService{

	@Autowired
	private ChatFilesRepository fileRepository;
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private ConversationRepository conversationRepository;
	

	@Value("${imagepath.file.path}")
	private String globalImagesPath  ;

	@Value("${chat.files}")
	private String DIRECTORY;

	
	@Override
	public ResponseEntity<?> saveChatFile(ChatFileRequest request) {
		if(Objects.isNull(request.getChatFile()))
			return new ResponseEntity<>(AppConstants.FILE_NOT_FOUND,HttpStatus.BAD_REQUEST);
		
		 Message message = this.messageRepository.findById(request.getMessageId()).orElseThrow(() -> new ResourceNotFoundException(AppConstants.MESSAGE_NOT_FOUND));
		
		ChatFiles chatFile = new ChatFiles();
		chatFile.setFileName(request.getChatFile().getOriginalFilename());
		chatFile.setMessage(message);
		chatFile.setServerFileName(UUID.randomUUID().toString() + request.getChatFile().getOriginalFilename());
        chatFile.setFileSize(String.valueOf(request.getChatFile().getSize()));
		
        String fileName = StringUtils.cleanPath(chatFile.getServerFileName());

		Path path = Paths.get(System.getProperty("user.dir") + DIRECTORY, fileName);

		try {
			Files.copy(request.getChatFile().getInputStream(), path);
			
			chatFile = this.fileRepository.save(chatFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ResponseEntity<>(this.chatFileToChatFileResponse(chatFile),HttpStatus.OK);
	}
	
	public ChatFileResponse chatFileToChatFileResponse(ChatFiles file) {
		ChatFileResponse response = new ChatFileResponse();
		response.setFileName(file.getFileName());
		response.setFileSize(file.getFileSize());
		response.setMessageId(file.getMessage().getId());
		response.setSenderId(file.getMessage().getSender().getId());
		response.setRecipientId(file.getMessage().getRecipient().getId());
		response.setServerFileName(file.getServerFileName());
		response.setCreatedAt(file.getMessage().getSent());
		return response;
	}

	@Override
	public ResponseEntity<Resource> downloadFile(String destination, String serverFileName) {
//		Boolean isPresent = this.fileRepository.existsByServerFileName(serverFileName);
//				 if(!isPresent)
//					 throw new ResourceNotFoundException(AppConstants.FILE_NOT_FOUND + serverFileName);

		try {
			Path path = Paths.get(System.getProperty("user.dir") + globalImagesPath+File.separator+destination+File.separator).toAbsolutePath().normalize()
					.resolve(serverFileName); //

			if (!Files.exists(path))
				throw new ResourceNotFoundException("FIle not Found " + path);
			Resource resource = new UrlResource(path.toUri());
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.add("File-Name", "example1.zip");
			httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;File-Name=" + resource.getFilename());
			return ResponseEntity.ok().contentType(MediaType.parseMediaType(Files.probeContentType(path)))
					.headers(httpHeaders).body(resource);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public ResponseEntity<?> getProfileFiles(ConversationRequest request) {
		Map<String, Object> response = new HashMap<>();
	 List<ChatFiles> allFiles = this.fileRepository.getFilesOfSenderBySenderAndRecipient(request.getSenderId(),request.getRecipientId());
	 Optional<Conversation> conversation = this.conversationRepository.findBySenderAndRecipient(request.getSenderId(), request.getRecipientId());
	 if(conversation.isPresent()) {
		 List<ChatFiles> conversationFiles = this.fileRepository.getAllFilesOfSenderAndRecipient(conversation.get().getConversationId());
		 List<ChatFileResponse> conversationFileResponse = conversationFiles.stream().map(f -> this.chatFileToChatFileResponse(f)).collect(Collectors.toList());
		 response.put("allFiles", conversationFileResponse);
	 }
	 List<ChatFileResponse> files = allFiles.stream().map(f -> this.chatFileToChatFileResponse(f)).collect(Collectors.toList());
	  response.put(AppConstants.MESSAGE, AppConstants.FILES_RETRIEVED_SUCCESS);
	  response.put("myFiles", files);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
}
