package com.dollop.app;

import java.security.SecureRandom;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dollop.app.constant.AppConstants;
import com.dollop.app.entity.Assets;
import com.dollop.app.entity.Clients;
import com.dollop.app.entity.CompanySettings;
import com.dollop.app.entity.Department;
import com.dollop.app.entity.Designation;
import com.dollop.app.entity.EstimateItems;
import com.dollop.app.entity.Expenses;
import com.dollop.app.entity.GoalList;
import com.dollop.app.entity.GoalType;
import com.dollop.app.entity.Holidays;
import com.dollop.app.entity.InvoicePayments;
import com.dollop.app.entity.InvoicesItems;
import com.dollop.app.entity.LeaveTypes;
import com.dollop.app.entity.OverTime;
import com.dollop.app.entity.PerformanceAppraisal;
import com.dollop.app.entity.PerformanceIndicator;
import com.dollop.app.entity.Policy;
import com.dollop.app.entity.ProjectMembers;
import com.dollop.app.entity.Projects;
import com.dollop.app.entity.Promotion;
import com.dollop.app.entity.Roles;
import com.dollop.app.entity.StaffSalary;
import com.dollop.app.entity.Tasks;
import com.dollop.app.entity.Taxes;
import com.dollop.app.entity.TerminationType;
import com.dollop.app.entity.TicketTypes;
import com.dollop.app.entity.Tickets;
import com.dollop.app.entity.TicketsFiles;
import com.dollop.app.entity.TicketsMembers;
import com.dollop.app.entity.Trainers;
import com.dollop.app.entity.TrainingList;
import com.dollop.app.entity.TrainingType;
import com.dollop.app.entity.UserRegistration;
import com.dollop.app.entity.UserRoles;
import com.dollop.app.entity.Users;
import com.dollop.app.entity.payload.EstimatesRequest;
import com.dollop.app.entity.payload.InvoicesRequest;
import com.dollop.app.entity.payload.ManageJobsRequest;
import com.dollop.app.entity.payload.ResignationRequest;
import com.dollop.app.entity.payload.TerminationRequest;
import com.dollop.app.entity.payload.TerminationTypeRequest;
import com.dollop.app.entity.payload.admin.AdminRoleRequest;
import com.dollop.app.repository.AssetsRepository;
import com.dollop.app.repository.ClientsRepository;
import com.dollop.app.repository.CompanySettingsRepository;
import com.dollop.app.repository.DepartmentRepository;
import com.dollop.app.repository.DesignationRepository;
import com.dollop.app.repository.ExpensesRepository;
import com.dollop.app.repository.GoalListRepository;
import com.dollop.app.repository.GoalTypeRepository;
import com.dollop.app.repository.HolidaysRepository;
import com.dollop.app.repository.InvoicePaymentRepository;
import com.dollop.app.repository.InvoicesRepository;
import com.dollop.app.repository.LeaveTypeRepository;
import com.dollop.app.repository.OverTimeRepository;
import com.dollop.app.repository.PerformanceAppraisalRepository;
import com.dollop.app.repository.PerformanceIndicatorRepository;
import com.dollop.app.repository.PolicyRepository;
import com.dollop.app.repository.ProjectRepository;
import com.dollop.app.repository.PromotionRepository;
import com.dollop.app.repository.RolesRepository;
import com.dollop.app.repository.StaffSalaryRepository;
import com.dollop.app.repository.TasksRepository;
import com.dollop.app.repository.TaxesRepository;
import com.dollop.app.repository.TicketTypeRepository;
import com.dollop.app.repository.TicketsRepository;
import com.dollop.app.repository.TrainersRepository;
import com.dollop.app.repository.TrainingListRepository;
import com.dollop.app.repository.TrainingTypeRepository;
import com.dollop.app.repository.UserRegistrationRepository;
import com.dollop.app.repository.UsersRepository;
import com.dollop.app.service.IManageJobsService;
import com.dollop.app.service.IResignationService;
import com.dollop.app.service.ITerminationService;
import com.dollop.app.service.ITerminationTypeService;
import com.dollop.app.service.admin.IAdminRoleService;
import com.dollop.app.service.admin.IEstimatesService;
import com.dollop.app.service.admin.IInvoicesService;
import com.dollop.app.utils.GoalListSchedular;

@Service
public class DomeRunClass {

	@Autowired
	private UserRegistrationRepository registrationRepository;

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private RolesRepository rolesRepository;

	@Autowired
	private IAdminRoleService adminRoleService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
private static List<Users> allUsers=new ArrayList<>();
	public void registration() {
		// checking email already exists or not
		// otp generating
		Optional<UserRegistration> findByEmail = this.registrationRepository.findByEmail("dollop1@gmail.com");
		if (findByEmail.isEmpty()) {
			this.createRole();
			this.createtaxe();
			createCompany();

			this.createHolidays();
			UserRegistration registration1 = new UserRegistration(0, "dollop1@gmail.com", "Kamal",
					passwordEncoder.encode("dollop1234"), false, null, this.generateOtp());

			UserRegistration registration2 = new UserRegistration(0, "dollop2@gmail.com", "rohan",
					passwordEncoder.encode("dollop1234"), false, null, this.generateOtp());

			UserRegistration registration3 = new UserRegistration(0, "dollop3@gmail.com", "vishal",
					passwordEncoder.encode("dollop1234"), false, null, this.generateOtp());

			UserRegistration registration4 = new UserRegistration(0, "dollop4@gmail.com", "rohit",
					passwordEncoder.encode("dollop1234"), false, null, this.generateOtp());

			UserRegistration registration5 = new UserRegistration(0, "dollo5p@gmail.com", "sumit",
					passwordEncoder.encode("dollop1234"), false, null, this.generateOtp());

			UserRegistration registration6 = new UserRegistration(0, "dollop6@gmail.com", "ravi",
					passwordEncoder.encode("dollop1234"), false, null, this.generateOtp());

			UserRegistration registration7 = new UserRegistration(0, "dollop7@gmail.com", "rahul",
					passwordEncoder.encode("dollop1234"), false, null, this.generateOtp());

			UserRegistration registration8 = new UserRegistration(0, "dollop8@gmail.com", "shivani",
					passwordEncoder.encode("dollop1234"), false, null, this.generateOtp());

			UserRegistration registration9 = new UserRegistration(0, "dollop9@gmail.com", "surbhi",
					passwordEncoder.encode("dollop1234"), false, null, this.generateOtp());

			UserRegistration registration10 = new UserRegistration(0, "dollop10@gmail.com", "aditi",
					passwordEncoder.encode("dollop1234"), false, null, this.generateOtp());

			UserRegistration registration11 = new UserRegistration(0, "dollop11@gmail.com", "abhishek",
					passwordEncoder.encode("dollop1234"), false, null, this.generateOtp());

			UserRegistration registration12 = new UserRegistration(0, "dollop12@gmail.com", "raju",
					passwordEncoder.encode("dollop1234"), false, null, this.generateOtp());

			UserRegistration registration13 = new UserRegistration(0, "dollop13@gmail.com", "rani",
					passwordEncoder.encode("dollop1234"), false, null, this.generateOtp());

			UserRegistration registration14 = new UserRegistration(0, "dollop14@gmail.com", "muskan",
					passwordEncoder.encode("dollop1234"), false, null, this.generateOtp());

			UserRegistration registration15 = new UserRegistration(0, "dollop15@gmail.com", "mayank",
					passwordEncoder.encode("dollop1234"), false, null, this.generateOtp());

			UserRegistration registration16 = new UserRegistration(0, "dollop16@gmail.com", "manu",
					passwordEncoder.encode("dollop1234"), false, null, this.generateOtp());

			UserRegistration registration17 = new UserRegistration(0, "dollop17@gmail.com", "ritik",
					passwordEncoder.encode("dollop1234"), false, null, this.generateOtp());

			UserRegistration registration18 = new UserRegistration(0, "dollop18@gmail.com", "rajesh",
					passwordEncoder.encode("dollop1234"), false, null, this.generateOtp());

			UserRegistration registration19 = new UserRegistration(0, "dollop19@gmail.com", "Braj",
					passwordEncoder.encode("dollop1234"), false, null, this.generateOtp());

			this.registrationRepository.saveAll(Arrays.asList(registration1, registration2, registration3,
					registration4, registration5, registration6, registration7, registration8, registration9,
					registration10, registration11, registration12, registration13, registration14, registration15,
					registration16, registration17, registration18, registration19));
			this.verifyUser();
		}
	}

	@Autowired
	private CompanySettingsRepository companySettingsRepository;

	public void createCompany() {
		CompanySettings companySettings = new CompanySettings(1, "Dollop", "Kamal Gupta", "dollop@gmail.com",
				"Indore Mp", null, "Mp", "Indore", "9098832234", null, "1212122", "4354ffg-eer", "fdfdfdfdsfsdf");
		companySettingsRepository.save(companySettings);
	}

	private void createRole() {
		// TODO Auto-generated method stub
		AdminRoleRequest role = new AdminRoleRequest(1, "ADMIN", false);
		AdminRoleRequest role2 = new AdminRoleRequest(2, "EMPLOYEE", false);
		AdminRoleRequest role3 = new AdminRoleRequest(3, "CLIENT", false);

		if (!this.rolesRepository.existsById(1)) {
			this.adminRoleService.addRole(role);
			this.adminRoleService.addRole(role2);
			this.adminRoleService.addRole(role3);
		}

	}

	private String generateOtp() {
		// Generate a random 4-digit OTP
		SecureRandom secureRandom = new SecureRandom();
		int otp = secureRandom.nextInt(9000) + 1000;

		return String.valueOf(otp);
	}
	
	

	@Autowired
	private DesignationRepository designationRepository;

	public void verifyUser() {

		List<UserRegistration> userRegistrationList = registrationRepository.findAll();
		Integer i = 1, j = 1;
		this.createDepartmentAndDesignation();
		List<Designation> allDesignation = this.designationRepository.findAll();
		List<Users> savedAdmin = new ArrayList<>();

		for (UserRegistration userRegistration : userRegistrationList) {
			Users user = new Users();
			user.setEmail(userRegistration.getEmail());
			user.setFirstName(userRegistration.getUserName());
			user.setLastName("Indian" + i);
			user.setDob(new java.sql.Date(System.currentTimeMillis()));
			user.setAddress("Indore");
			user.setPhone("123456789" + 1);
			user.setAlternativePhone("987654321" + 1);
			user.setAlternativeAddress("   ");
			user.setDeleted(false);
			user.setSsn("ssn");
			user.setGender("Male");

			user.setOriginalName("profileImage");
			user.setProfileName("defaultUserImage.png");
			user.setDesignation(allDesignation.get(i * 2 + 1));
			user.setPassword(userRegistration.getPassword());
			user.setCreatedAt(this.getRandomDateForMonth(2010 + j, j < 10 ? j : (j = 1) ));
			Set<UserRoles> userRoles = new HashSet<>();
			UserRoles userRole = new UserRoles();
			UserRoles userRole2 = new UserRoles();
			Roles roles = new Roles();
			Roles roles2 = new Roles();
			j++;
			if (i < 5) {
				roles.setId(AppConstants.EMPLOYEE_ROLE_ID);
				roles2.setId(AppConstants.ADMIN_ROLE_ID);
				userRole.setRoles(roles2);
				userRole2.setRoles(roles);
				userRoles.add(userRole2);
				userRoles.add(userRole);
				user.setUserRoles(userRoles);
				savedAdmin.add(this.usersRepository.save(user));

			} else {
				roles.setId(AppConstants.EMPLOYEE_ROLE_ID);
				userRole.setRoles(roles);
				userRoles.add(userRole);
				user.setUserRoles(userRoles);
				this.usersRepository.save(user);
			}

			userRegistration.setActive(true);
			this.registrationRepository.save(userRegistration);

			i++;
		}
		for (Users users : savedAdmin) {
			this.createClient(users, i);
		}
		this.getAllUsers();
		this.createOverTime();
		this.createStaffSalary();
		this.createManageJobs();
		this.createExpenses();
	this.createTrainingType();
		this.createTrainer();
		this.createTrainersList();
        this.createPromotion();
        this.createTermination();
        this.createPolicy();
        this.createGoalType();
       this.createGoalList();
       this.createAssets();
       this.createLeaveType();
      this. creatPerformanceAppraisal();
       this.createPerformanceIndicator();
       this.createInvoicepayment();
	}

	private void getAllUsers() {
		
		allUsers=this.usersRepository.findAll();
	}

	@Autowired
	private AssetsRepository assetsRepository;
	public void createAssets() {
		List<Users> findAll = allUsers;
		for(int i=0;i<10;i++) {
			Assets a=new Assets(null,findAll.get(1),"computer"+i,false,"month"+i,2l+i,"Active"+i,
					this.getRandomDateForMonth(2023, 12),this.getRandomDateForMonth(2023, 12),
					"manufacturer"+i,"123cvs"+i,23l+i,"skjkjkj"+i,"vhfm"+i,"hbhjhgkjh"+i);
		this.assetsRepository.save(a);
		}
	}
	
	
	@Autowired
	private LeaveTypeRepository leaveTypeRepository;
	
	public void createLeaveType() {
		for (int i = 0; i < 10; i++) {
			LeaveTypes lt=new LeaveTypes(null,i%2==0?"Active":"InActive","sunday"+i,"Goverment"+i,false);	
		
		this.leaveTypeRepository.save(lt);
		}
				
	}
	
	

	@Autowired
	private PerformanceAppraisalRepository appraisalRepository;
	public void creatPerformanceAppraisal() {
		List<Users> findAll = this.usersRepository.findAll();
		for (int i = 0; i < 10; i++) {
			
		PerformanceAppraisal pa= new PerformanceAppraisal(null,this.getRandomDateForMonth(2023, 12),"month"+i,"Aazone"+i,"sysout"+i,"administration"+i
			,	"presentationSkill"+i,"qualityOfWork"+i,"efficiency"+i,"status"+i,"integrity"+i,"professionalism"+i,"teamWork"+i,"criticalThinking"+i,
			"conflictManagement"+i,"attendance"+i,"abilityToMeetDeadline"+i,findAll.get(i+1),false);
	
		this.appraisalRepository.save(pa);
		}
	}
	
	@Autowired
	private PolicyRepository policyRepository;

	private void createPolicy() {
		List<Department> findAll = this.departmentRepository.findAll();
		for (int i = 0; i < 10; i++) {
			Policy p = new Policy(0, "ploicy" + i, findAll.get(i), "dbfmdsfmdfdmfbdmfbm " + i,
					this.getRandomDateForMonth(2023, 11), false, null);
			this.policyRepository.save(p);
		}
	}

	@Autowired
	private DepartmentRepository departmentRepository;

	public void createDepartmentAndDesignation() {

		Department d1 = new Department(0, "Department1", "this Is depatment1", designationList(1), false);
		Department d2 = new Department(0, "Department2", "this Is depatment2", designationList(2), false);
		Department d3 = new Department(0, "Department3", "this Is depatment3", designationList(3), false);
		Department d4 = new Department(0, "Department4", "this Is depatment4", designationList(4), false);
		Department d5 = new Department(0, "Department5", "this Is depatment5", designationList(5), false);
		Department d6 = new Department(0, "Department6", "this Is depatment6", designationList(6), false);
		Department d7 = new Department(0, "Department7", "this Is depatment7", designationList(7), false);
		Department d8 = new Department(0, "Department8", "this Is depatment8", designationList(8), false);
		Department d9 = new Department(0, "Department9", "this Is depatment9", designationList(9), false);
		Department d10 = new Department(0, "Department10", "this Is depatment10", designationList(10), false);

		this.departmentRepository.saveAll(Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10));

	}

	public List<Designation> designationList(Integer byId) {

		List<Designation> designationList = new ArrayList<>();
		Integer i = byId * byId;
		Designation d1 = new Designation(0, "Designation1" + i++, false);
		Designation d2 = new Designation(0, "Designation2" + i++, false);
		Designation d3 = new Designation(0, "Designation3" + i++, false);
		Designation d4 = new Designation(0, "Designation4" + i++, false);
		Designation d5 = new Designation(0, "Designation5" + i++, false);
		designationList.addAll(Arrays.asList(d1, d2, d3, d4, d5));

		return designationList;
	}

	@Autowired
	private HolidaysRepository holidaysRepository;

	public void createHolidays() {

		Holidays h1 = new Holidays(0, "Diwali", "Monday", false, this.getRandomDateForMonth(2023, 12));
		Holidays h2 = new Holidays(0, "Holi", "Monday", false, this.getRandomDateForMonth(2023, 12));
		Holidays h3 = new Holidays(0, "Sankranti", "Monday", false, this.getRandomDateForMonth(2023, 12));
		Holidays h4 = new Holidays(0, "Sunday", "Monday", false, this.getRandomDateForMonth(2023, 12));
		Holidays h5 = new Holidays(0, "Gandijayanti", "Monday", false, this.getRandomDateForMonth(2023, 12));
		Holidays h6 = new Holidays(0, "Birthday", "Monday", false, this.getRandomDateForMonth(2023, 12));
		Holidays h7 = new Holidays(0, "Free Holiday", "Monday", false, this.getRandomDateForMonth(2023, 12));
		Holidays h8 = new Holidays(0, "dgdgd", "Monday", false, this.getRandomDateForMonth(2023, 12));
		Holidays h9 = new Holidays(0, "fdgfdg", "Monday", false, this.getRandomDateForMonth(2023, 12));
		Holidays h10 = new Holidays(0, "fdfdg", "Monday", false, this.getRandomDateForMonth(2023, 12));
		Holidays h11 = new Holidays(0, "sfsdfdf", "Monday", false, this.getRandomDateForMonth(2023, 12));
		Holidays h12 = new Holidays(0, "sfsdfd", "Monday", false, this.getRandomDateForMonth(2023, 12));
		Holidays h13 = new Holidays(0, "sdfsdfds", "Monday", false, this.getRandomDateForMonth(2023, 12));
		Holidays h14 = new Holidays(0, "sdfsdfsdf", "Monday", false, this.getRandomDateForMonth(2023, 12));
		holidaysRepository.saveAll(Arrays.asList(h1, h2, h3, h4, h5, h6, h7, h8, h9, h10, h11, h12, h13, h14));

	}

	public Date getRandomDateForMonth(int year, int month) {
		LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
		int daysInMonth = firstDayOfMonth.lengthOfMonth();

		int randomDay = ThreadLocalRandom.current().nextInt(1, daysInMonth + 1);

		LocalDate randomDate = LocalDate.of(year, month, randomDay);
		return Date.valueOf(randomDate);
	}

	@Autowired
	private OverTimeRepository overTimeRepository;

	public void createOverTime() {
		List<Users> users = allUsers;
		String array[] = { "Approved", "New", "Rejected", "Pending" };
		for (int i = 0; i < 10; i++) {
			OverTime ot = new OverTime(0, users.get(i), this.getRandomDateForMonth(2023, 12), i + 1d,
					"OverTimeType" + i, users.get(i + 1),
					"Overtime refers to hours worked beyond the regular schedule, often compensated at a higher rate. It addresses additional time spent on employment tasks, commonly to meet workload demands.",
					false, "");
			if (i > 5) {
				ot.setStatus("New");
			} else {
				ot.setStatus("Approved");
			}
			overTimeRepository.save(ot);
		}

	}
	
	@Autowired
	private PerformanceIndicatorRepository indicatorRepository;
	public void createPerformanceIndicator() {
		List<Designation> all = this.designationRepository.findAll();
		String a[] = { "None", "Beginner", "Intermediate", "Advance","Expert" };
	
		for (int i = 0,j=0; i < 10; i++) {
			PerformanceIndicator pi= new PerformanceIndicator(0, a[j], a[j+1], a[j+2], a[j+3],  a[j], a[j+1], a[j+2], a[j+3],  a[j],  a[j+2], a[j+3], a[j], a[j+1], a[j+2], a[j+3], null, false, this.getRandomDateForMonth(2010+i, i+1));
		pi.setDesignation(all.get(i));
		indicatorRepository.save(pi);
		}

	}
	
	@Autowired
	private ExpensesRepository expensesRepository;
	
	public void createExpenses() {
		List<Users> users = allUsers;
			
		for (int i = 0,j=1; i < 19; i++,j++) {
			Expenses ex=new Expenses(
					null, this.getRandomDateForMonth(2010+i, j<12?j:(j=1)),"Expenser n jncj"+i,12d*100+i,null,"computer"+i, users.get(i),
					false,"Active"+i,"cash"+i);		
		
			this.expensesRepository.save(ex);
		}
	} 
	
	
	
	

	@Autowired
	private ClientsRepository clientsRepository;

	public void createClient(Users createdBy, Integer i) {

		Clients c = new Clients(0, "Dollop" + i * 2, "VishunPuri(Indore)" + 10 * i, "Indore" + i + 2, "Madhyay Pradesh",
				"455001", "Bharat", this.getRandomDateForMonth(2023, 12), "xyz" + i + ".com", "GOLD", "9098832234",
				null, null, "vfdfkf" + i, "Invo" + i, "Active", "dollop" + i + "@gmail.com", null, null,
				Arrays.asList("first", "second"), false, createdBy, null);
		Clients savedClient = this.clientsRepository.save(c);
		this.createTicketType();
		this.createTicketsAndTicketsType(savedClient.getId());
		this.createProject(createdBy, savedClient, i);
	}

	@Autowired
	private ProjectRepository projectRepository;
	private static Integer loopvalue = 0;

	public void createProject(Users createdBy, Clients c, Integer loopId) {
		List<Users> users = this.usersRepository.findAll();
		
		Projects p = new Projects(0, "project" + (loopvalue++) + "Client",
				"vjbdmvfbdv djvbdhvbf dhfbvfd jgbdv fdvjdvbnf ", Arrays.asList("sfds", "fdfd"), "Kamal" + loopId,
				this.getRandomDateForMonth(2023, 12), this.getRandomDateForMonth(2023, 1),
				this.getRandomDateForMonth(2022, 12), null, c, createdBy, "Progress", 2200000d, "Client Project",
				"high", null, null, null, false);
		ProjectMembers pm = new ProjectMembers(0l, users.get(13), true, false);
		ProjectMembers pm2 = new ProjectMembers(0l, users.get(16), false, false);
		p.setProjectMembers(Arrays.asList(pm, pm2));
		Projects save2 = projectRepository.save(p);
		this.createInvoice(save2);
		this.createtask(save2, loopId);

		Projects p2 = new Projects(0, "project" + (loopvalue++) + "Client",
				"vjbdmvfbdv djvbdhvbf dhfbvfd jgbdv fdvjdvbnf ", Arrays.asList("sfds", "fdfd"), "Kamal" + loopId,
				this.getRandomDateForMonth(2023, 12), this.getRandomDateForMonth(2023, 1),
				this.getRandomDateForMonth(2022, 12), null, c, createdBy, "Progress", 2200000d, "sjdvbdjvb Project",
				"high", null, null, null, false);
		ProjectMembers pm3 = new ProjectMembers(0l, users.get(9), true, false);
		ProjectMembers pm4 = new ProjectMembers(0l, users.get(5), false, false);
		p2.setProjectMembers(Arrays.asList(pm3, pm4));
		Projects save = projectRepository.save(p2);
		this.createtask(save, loopId);
		this.createInvoice(save);
	}

//	public Trainers(Integer id, String firstName, String lastName, String description, String status, String email,
//			String phone, Designation role, Boolean isDeleted) {
//	
	@Autowired
	private TrainersRepository trainersRepository;

	public void createTrainer() {
		List<Designation> findAll = this.designationRepository.findAll();
		for (int i = 0; i < 10; i++) {
			Trainers t = new Trainers(null, "sumit" + i, "Dhakar" + i, "jnbm jm kknn m m" + i, "Active",
					"Dollop12" + i + "@gmail.com", "123456789" + i, findAll.get(i * 2), false);
			this.trainersRepository.save(t);
		}
	}

	@Autowired
	private TrainingTypeRepository trainingTypeRepository;

	public void createTrainingType() {
		for (int i = 0; i < 10; i++) {
			TrainingType ty = new TrainingType(null, "nm nb mk b " + i, "java" + i, "active" + i, false);
			this.trainingTypeRepository.save(ty);
		}
	}

	@Autowired
	private TrainingListRepository trainingListRepository;

	public void createTrainersList() {
		List<Users> allusers = allUsers;
		List<TrainingType> alltType = this.trainingTypeRepository.findAll();
		List<Trainers> allTrainers = this.trainersRepository.findAll();
		for (int i = 0; i < 10; i++) {
			TrainingList t = new TrainingList(null, alltType.get(i), allTrainers.get(i), allusers.get(i * 2),
					30000l * i, "Active", this.getRandomDateForMonth(2012 + i, 3),
					this.getRandomDateForMonth(2012 + i, 12), false, "this is description for tList   " + i);
			this.trainingListRepository.save(t);
		}
	}
	
	
	
	@Autowired
	private GoalTypeRepository goalTypeRepository;
	public void createGoalType() {
		for (int i = 0; i < 10; i++) {

		GoalType gt =new GoalType(null , "java"+i,"ybn in,embn kj "+i,null,"Active"+i,false);
		
		this.goalTypeRepository.save(gt);
		}
	}
	
	
	@Autowired 
	private GoalListRepository goalListRepository;
	
	@Autowired 
	private GoalListSchedular goalListSchedular;
	
	public void createGoalList () {
		List<GoalType> allgType = this.goalTypeRepository.findAll();
		for (int i=0;i<10;i++) {
		GoalList gl =new GoalList(null,"javaqw"+i,"jknkhh"+i,this.getRandomDateForMonth(i%2==0?2023:2024, i%2==0?1:2),this.getRandomDateForMonth(i%2==0?2023:2024, i%2==0?1:2),null, false,"hv bvj h"+i,"Active",allgType.get(i));
	   gl.setProgress(this.goalListSchedular.calculateProgress(gl.getStartDate(), gl.getEndDate()));;
		this.goalListRepository.save(gl);
		}
		}
	

	@Autowired
	private TasksRepository tasksRepository;

	public void createtask(Projects p, Integer loopId) {

		Tasks t = new Tasks(0l, "djhdh" + loopId, 4,"vfdfdgvfd fdgfdgfd fdgfdgfdgf fgff", Arrays.asList("dfs", "sdfd"),
				false, this.getRandomDateForMonth(2023, 10), this.getRandomDateForMonth(2023, 12), "Completed",
				"3 points", p, null, null, null);
		Tasks t2 = new Tasks(0l, "djhdh" + loopId,7, "vfdfdgvfd fdgfdgfd fdgfdgfdgf fgff", Arrays.asList("dfs", "sdfd"),
				false, this.getRandomDateForMonth(2023, 10), this.getRandomDateForMonth(2023, 12), "Progress",
				"3 points", p, null, null, null);
		Tasks t3 = new Tasks(0l, "djhdh" + loopId,8, "vfdfdgvfd fdgfdgfd fdgfdgfdgf fgff", Arrays.asList("dfs", "sdfd"),
				false, this.getRandomDateForMonth(2023, 10), this.getRandomDateForMonth(2023, 12), "Review", "5 points",
				p, null, null, null);

		this.tasksRepository.saveAll(Arrays.asList(t, t2, t3));
	}

	@Autowired
	private IInvoicesService iInvoicesService;

	@Autowired
	private TaxesRepository taxesService;

	public void createInvoice(Projects p) {
		

		this.createEstimate(p);
		Integer j = 0;
		for (Integer i = 1; i < 11; i++) {
			InvoicesItems it = new InvoicesItems(null, "Invoice Item" + i, "Invoice Item List", i + 1d, 100d,
					i + 1d * 100, i + 1d * 100, false);
			InvoicesItems it2 = new InvoicesItems(null, "Invoice Item" + i, "Invoice Item List", i + 1d, 100d,
					i + 1d * 100, i + 1d * 100, false);
			List<Taxes> taxeList = this.taxesService.findAll();
			InvoicesRequest invoicesRequest = new InvoicesRequest(null, p.getClientId(), p,
					this.getRandomDateForMonth(202 + i, i), null, i + 1, this.getRandomDateForMonth(2018 + i, i + 2),
					"Pay regularly on every end day of the month", null, "status", taxeList.get(j), 100, 1000l, 900l,
					0l, 120l, null, null, null, null, null, null, null, null);
			invoicesRequest.setInvoicesItems(Arrays.asList(it, it2));
			invoicesRequest.setDeleted(false);
			invoicesRequest.setBillDate(this.getRandomDateForMonth(2017 + i, i));
			this.iInvoicesService.addInvoices(invoicesRequest);
			j++;
			if (j > 2) {
				j = 0;
			}
		}
	}

	public void createtaxe() {

		Taxes tr = new Taxes(null, "Gst", 10d, false, "Active");
		Taxes tr2 = new Taxes(null, "VST", 20d, false, "Active");
		Taxes tr3 = new Taxes(null, "VAT", 30d, false, "Active");
		taxesService.saveAll(Arrays.asList(tr, tr2, tr3));
	}

	@Autowired
	private IEstimatesService estimatesService;

	public void createEstimate(Projects p) {

		List<Taxes> taxeList = this.taxesService.findAll();

		Integer j = 0;
		for (Integer i = 1; i < 11; i++) {
			EstimateItems et = new EstimateItems(null, "Invoice Item" + i, "Invoice Item List", i + 1d, 100d,
					i + 1d * 100, i + 1d * 100, false);
			EstimateItems it2 = new EstimateItems(null, "Invoice Item" + i, "Invoice Item List", i + 1d, 100d,
					i + 1d * 100, i + 1d * 100, false);

			EstimatesRequest estimateRequests = new EstimatesRequest(null, p.getClientId(), p,
					this.getRandomDateForMonth(2022, 3), this.getRandomDateForMonth(2023, 4),
					"This is your estimate fr project", null, "sent", taxeList.get(j), 100, i, 10000l, 1000l, 12000l,
					false, null);
			estimateRequests.setEstimateItems(Arrays.asList(et, it2));

			this.estimatesService.addEstimates(estimateRequests);
			j++;
			if (j > 2) {
				j = 0;
			}
		}
	}

	@Autowired
	private TicketsRepository iTicketsService;

	public void createTicketsAndTicketsType(Integer clientId) {
//		List<Users> findAllUsers = allUsers;
		List<TicketTypes> ttype = this.ticketTypeRepository.findAll();

		for (int i = 1, j = 1; i <= 12; i++) {
			Tickets ticket = new Tickets();

			// Assuming you have a Clients class defined
			ticket.setClient(this.clientsRepository.findById(clientId).get());

			// Assuming you have a TicketTypes class defined
			ticket.setTicketTypeId(ttype.get(j));

			ticket.setTitle("Ticket " + i);
			ticket.setStatus(i%2==0?"Open":"Pending");

			// Assuming you have a TicketsFiles class defined
			List<TicketsFiles> ticketsFilesList = new ArrayList<>();
			ticket.setTicketsFiles(ticketsFilesList);


			ticket.setCreatedBy(new Users(1));

			ticket.setLastActivityAt(this.getRandomDateForMonth(2021+j, j<2?11:12));
			ticket.setDescription("Description for Ticket " + i);
			TicketsMembers tm = new TicketsMembers();
			tm.setDeleted(false);
			tm.setIsLeader(true);
//			tm.setFollowers(allUsers.get(i));
			
			TicketsMembers tm2 = new TicketsMembers();
			tm.setDeleted(false);
			tm.setIsLeader(false);
//			tm.setFollowers(allUsers.get(i+3));
//			ticket.setTicketMembers(Arrays.asList(tm,tm2));
			// Assuming you have a Users class defined
//			ticket.setRequestedBy(allUsers.get(j));

			ticket.setLabels("Label1");
			ticket.setDeleted(false);
			j++;
			if (j > 2) {
				j = 1;
			}
			this.iTicketsService.save(ticket);

		}
	}

	@Autowired
	private TicketTypeRepository ticketTypeRepository;

	public void createTicketType() {
		for (int i = 1; i <= 10; i++) {
			TicketTypes ticketType = new TicketTypes();
			ticketType.setId(i);
			ticketType.setTitle("TicketType " + i);
			ticketType.setDescription("Description for TicketType " + i);
			// Assuming you have a Ticket class defined

			ticketType.setIsDeleted(false);
			ticketTypeRepository.save(ticketType);

		}
	}

	@Autowired
	private StaffSalaryRepository iStaffSalaryService;

	public void createStaffSalary() {
		List<Users> userList = usersRepository.findAll();
		for (int id = 1; id < 11; id++) {
			StaffSalary dummyData = new StaffSalary();
			dummyData.setId(id);
			dummyData.setStaff(userList.get(id)); // Assuming you have a method to create dummy users
			dummyData.setPayslip(11000.0 + id);
			dummyData.setBasicStaffSalary(10000L + id);
			dummyData.setDa(1000 + id);
			dummyData.setHra(10000 + id);
			dummyData.setAllowance(10000 + id);
			dummyData.setConveyance(1000 + id);
			dummyData.setMedicalAllowance(1000 + id);
			dummyData.setOthers(1000 + id);
			dummyData.setOthers1(1000 + id);
			dummyData.setNetSalary(34000.0 + id);
			dummyData.setTds(1000 + id);
			dummyData.setEsi(12000 + id);
			dummyData.setPf(1000 + id);
			dummyData.setStaffLeave(5);
			dummyData.setProfTax(10000 + id);
			dummyData.setLabourWelfare(10000 + id);
			dummyData.setIsDeleted(false);
			dummyData.setPaymentDate(this.getRandomDateForMonth(2017 + id, id));
			this.iStaffSalaryService.save(dummyData);

		}
	}

	@Autowired
	private IManageJobsService iManageJobsService;

	public void createManageJobs() {
		int i = 0;
		for (Designation d : this.designationRepository.findAll()) {
			ManageJobsRequest jobsRequest = new ManageJobsRequest(null, d, d.getDepartment(), "Indore" + 1, 6 + i,
					8 + " Years", 34 + i, 24000.0, 32000.0 + i * 2, "Full Time", "new",
					this.getRandomDateForMonth(2023, 12), this.getRandomDateForMonth(2025, 12), false,
					"jsfbjfbdjbfjhbvfjhvbfjhbvjhbjb");
			this.iManageJobsService.addManageJobs(jobsRequest);
			i = i + 5;
		}
	}

	@Autowired
	private InvoicePaymentRepository paymentRepository;
	@Autowired
	private InvoicesRepository invoicesRepository;

	public void createInvoicepayment() {
		List<InvoicePayments> all = paymentRepository.findAll();
		for (int i = 0; i < 20; i++) {
			InvoicePayments p = all.get(i)	;
			p.setPaymentDate(this.getRandomDateForMonth(2023, i%2==0?11:12));
			p.setId(all.get(i).getId());
			p.setAmount(60l*i);
			this.paymentRepository.save(p);		
		}
	}
	
	@Autowired
	private PromotionRepository promotionRepository;

	public void createPromotion() {
		List<Users> allUsers1 = allUsers;
		List<Designation> alldesignations = this.designationRepository.findAll();
		for (int i = 0; i < 10; i++) {
			Promotion p = new Promotion(null, allUsers1.get(i + 1), alldesignations.get(i + 5),
					alldesignations.get(i + 3).getTitle(), this.getRandomDateForMonth(2017+i, i+1), false);
			this.promotionRepository.save(p);

		}
		this.createResignation();
	}

	@Autowired
	private IResignationService resignationService;

	public void createResignation() {
		List<Users> allUsers1 = allUsers;

		ResignationRequest rq = new ResignationRequest(0, allUsers1.get(7), "As I am feeling lonely here in your firm",
				false, this.getRandomDateForMonth(2023, 4), this.getRandomDateForMonth(2022, 4),
				allUsers1.get(7).getDesignation().getTitle());
		ResignationRequest rq2 = new ResignationRequest(0, allUsers1.get(14), "As I am feeling lonely here in your firm",
				false, this.getRandomDateForMonth(2023, 4), this.getRandomDateForMonth(2023, 3),
				allUsers1.get(14).getDesignation().getTitle());
		this.resignationService.addResignation(rq);
		this.resignationService.addResignation(rq2);
	}

	@Autowired
	private ITerminationService iTerminationService;
	@Autowired
	private ITerminationTypeService iTerminationtypeService;

	public void createTermination() {
		Integer id2 = this.iTerminationtypeService.addTerminationType(new TerminationTypeRequest(0, "Bad Behaviour"))
				.getId();
		Integer id = this.iTerminationtypeService.addTerminationType(new TerminationTypeRequest(0, "No Reason"))
				.getId();
		List<Users> allUsers1 = allUsers;

		TerminationRequest rq = new TerminationRequest(null, allUsers.get(17), new TerminationType(id),
				allUsers.get(17).getDesignation().getTitle(), this.getRandomDateForMonth(2022, 5),
				this.getRandomDateForMonth(2023, 1), "no reason required", false);
		TerminationRequest rq2 = new TerminationRequest(null, allUsers.get(11), new TerminationType(id2),
				allUsers.get(11).getDesignation().getTitle(), this.getRandomDateForMonth(2023, 6),
				this.getRandomDateForMonth(2023, 3), "no reason required", false);
		this.iTerminationService.addTermination(rq);
		this.iTerminationService.addTermination(rq2);
	}

}
