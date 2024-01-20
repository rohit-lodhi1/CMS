//package com.dollop.app.entity;
//
//import java.util.Date;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToOne;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//public class Notifications {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Integer  id;
//	
//	@ManyToOne
//	private Users userId;
//	// colum text
//	private String description ;
//	
//	private Date createdAt;
//	
//	private String notifyTo;
//	
//	private String   readBy;
//	
//	private String event;
//	@ManyToOne
//	private Projects projectId;
//	@ManyToOne
//	private Tasks taskId;
//	
//	@OneToOne
//	private  Comments projectCommentId;
//	
//    @ManyToOne
//	private Tickets ticketId;
//
//	@OneToOne
//	private TicketComments ticketCommentId;
//
//	@ManyToOne
//	private ProjectFiles projectFileId;
//
//	@OneToOne
//	private LeaveApplications leaveId;
//
//	@OneToOne
//	private Posts postId;
//
//	@OneToOne
//	private Users toUserId;
//
//	@OneToOne
//	private ActivityLogs activityLogId;
//
//	@ManyToOne
//	private Clients clientId;
//
//	@OneToOne
//	private InvoicePayments invoicePaymentId;
//
//	@ManyToOne
//	private Invoices invoiceId;
//
//	@ManyToOne
//	private Estimates estimateId;
//
//	@ManyToOne
//	private EstimateRequests estimateRequestId;
//
//
//	private Integer actualMessageId;
//
//	private Integer parentMessageId;
//
//	private Boolean deleted;
//
//}
//
