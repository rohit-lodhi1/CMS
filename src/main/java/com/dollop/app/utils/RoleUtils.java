package com.dollop.app.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dollop.app.entity.ModulePermissions;
import com.dollop.app.entity.Permissions;
import com.dollop.app.repository.ModulePermissionsRepository;

@Component
public class RoleUtils {

	public  List<Permissions> getDefaultPermission(){
		
		ModulePermissions employees = new ModulePermissions();
		employees.setId(1);
		employees.setName("Employee");

		ModulePermissions clients = new ModulePermissions();
		clients.setId(2);
		clients.setName("Clients");

		ModulePermissions projects = new ModulePermissions();
		projects.setId(3);
		projects.setName("Projects");

		ModulePermissions leads = new ModulePermissions();
		leads.setId(4);
		leads.setName("Leads");

		ModulePermissions tickets = new ModulePermissions();
		tickets.setId(5);
		tickets.setName("Tickets");

		ModulePermissions accounts = new ModulePermissions();
		accounts.setId(6);
		accounts.setName("Accounts");

		ModulePermissions payrolls = new ModulePermissions();
		payrolls.setId(7);
		payrolls.setName("Payroll");

		ModulePermissions policies = new ModulePermissions();
		policies.setId(8);
		policies.setName("Policies");

		ModulePermissions reports = new ModulePermissions();
		reports.setId(9);
		reports.setName("Reports");

		ModulePermissions performances = new ModulePermissions();
		performances.setId(10);
		performances.setName("Performance");

		ModulePermissions goals = new ModulePermissions();
		goals.setId(11);
		goals.setName("Goals");

		ModulePermissions trainings = new ModulePermissions();
		trainings.setId(12);
		trainings.setName("Training");

		ModulePermissions promotions = new ModulePermissions();
		promotions.setId(13);
		promotions.setName("Promotion");

		ModulePermissions resignations = new ModulePermissions();
		resignations.setId(14);
		resignations.setName("Resignation");

		ModulePermissions terminations = new ModulePermissions();
		terminations.setId(15);
		terminations.setName("Termination");

		ModulePermissions assets = new ModulePermissions();
		assets.setId(16);
		assets.setName("Assets");

		ModulePermissions jobs = new ModulePermissions();
		jobs.setId(17);
		jobs.setName("Jobs");

		ModulePermissions knowledge = new ModulePermissions();
		knowledge.setId(18);
		knowledge.setName("Knowledge");

		ModulePermissions activities = new ModulePermissions();
		activities.setId(19);
		activities.setName("Activities");

		ModulePermissions users = new ModulePermissions();
		users.setId(20);
		users.setName("Users");

		ModulePermissions settings = new ModulePermissions();
		settings.setId(21);
		settings.setName("Settings");
		

		ModulePermissions profiles = new ModulePermissions();
		profiles.setId(22);
		profiles.setName("profile");
		
		

		ModulePermissions authentications = new ModulePermissions();
		authentications.setId(23);
		authentications.setName("authentication");
		
		

		ModulePermissions subscriptions = new ModulePermissions();
		subscriptions.setId(24);
		subscriptions.setName("subscription");
		
		
		ModulePermissions apps = new ModulePermissions();
		apps.setId(25);
		apps.setName("apps");
		
		List<ModulePermissions> list = Arrays.asList(employees,clients,projects,leads,tickets,accounts,payrolls,policies,reports,performances,
				goals,trainings,promotions,resignations,terminations,assets,jobs,knowledge,activities,users,settings,profiles,authentications,subscriptions,apps);
		this.createModelPermission(list);
		List<Permissions> lists = new ArrayList<>();
		String employee[] = {"Employee/AllEmployee","Employee/Holidays","Employee/Leaves_Admin","Employee/Leaves_Employee","Employee/leave_settings","Employee/Attendance_Admin","Employee/Attendance_Employee","Employee/Departments","Employee/Designations","Employee/Timesheet","Employee/Overtime"};
		
		String client[] = {"Clients"};
		String project[] = {"Projects/Projects","Projects/Projects_View","Projects/Tasks","Projects/TaskBoard"	};
		
		String lead[] = {"Leads"};
		
		String ticket[]  = {"Tickets/Tickets","Tickets/Ticket_View","Tickets/Ticket_Types"};
		
		String profile[] = {"Employee_Profile","Client_Profile","Admin_Profile"};
				
		String account[] = {"Accounts/Estimates","Accounts/Estimates_View","Accounts/Estimates_Create","Accounts/Estimates_Edit","Accounts/Invoices","Accounts/Invoices_View","Accounts/Invoices_Create","Accounts/Invoices_Edit","Accounts/Payments","Accounts/Expenses","Accounts/Provident_Fund","Accounts/Taxes"};
		
		String payroll[] = {"Payroll/Employee_Salary","Payroll/Payslip","Payroll/Payroll_Items"};
		
		String policie[] = {"Policies"};
		
		String report[] = {"Reports/Expenses_Report","Reports/Invoice_Report"};
		
		
		String performance[] = {"Performance/Performance_Indicator","Performance/Performance_Review","Performance/Performance_Appraisal"};
		
		String goal[] = {"Goals/Goal_List","Goals/Goal_Type"};
		
		String training[] = {"Training/Training_List","Training/Trainers","Training/Training_Type"};
		
		String promotion [] = {"Promotion"};
		
		String resignation[] = {"Resignation"};
		
		String termination[] = {"Termination"};
		
		String asset[] = {"Assets"};
		String job[] = {"Jobs/Manage_Jobs","Jobs/Applied_Candidates","jobs/job-details"};
		String knowledgebase[] = {"Knowledge_base"};
		String activity[] = {"Activites"};
		String user [] = {"Users"};
		String setting[] = {"Settings/Company_Settings","Settings/localization","Settings/theme_settings","Settings/Roles_Permissions","Settings/Email_Settings","Settings/Invoice_Settings","Settings/Salary_Settings","Settings/Notifications","Settings/Change_Password","Settings/Leave_Type"};
		
		
		
	//	String profile[]= {"Profile/EmployeeProfile","Profile/ClientProfile"};
		String authentication[] = {"Authentication/Login","Authentication/Registration","Authentication/ForgetPassword","Authentication/OTP","Authentication/LockScreen"};
		
		String subscription[] = {"Subscriptions/Subscriptions_Admin","Subscriptions/Subscriptions_Company","Subscriptions/Subscribed_Companies"};
		
		String app[]= {"apps/chats","apps/calender"};
		
		for(String s:employee) {
		Permissions permission = new Permissions();
		permission.setTitle(s);
		permission.setModulePermissions(employees);
		lists.add(permission);
		}
		
		for(String s:client) {
			Permissions permission = new Permissions();
			permission.setTitle(s);
			permission.setModulePermissions(clients);
			lists.add(permission);
			}
		
		for(String s:project) {
			Permissions permission = new Permissions();
			permission.setTitle(s);
			permission.setModulePermissions(projects);
			lists.add(permission);
			}

		for(String s:lead) {
			Permissions permission = new Permissions();
			permission.setTitle(s);
			permission.setModulePermissions(leads);
			lists.add(permission);
			}
		

		for(String s:ticket) {
			Permissions permission = new Permissions();
			permission.setTitle(s);
			permission.setModulePermissions(tickets);
			lists.add(permission);
			}

		for(String s:profile) {
			Permissions permission = new Permissions();
			permission.setTitle(s);
			permission.setModulePermissions(profiles);
			lists.add(permission);
		}


		for(String s:account) {
			Permissions permission = new Permissions();
			permission.setTitle(s);
			permission.setModulePermissions(accounts);
			lists.add(permission);
			}
		for(String s:payroll) {
			Permissions permission = new Permissions();
			permission.setTitle(s);
			permission.setModulePermissions(payrolls);
			lists.add(permission);
			}
		
		for(String s:policie) {
			Permissions permission = new Permissions();
			permission.setTitle(s);
			permission.setModulePermissions(policies);
			lists.add(permission);
			}
		

		for(String s:report) {
			Permissions permission = new Permissions();
			permission.setTitle(s);
			permission.setModulePermissions(reports);
			lists.add(permission);
			}

		for(String s:performance) {
			Permissions permission = new Permissions();
			permission.setTitle(s);
			permission.setModulePermissions(performances);
			lists.add(permission);
			}

		for(String s:goal) {
			Permissions permission = new Permissions();
			permission.setTitle(s);
			permission.setModulePermissions(goals);
			lists.add(permission);
			}

		for(String s:training) {
			Permissions permission = new Permissions();
			permission.setTitle(s);
			permission.setModulePermissions(trainings);
			lists.add(permission);
			}

		for(String s:promotion) {
			Permissions permission = new Permissions();
			permission.setTitle(s);
			permission.setModulePermissions(promotions);
			lists.add(permission);
			}

		for(String s:resignation) {
			Permissions permission = new Permissions();
			permission.setTitle(s);
			permission.setModulePermissions(resignations);
			lists.add(permission);
			}

		for(String s:termination) {
			Permissions permission = new Permissions();
			permission.setTitle(s);
			permission.setModulePermissions(terminations);
			lists.add(permission);
			}
		
		for(String s:asset) {
			Permissions permission = new Permissions();
			permission.setTitle(s);
			permission.setModulePermissions(assets);
			lists.add(permission);
			}
		
		for(String s:job) {
			Permissions permission = new Permissions();
			permission.setTitle(s);
			permission.setModulePermissions(jobs);
			lists.add(permission);
			}
		
		for(String s:knowledgebase) {
			Permissions permission = new Permissions();
			permission.setTitle(s);
			permission.setModulePermissions(knowledge);
			lists.add(permission);
			}
		
		for(String s:activity) {
			Permissions permission = new Permissions();
			permission.setTitle(s);
			permission.setModulePermissions(activities);
			lists.add(permission);
			}
		
		for(String s:user) {
			Permissions permission = new Permissions();
			permission.setTitle(s);
			permission.setModulePermissions(users);
			lists.add(permission);
			}
			
		
		
		for(String s:setting) {
			Permissions permission = new Permissions();
			permission.setTitle(s);
			permission.setModulePermissions(settings);
			lists.add(permission);
			}
		for(String s:authentication) {
			Permissions permission = new Permissions();
			permission.setTitle(s);
			permission.setModulePermissions(authentications);
			lists.add(permission);
			}
		for(String s:subscription) {
			Permissions permission = new Permissions();
			permission.setTitle(s);
			permission.setModulePermissions(subscriptions);
			lists.add(permission);
			}
		for(String s:app) {
			Permissions permission = new Permissions();
			permission.setTitle(s);
			permission.setModulePermissions(apps);
			lists.add(permission);
			}
		
		
	
		return lists; 
	}
	
	@Autowired
	private ModulePermissionsRepository modulePermissionsRepository;
	
	public  void createModelPermission(List<ModulePermissions> modulePermissions) {
		if(!this.modulePermissionsRepository.existsById(1)) 
		modulePermissions.stream().forEach(m->{
			this.modulePermissionsRepository.save(m);
		});
	}
}
