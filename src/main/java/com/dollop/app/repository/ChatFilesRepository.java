package com.dollop.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dollop.app.entity.chat.ChatFiles;

public interface ChatFilesRepository extends JpaRepository<ChatFiles, Long>{

	public Boolean existsByServerFileName(String serverFileName);

	@Query( "SELECT f FROM ChatFiles  f INNER JOIN  Message  m ON  f.message.id=m.id AND  m.sender.id=:senderId AND m.recipient.id =:recipientId AND f.isDeleted = false ORDER BY m.sent DESC")
	public List<ChatFiles> getFilesOfSenderBySenderAndRecipient(Integer senderId, Integer recipientId);
	
	@Query("SELECT f FROM ChatFiles  f INNER JOIN Message m ON f.message.id=m.id AND m.conversationId = :conversationId ORDER BY m.sent DESC")
	public List<ChatFiles> getAllFilesOfSenderAndRecipient(String conversationId);
	
}
