package com.dollop.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dollop.app.entity.Users;
import com.dollop.app.entity.chat.Conversation;

public interface ConversationRepository extends JpaRepository<Conversation, Integer>{
   
	
	@Query("SELECT c FROM Conversation c WHERE c.sender.id=:sender AND c.recipient.id=:recipient ")
	public Optional<Conversation> findBySenderAndRecipient(Integer sender,Integer recipient);
	
	public Optional<Conversation> findByConversationId(String conversationId);
}
