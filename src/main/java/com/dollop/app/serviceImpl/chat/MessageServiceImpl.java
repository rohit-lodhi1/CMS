package com.dollop.app.serviceImpl.chat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.chat.ChatFiles;
import com.dollop.app.entity.chat.Conversation;
import com.dollop.app.entity.chat.Message;
import com.dollop.app.entity.payload.chat.ConversationMessageHistoryResponse;
import com.dollop.app.entity.payload.chat.ConversationRequest;
import com.dollop.app.entity.payload.chat.MarkAsSeen;
import com.dollop.app.entity.payload.chat.MarkAsSeenResponse;
import com.dollop.app.entity.payload.chat.MessageDeleteRequest;
import com.dollop.app.entity.payload.chat.MessageRequest;
import com.dollop.app.entity.payload.chat.MessageResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.exception.UserNotFoundException;
import com.dollop.app.repository.ConversationRepository;
import com.dollop.app.repository.MessageRepository;
import com.dollop.app.repository.UsersRepository;
import com.dollop.app.service.chat.IConversationService;
import com.dollop.app.service.chat.IMessageService;

import jakarta.mail.Multipart;

@Service
public class MessageServiceImpl implements IMessageService {

	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private ConversationRepository conversationRepository;

	@Autowired
	private IConversationService conversationService;

	@Autowired
	private UsersRepository userRepository;

	@Autowired
	private ModelMapper mapper;

	@Value("${chat.files}")
	private String DIRECTORY;

	@Override
	public ConversationMessageHistoryResponse saveMessage(MessageRequest request) {

		Message message = new Message();
		message.setSender(this.userRepository.findById(request.getSender())
				.orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND)));
		message.setRecipient(this.userRepository.findById(request.getRecipient())
				.orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND)));
		message.setSent(LocalDateTime.now());
		message.setMessage(request.getMessage().trim());

//		Conversation conversation = this.conversationRepository.findByConversationId(request.getConversationId())
//				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.USER_NOT_FOUND));

		message.setConversationId(request.getConversationId());

		// saving files
		
		this.messageRepository.save(message);
		ConversationMessageHistoryResponse response = new ConversationMessageHistoryResponse();
		response.setSent(message.getSent().toString());
		response.setConversationId(message.getConversationId());
		response.setSender(message.getSender().getId());
		response.setRecipient(message.getRecipient().getId());
		if (Objects.nonNull(message.getRecieved()))
			response.setRecieved(message.getRecieved().toString());
		response.setMessage(message.getMessage());
		response.setId(message.getId());
		if (Objects.nonNull(message.getIsSeen()))
			response.setIsSeen(message.getIsSeen().toString());
		return response;

	}

	public List<ChatFiles> uploadChatFiles(List<MultipartFile> chatFiles, Message message) {
		
		List<ChatFiles> files = new ArrayList<>();

		chatFiles.forEach(f -> {
			ChatFiles chatFile = new ChatFiles();
			chatFile.setFileName(f.getOriginalFilename());
			chatFile.setMessage(message);
			chatFile.setServerFileName(UUID.randomUUID().toString() + f.getOriginalFilename());
            chatFile.setFileSize(String.valueOf(f.getSize()));
			String fileName = StringUtils.cleanPath(chatFile.getServerFileName());

			Path path = Paths.get(System.getProperty("user.dir") + DIRECTORY, fileName);

			try {
				Files.copy(f.getInputStream(), path);
			} catch (IOException e) {
			
				e.printStackTrace();
			}
			files.add(chatFile);

		});
		return files;
	}

	@Override
	public ResponseEntity<?> getMessageByConversationById(String id) {
	  	Map<String, Object> response = new HashMap<>();

		List<Message> messages = this.messageRepository.findByConversationIdOrderBySent(id);
		// DateTimeFormatter formatter =DateTimeFormatter.ofPattern("yyyy-MMM-dd");

		List<ConversationMessageHistoryResponse> res = messages.stream().map(m -> this.messageToMessageResponse((m)))
				.collect(Collectors.toList());
		res.stream().forEach( m ->{
			ListIterator<ChatFiles> iterator = m.getChatFiles().listIterator();
			 List<ChatFiles> images  = new ArrayList<>();
			while(iterator.hasNext()) {
				ChatFiles f=  iterator.next();
				if(f.getFileName().endsWith(".jpg") || f.getFileName().endsWith(".png") ||f.getFileName().endsWith(".jpeg") ) {
					images.add(f);
					iterator.remove();
				}
			}
//			  List<ChatFiles> images = m.getChatFiles().stream().filter(f ->{
//				  if(f.getFileName().endsWith(".jpg") || f.getFileName().endsWith(".png") || f.getFileName().endsWith(".jpeg")) {
//					  m.getChatFiles().remove(f);
//					  return true;
//				  }
//				  return false;
//			  }).collect(Collectors.toList());
			  m.setImages(images);
		});	
		Map<LocalDate, List<ConversationMessageHistoryResponse>> list = res.stream()
				.collect(Collectors.groupingBy(m -> LocalDateTime.parse(m.getSent()).toLocalDate()));
		response.put(AppConstants.MESSAGE, AppConstants.MESSAGE_RETRIEVED_SUCCESS);
		response.put("data", list);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	public ConversationMessageHistoryResponse messageToMessageResponse(Message message) {
		ConversationMessageHistoryResponse response = new ConversationMessageHistoryResponse();
		if (Objects.nonNull(message.getIsSeen()))
			response.setIsSeen(message.getIsSeen().toString());
		response.setChatFiles(message.getChatFiles());
		response.setConversationId(message.getConversationId());
		response.setMessage(message.getMessage());
		response.setId(message.getId());
		if (Objects.nonNull(message.getRecieved()))
			response.setRecieved(message.getRecieved().toString());
		response.setSent(message.getSent().toString());
		response.setSender(message.getSender().getId());
		response.setRecipient(message.getRecipient().getId());

		return response;

	}

	@Override
	public ResponseEntity<?> updateMessage(MessageRequest request) {

		return null;
	}

	@Override
	public List<MarkAsSeenResponse> markAsSeen(MarkAsSeen markAsSeen) {
	   
		List<Message> messages = this.messageRepository.getUnseenMessageBySendAndRecipient(markAsSeen.getSenderId(), markAsSeen.getRecipientId());
		List<MarkAsSeenResponse> response = new ArrayList<>();
		messages.stream().forEach(m ->{
			m.setIsSeen(LocalDateTime.now());
			MarkAsSeenResponse mr = new MarkAsSeenResponse();
			mr.setMessageId(m.getId());
			mr.setIsSeen(m.getIsSeen().toString());
			 response.add(mr);
			});
		
		   this.messageRepository.saveAll(messages);
		
		return response;
	}

	
	
	public ResponseEntity<?> deleteMessage(MessageDeleteRequest request){
		List<Message> messages = this.messageRepository.findAllById(request.getMessageId());
		Map<String, Object> response = new HashMap<>();
		
		messages.stream().forEach(m ->{
			 if(m.getSender().getId().intValue()==request.getDeletedById())
				 m.setIsSenderDeleted(true);
			 else if(m.getRecipient().getId().intValue()==request.getDeletedById())
				 m.setIsRecipientDeleted(true);
		});
		this.messageRepository.saveAll(messages);
		response.put(AppConstants.MESSAGE, AppConstants.MESSAGE_DELETED);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
}
