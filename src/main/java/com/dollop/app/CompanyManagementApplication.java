
package com.dollop.app;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

import com.dollop.app.DomeRunClass;
import com.dollop.app.entity.ModulePermissions;
import com.dollop.app.entity.Permissions;
import com.dollop.app.entity.Roles;
import com.dollop.app.entity.payload.admin.AdminRoleRequest;
import com.dollop.app.repository.ModulePermissionsRepository;
import com.dollop.app.repository.RolesRepository;
import com.dollop.app.service.admin.IAdminRoleService;

@SpringBootApplication
@EnableWebSocket
@EnableScheduling
public class CompanyManagementApplication implements CommandLineRunner {

	@Autowired
	private RolesRepository roleRepository;
	
	@Autowired
	private IAdminRoleService roleService;

	@Autowired
	private ModulePermissionsRepository modulePermissionsRepository;
	
	@Autowired
	private DomeRunClass domeRunClass;

	public static void main(String[] args) {
		SpringApplication.run(CompanyManagementApplication.class, args);
		createUploadFolder();
		
// sdfasd
	}

	public static void createUploadFolder() {
		String folder[] = { "ProjectFiles", "PolicyFiles", "TaskFiles", "Expenses", "AppliedCandidate","TicketsFiles","UserProfile","Chats" };

		File file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\static\\uploads");
		if (!file.exists())
			file.mkdir();
		for (int i = 0; i <= 6; i++) {
			file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\static\\uploads\\" + folder[i]);
			if (!file.exists())
				file.mkdir();
		}
	}

	// @Override
	public void run(String... args) throws Exception {
//   this.registration();
		this.domeRunClass.registration();
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
		profiles.setName("Profile");
		
		

		ModulePermissions authentications = new ModulePermissions();
		authentications.setId(23);
		authentications.setName("authentication");
		
		

		ModulePermissions subscriptions = new ModulePermissions();
		subscriptions.setId(24);
		subscriptions.setName("subscription");
		
		
		List<ModulePermissions> modules = List.of(employees,clients,projects,leads,tickets,profiles,accounts,payrolls
				,policies,reports,performances,goals,trainings,promotions,resignations,terminations,assets,jobs,knowledge,activities,users,settings,profiles,authentications,subscriptions);
		  //this.modulePermissionsRepository.saveAll(modules);

 if(this.modulePermissionsRepository.findById(1).isEmpty())
		  this.modulePermissionsRepository.saveAll(modules);

		  
		  Roles admin = new Roles();
		 admin.setId(1);
		 admin.setTitle("ADMIN");
		  Roles emp = new Roles();
		  emp.setId(2);
		  emp.setTitle("EMPLOYEE");
		List<Permissions> lists = new ArrayList<>();
		String employee[] = {"Employee/AllEmployee","Employee/Holidays","Employee/Leaves_Admin","Employee/Leaves_Employee","Employee/leave_settings","Employee/Attendance_Admin","Employee/Attendance_Employee","Employee/Departments","Employee/Designations","Employee/Timesheet","Employee/Overtime"};
		
		String client[] = {"Clients"};
		String project[] = {"Projects/Projects","Projects/Tasks","Projects/TaskBoard"	};
		
		String lead[] = {"Leads"};
		
		String ticket[]  = {"Tickets/Tickets","Tickets/Ticket_Types"};
		
		String profile[] = {"Employee/Profile","Client/Profile","Admin/Profile"};
				
		String account[] = {"Accounts/Estimates","Accounts/Invoices","Accounts/Payments","Accounts/Expenses","Accounts/Provident_Fund","Accounts/Taxes"};
		
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
		String job[] = {"Jobs/Manage_Jobs","Jobs/Applied_Candidates"};
		String knowledgebase[] = {"Knowledge_base"};
		String activity[] = {"Activites"};
		String user [] = {"Users"};
		String setting[] = {"Settings/Company_Settings","Settings/localization","Settings/theme_settings","Settings/Roles_Permissions","Settings/Email_Settings","Settings/Invoice_Settings","Settings/Salary_Settings","Settings/Notifications","Settings/Change_Password","Settings/Leave_Type"};
		
		
		
	//	String profile[]= {"Profile/EmployeeProfile","Profile/ClientProfile"};
		String authentication[] = {"Authentication/Login","Authentication/Registration","Authentication/ForgetPassword","Authentication/OTP","Authentication/LockScreen"};
		
		String subscription[] = {"Subscriptions/Subscriptions_Admin","Subscriptions/Subscriptions_Company","Subscriptions/Subscribed_Companies"};
		
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

//  this.roleRepository.save(roles);
	
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
		
		admin.setPermissions(lists);
		emp.setPermissions(lists);
		AdminRoleRequest role = new AdminRoleRequest();
		role.setTitle("ADMIN");
	
		AdminRoleRequest role1 = new AdminRoleRequest();
		role1.setTitle("EMPLOYEE");
		
		AdminRoleRequest userRole = new AdminRoleRequest();
		userRole.setTitle("USER");
	
		AdminRoleRequest clientRole = new AdminRoleRequest();
		clientRole.setTitle("CLIENT");

	//this.roleService.addRole(role);
		//this.roleService.addRole(role1);

	if(!this.roleRepository.existsByTitle("ADMIN")) {	
		this.roleService.addRole(role);
		this.roleService.addRole(role1);
		this.roleService.addRole(userRole);
		this.roleService.addRole(clientRole);
		
	}

	//	this.roleService.addRole(role);
	//	this.roleService.addRole(role1);

		
//		this.roleRepository.save(admin);
//		this.roleRepository.save(emp);
		
	
	
			}
	
}
