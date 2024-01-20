package com.dollop.app.serviceImpl.chat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.chat.Conversation;
import com.dollop.app.entity.chat.Message;
import com.dollop.app.entity.chat.UserActiveStatus;
import com.dollop.app.entity.payload.chat.ConversationRequest;
import com.dollop.app.entity.payload.chat.ConversationResponse;
import com.dollop.app.entity.payload.chat.ConversationUserResponse;
import com.dollop.app.entity.payload.chat.UserStatusResponse;
import com.dollop.app.exception.ResourceNotFoundException;
import com.dollop.app.exception.UserNotFoundException;
import com.dollop.app.repository.ConversationRepository;
import com.dollop.app.repository.MessageRepository;
import com.dollop.app.repository.UserActiveStatusRepository;
import com.dollop.app.repository.UsersRepository;
import com.dollop.app.service.chat.IConversationService;
import com.dollop.app.service.chat.IUserActiveStatusService;

@Service
public class ConversationServiceImpl implements IConversationService {

	@Autowired
	private ConversationRepository conversationRepository;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private UsersRepository userRepository;

	@Autowired
	private UserActiveStatusRepository statusRepository;

	@Autowired
	private IUserActiveStatusService statusService;

	@Autowired
	private MessageRepository messageRepository;

	@Override
	public ResponseEntity<?> createConversation(ConversationRequest request) {

		Map<String, Object> response = new HashMap<>();

		Optional<Conversation> already = this.conversationRepository.findBySenderAndRecipient(request.getSenderId(),
				request.getRecipientId());
		if (already.isPresent()) {
			response.put(AppConstants.MESSAGE, AppConstants.CONVERSATION_EXISTS);
			response.put("data", mapper.map(already.get(), ConversationResponse.class));
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		if (Objects.nonNull(request)) {
			Conversation conversation = new Conversation();
			String random = UUID.randomUUID().toString();

			conversation.setConversationId(random);
			conversation.setCreatedAt(LocalDateTime.now());

			Users recipient = userRepository.findById(request.getRecipientId())
					.orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND));
			Users sender = userRepository.findById(request.getSenderId())
					.orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND));

			Conversation conversation2 = new Conversation();
			conversation2.setConversationId(random);
			conversation2.setCreatedAt(LocalDateTime.now());

			conversation2.setSender(recipient);
			conversation2.setRecipient(sender);

			conversation.setSender(sender);
			conversation.setRecipient(recipient);

			conversation = this.conversationRepository.save(conversation);
			conversation2 = this.conversationRepository.save(conversation2);
			response.put(AppConstants.MESSAGE, AppConstants.CONVERSATION_SUCCESS);

			ConversationUserResponse user = this.getConversationUserResponse(request.getRecipientId());

			if (Objects.isNull(user)) {
				response.put(AppConstants.MESSAGE, AppConstants.USER_NOT_FOUND);
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}
			ConversationResponse converRes = mapper.map(conversation, ConversationResponse.class);
			converRes.setUser(user);

			response.put("data", converRes);
		} else
			response.put(AppConstants.MESSAGE, AppConstants.CONVERSATION_FAILED);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<?> getConversationById(ConversationRequest request) {
		Map<String, Object> response = new HashMap<>();

		Optional<Conversation> conversation = this.conversationRepository
				.findBySenderAndRecipient(request.getSenderId(), request.getRecipientId());
		if (conversation.isEmpty()) {
			response.put(AppConstants.MESSAGE, AppConstants.CONVERSATION_NOT_FOUND);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}

		ConversationResponse converRes = new ConversationResponse();
		converRes.setConversationId(conversation.get().getConversationId());
		ConversationUserResponse user = this.getConversationUserResponse(request.getRecipientId());

		if (Objects.isNull(user)) {
			response.put(AppConstants.MESSAGE, AppConstants.USER_NOT_FOUND);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		converRes.setUser(user);

		response.put(AppConstants.MESSAGE, AppConstants.CONVERSATION_RETRIEVED);
		response.put("data", converRes);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	public ConversationUserResponse getConversationUserResponse(Integer userId) {
		Optional<Users> recipient = this.userRepository.findById(userId);
		if (recipient.isEmpty()) {
			return null;
		}
		ConversationUserResponse user = new ConversationUserResponse();
		user.setFirstName(recipient.get().getFirstName());
		user.setLastName(recipient.get().getLastName());
		user.setProfileName(recipient.get().getProfileName());
		user.setId(recipient.get().getId());

		UserStatusResponse statusResponse = this.statusService.getUserStatusByUserId(userId);
		if (Objects.isNull(statusResponse))
			statusResponse = this.statusService.createUserStatus(userId);
		user.setStatus(statusResponse);
		return user;
	}

	@Override
	public ResponseEntity<?> getConversationUsersByUserId(String email) {
		Map<String, Object> response = new HashMap<>();
		Users user = this.userRepository.findByEmail(email)
				.orElseThrow(() -> new UserNotFoundException(AppConstants.USER_NOT_FOUND));
		List<Object[]> chatUsers = this.messageRepository.getChatsUsersOfUserById(user.getId());
	
		List<ConversationUserResponse> conversationUsers = new ArrayList<>();
		chatUsers.stream().forEach(u -> {
			Optional<Users> temp = this.userRepository.findById((Integer)u[0]);
			System.err.println((Integer)u[0]);
			if(temp.isPresent()) {
				ConversationUserResponse conversationUser = this.userToConversationUserResponse(temp.get());
				Integer count = this.messageRepository.getUnreadMessageCount(temp.get().getId(), user.getId());
				conversationUser.setUnSeenMessageCount(count);
              conversationUsers.add(conversationUser);
			}
			
		});
        response.put(AppConstants.MESSAGE, AppConstants.USER_RETRIEVED_SUCCESS);
        response.put("data", conversationUsers);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

	public ConversationUserResponse userToConversationUserResponse(Users user) {
		ConversationUserResponse response = new ConversationUserResponse();
		response.setFirstName(user.getFirstName());
		response.setLastName(user.getLastName());
		response.setProfileName(user.getProfileName());
//		UserStatusResponse statusResponse = this.statusService.getUserStatusByUserId(user.getId());
//		response.setStatus(statusResponse);
		response.setId(user.getId());
		return response;
	}
}
