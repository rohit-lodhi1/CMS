package com.dollop.app.entity.chat;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.dollop.app.constant.UserChatStatus;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.status.UsersStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class UserActiveStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private Users user;
	
	@UpdateTimestamp
	private LocalDateTime lastActive;
	
	@Enumerated(EnumType.STRING)
	private UserChatStatus status=UserChatStatus.Offline;
	
	private Boolean isShowable =true;
}
