package com.dollop.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dollop.app.entity.chat.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{

	public List<Message> findByConversationIdOrderBySent(String conversationId);
	
	@Query("SELECT m FROM Message m WHERE m.sender.id =:senderId AND m.recipient.id =:recipientId AND m.isSeen IS NULL ORDER BY m.sent DESC")
	public List<Message> getUnseenMessageBySendAndRecipient(Integer senderId,Integer recipientId);

	@Query(nativeQuery = true,value="SELECT CASE WHEN m.sender_id = :id THEN m.recipient_id ELSE m.sender_id END AS chatPartnerId, MAX(m.sent) AS lastMessageTime FROM message m WHERE :id IN (m.sender_id, m.recipient_id) GROUP BY CASE WHEN m.sender_id = :id THEN m.recipient_id ELSE m.sender_id END ORDER BY  lastMessageTime DESC;")
	public List<Object[]> getChatsUsersOfUserById(Integer id);
	
	@Query(nativeQuery = true,value="SELECT count(*) from message where sender_id=:senderId AND recipient_id =:recipientId AND is_seen IS NULL ")
	public Integer getUnreadMessageCount(Integer senderId,Integer recipientId);
}
