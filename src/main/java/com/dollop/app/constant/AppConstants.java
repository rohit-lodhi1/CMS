package com.dollop.app.constant;

import java.time.DayOfWeek;

public class AppConstants {
	public static final String PAGE_NUMBER = "0";
	public static final String PAGE_SIZE_STRING = "10";

	public static final Integer ADMIN_ROLE_ID = 1;
	public static final Integer EMPLOYEE_ROLE_ID = 2;
	public static final Integer USER_ROLE_ID = 3;
	public static final Integer CLIENT_ROLE_ID = 4;
	public static final Integer WORKING_HOURS_PER_DAY = 8;
	
	public static final Integer MONTH_STARTING_DATE = 1;
	public static final Integer ANNUAL_EMPLOYEE_LEAVES = 12;
	
	public static final String  MESSAGE ="message";
	
	//...........................ADMIN...................
	public static final String CLIENTS_NOT_FOUND ="clients Not Found with Id : ";
	public static final String DEPARTMENT_NOT_FOUND ="Department Not Found Id: ";
	public static final String CONTACT_NOT_FOUND ="Contact  Not Found with user Id: ";
	public static final String DEPARTMENT_ALREADY_EXIST ="Department ALREADY EXIST BY TITLE : ";
	public static final String DESIGNATION_NOT_FOUND ="Designation not Found id : ";
	public static final String DESIGNATION_AlREADY_FOUND ="Designation ALREADY Found With Title : ";
	public static final String ESTIMATES_NOT_FOUND ="Estimates Not Found with Id : ";
	public static final String INVOCICES_NOT_FOUND ="Invoices Not Found with Id : ";
	public static final String LEAVE_NOT_FOUND ="Leave Type Not Found with id : ";
	public static final String LEAVE_APPLICATION_NOT_FOUND ="Leave Application Not Found Id: ";
	public static final String PROJECT_FILE_NOT_FOUND ="Project File Not Found with id : ";
	public static final String PROJECT_MEMBER_NOT_FOUND ="Project Member not found with id : ";
	public static final String TICKET_MEMBER_NOT_FOUND ="Ticket Member not found with id : ";
	public static final String POLICY_NOT_FOUND ="Policy not found with id : ";
	public static final String PERFORMANCE_INDICATOR_NOT_FOUND ="performance Indicator not Found with id : ";
	public static final String TASK_NOT_FOUND ="Task  Not Found with id : ";
	public static final String TICKETS_NOT_FOUND ="Tickets Not Found with Id : ";
	public static final String TICKET_TYPE_NOT_FOUND ="Ticket Type not Found with id : ";
	public static final String TRAINERS_NOT_FOUND ="Trainers Not Found Id:  ";
	public static final String TRAINING_LIST_NOT_FOUND ="Training List Not Found with Id : ";
	public static final String  TRAINING_TYPE_NOT_FOUND_WITH_ID ="Training type  not found with id :";
	public static final String  INOVICE_PAYMENTS_NOT_FOUND ="Inovice payments  not found with id :";
	public static final String  STAFFSALARY_NOT_FOUND ="StaffSalary not found with id :";
	public static final String  USER_ROLES_NOT_FOUND ="User Role not found with id :";
	public static final String  COMPANY_SETTINGS_NOT_FOUND ="Company Settings not found with id :";
	public static final String  EMERGENCY_CONTACT_NOT_FOUND ="Emergency Contact not found:";
	public static final String  EDUCATION_INFORMATIONS="Education In formationsnot found:";
	public static final String  EXPERIENCE_IN_FORMMATIONS_NOT_FOUND="Experience In Formmations Not found With Id:";
	public static final String  FAMILY_INFORMATIONS_NOT_FOUND = "Family In formations Not found With Id:";
	
	
	
	//...........................NOMARL.....................
	
	public static final String GOALTYPE_NOT_FOUND ="GoalType Not Found with Id : ";
	public static final String GOAL_LIST_NOT_FOUND="Goal List Not Found with Id : ";
	public static final String  EXPENSES_NOT_FOUNND = "Expenses not Found with id :" ;
	
	//........................ JWT TOKEN EXPIRATION....................
	
	public static final String  TOKEN_EXPIRED = "JWT Token Expired." ;
	
	
	
	
	public static final String PAYROLLITEMS_ADDITIONS_NOT_FOUND = "PayrollItems Additions  Not Found Id: ";
	
	public static final String PAYROLLITEMS_DEDUCTIONS_NOT_FOUND = "PayrollItems Deductions Not Found Id:  ";
	public static final String PAYROLLITEMSOVERTIME_NOT_FOUND = "PayrollItemsOvertime Not Found Id:  ";
	public static final String PERFORMANCE_APPRAISAL_NOT_FOUND =	"performance Appraisal not Found with id : ";
	public static final String HOLIDAYS_NOT_FOUND ="Holidays Not Found Id:  ";
	public static final String FILE_NOT_FOUND ="File not Found id :";
	public static final String TAXES_NOT_FOUND ="Taxes Not Found Id: ";
	public static final String ASSEST_LIST_NOT_FOUND ="Assets List Not Found with Id : ";
	///.........................EMPLOYEE.......................
	public static final String ROLE_NOT_FOUND =" Role Not Found with id : ";
	public static final String ATTENDENCE_NOT_FOUND ="Attendence Not Found With id : " ;
	
	
	
	public static final String PROJECT_NOT_FOUND ="Project not Found with id : ";
	public static final String USER_NOT_FOUND ="User not found with email ";
	public static final String NO_PROJECTS_ASSIGNED ="No Projects Assigned To  You";
	public static final String USER_NOT_FOUND_ ="User Not Found with Id : ";
	
	public static final String EMAIL_VERIFICATION ="Email Verification Link Expired ";

	
	public static final String OTP_VERIFICATION_TIMEOUT ="Otp Verification Time Expired ";
	public static final String RESOURCE_NOT_FOUND="Resource Not Found ";
	public static final String OTP_VERIFICATION_INVALID ="Otp Is Invalid ";
	public static final String PASSWORD_NOT_MATCH ="OLDPASSWORD AND NEW PASSWORD DOESNOT MATCH ";
	public static final String USER_ALREADY_PRESENT ="User Already Present with email ";
	public static final String MANAGE_JOBS_LIST_NOT_FOUND ="manage Jobs List Not Found with Id : ";
	public static final String RESIGNATIONS_NOT_FOUND="resignations Not Found with Id : ";
	public static final String PROMOTION_NOT_FOUND="Promotion Not Found with Id : ";
	public static final String TERMINATION_LIST_NOT_FOUND ="Termination List Not Found with Id : ";
	public static final String TIMESHEETS_NOT_FOUND ="timesheets Not Found with this Id: ";
	public static final String TERMINATIONTYPE_NOT_FOUND ="TerminationType Not Found with Id : ";
	public static final String   CANDIDATE_NOT_FOUND=" Candidate not found with id : ";

	public static final String   SOMETHING_WENT_WRONG="Something went wrong!!! ";

	public static final String OVER_LIST_NOT_FOUND = "Over Time Not Found:";
	
	
	

//....................................Status Code ................................................

	public static final Integer OK = 200;
	public static final Integer CREATED = 201;
	public static final Integer ACCEPTED = 202;
	public static final Integer BAD_REQUEST = 400;

	public static final Integer UNAUTHORIZED = 401;
	public static final Integer PAYMENT_REQUIRED = 402;
	public static final Integer FORBIDDEN = 403;
	public static final Integer NOT_FOUND_STATUS_CODE = 404;
	public static final Integer METHOD_NOT_ALLOWED = 405;
	
	
// ---------------------- Days of week ---------------	
	
	public static final String SUNDAY = "SUNDAY";
	public static final String MONDAY = "MONDAY";
	public static final String TUESDAY = "TUESDAY";
	public static final String WEDNESDAY = "WEDNESDAY";
	public static final String THURSDAY = "THURSDAY";
	public static final String FRIDAY = "FRIDAY";
	public static final String SATURDAY = "SATURDAY";

	
// ------------------- Roles --------------------
	public static final String ADMIN_ROLE = "ADMIN";
	public static final String EMPLOYEE_ROLE = "EMPLOYEE";
	public static final String USER_ROLE = "USER";
	public static final String CLIENT_ROLE = "CLIENT";

	
 // -------- web config
	
	public static final String MESSAGE_TOPIC ="/user/message/";
	public static final String MESSAGE_PUBLIC ="/user/public/";
	public static final String STATUS_TOPIC ="/user/status";
	public static final String MARKS_AS_SEEN_TOPIC ="/user/markAsSeen/";
	public static final String MESSAGE_FILE_TOPIC ="/user/message/file";
	
	
	
//   --------------- chat --------------
	public static final String CONVERSATION_SUCCESS ="Conversation created successfully";
	public static final String CONVERSATION_FAILED ="Conversation creation failed";
	public static final String CONVERSATION_EXISTS = "Conversation already exists";
	public static final String CONVERSATION_NOT_FOUND = "Conversation not found";
	public static final String CONVERSATION_RETRIEVED = "Conversation retrieved successfully";
	
	public static final String EMPTY_REQUEST_BODY = "Request is empty";
	
	public static final String MESSAGE_SAVED_SUCCESS = "Message saved successfully";
	public static final String MESSAGE_RETRIEVED_SUCCESS = "Message retrieved successfully";
    public static final String MESSAGES_MARK_AS_SEEN  ="Messages marked as seen";
    public static final String MESSAGE_NOT_FOUND = "Message not found ";
    public static final String MESSAGE_DELETED = "Message deleted successfully"; 
    
    public static final String USER_RETRIEVED_SUCCESS  ="User retrieved successfully";
    
	public static final String FILES_RETRIEVED_SUCCESS = "Files Retreived successfully .";
	
	
	
	
	
	public static final Integer MAX_EMPLOYEE = 1000;
	public static final String PERSONAL_INFORMATIONS_LIST_NOT_FOUND ="Persanal Informations Not found";
	public static final String BANK_INFORMATIONS_NOT_FOUND = "Bank Informations not found";
	
	
}
