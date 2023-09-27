package java_core_bai13;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import common.Utilities;

public class EmployeeManagement {
	private List<Employee> employees = new ArrayList<Employee>();
	private static EmployeeManagement _instance;

	public static EmployeeManagement instance() {
		if (_instance == null) {
			_instance = new EmployeeManagement();
		}
		return _instance;
	}

	private EmployeeManagement() {

	}

	public void addEmployee() {
		System.out.println("0. Experience");
		System.out.println("1. Fresher");
		System.out.println("2. Intern");
		System.out.print("Select employee type: ");
		int employeeType = Utilities.instance().getValidatedNumber(0, 2, Integer.class);

		System.out.print("Employee ID: ");
		String id = Utilities.instance().getNewPrimaryKey("Employee ID");

		System.out.print("Full Name: ");
		String fullName = Utilities.instance().getValidatedString("^[a-zA-Z ]+$", "Invalid, re-input full name: ");

		System.out.print("Birth Date (dd-MM-yyyy)(1900-20/09/2023): ");
		LocalDate birthDay = Utilities.instance().getValidatedDate("Invalid, re-input date: ",
				"Invalid range, re-input(1900-20/09/2023): ", "01-01-1900", "20-09-2023");

		System.out.print("Phone: ");
		String phone = Utilities.instance().getValidatedString("^\\d{10}$", "Invalid, re-input phone number: ");

		System.out.print("Email: ");                           //[\w-\.]+@([\w-]+\.)+[\w-]{2,4}
		String email = Utilities.instance().getValidatedString("^[a-zA-Z0-9._]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$",
				"Invalid, re-input email: ");

		List<Certificate> certificates = new ArrayList<>();

		System.out.print("Number of certificates: ");
		int numCertificates = Utilities.instance().getValidatedNumber(0, Integer.MAX_VALUE, Integer.class);

		for (int i = 0; i < numCertificates; i++) {
			System.out.print("Certificate ID: ");
			String certificateID = Utilities.instance().getNewPrimaryKey("Cer ID");

			System.out.print("Certificate Name: ");
			String certificateName = Utilities.instance().getValidatedString("^[a-zA-Z ]+$",
					"Invalid, re-input certificate name: ");

			System.out.print("Certificate Rank: ");
			String certificateRank = Utilities.instance().getValidatedString("^[a-zA-Z ]+$",
					"Invalid, re-input certificate rank: ");

			System.out.print("Certificated Date (dd-MM-yyyy)(1970-20/09/2023): ");
			LocalDate certificatedDate = Utilities.instance().getValidatedDate("Invalid, re-input date: ",
					"Invalid range, re-input(1970-20/09/2023): ", "01-01-1970", "20-09-2023");

			certificates.add(new Certificate(certificateID, certificateName, certificateRank, certificatedDate));
		}

		switch (employeeType) {
		case 0:
			System.out.print("Experience in Years: ");
			int expInYear = Utilities.instance().getValidatedNumber(0, 100, Integer.class);

			System.out.print("Professional Skill: ");
			String proSkill = Utilities.instance().getValidatedString("^[a-zA-Z ]+$",
					"Invalid, re-input professional skill: ");

			addEmployee(new Experience(id, fullName, birthDay, phone, email, employeeType, certificates, expInYear,
					proSkill));
			break;
		case 1:
			System.out.print("Graduation Date (dd-MM-yyyy)(1980-20/09/2023): ");
			LocalDate graduationDate = Utilities.instance().getValidatedDate("Invalid, re-input date: ",
					"Invalid range, re-input(1980-20/09/2023): ", "01-01-1980", "20-09-2023");

			System.out.print("Graduation Rank: ");
			String graduationRank = Utilities.instance().getValidatedString("^[a-zA-Z ]+$",
					"Invalid, re-input graduation rank: ");

			System.out.print("Education: ");
			String education = Utilities.instance().getValidatedString("^[a-zA-Z ]+$", "Invalid, re-input education: ");

			addEmployee(new Fresher(id, fullName, birthDay, phone, email, employeeType, certificates, graduationDate,
					graduationRank, education));
			break;
		case 2:
			System.out.print("Majors: ");
			String majors = Utilities.instance().getValidatedString("^[a-zA-Z ]+$", "Invalid, re-input majors: ");

			System.out.print("Semester: ");
			String semester = Utilities.instance().getValidatedString("^[a-zA-Z0-9 ]+$",
					"Invalid, re-input semester: ");

			System.out.print("University Name: ");
			String universityName = Utilities.instance().getValidatedString("^[a-zA-Z ]+$",
					"Invalid, re-input university name: ");

			addEmployee(new Intern(id, fullName, birthDay, phone, email, employeeType, certificates, majors, semester,
					universityName));
			break;
		}
		System.out.println("Eployee with ID " + id + " added.");
	}

	public void editEmployee() {
		if (this.employees.isEmpty()) {
			System.out.println("There is no employee to update!");
			return;
		}

		System.out.print("Enter Employee ID to edit: ");
		String id = Utilities.instance().getExistingPrimaryKey("Employee ID");

		Employee employee = this.employees.stream().filter(e -> e.getId().equalsIgnoreCase(id)).findFirst()
				.orElse(null);

		System.out.print("Full Name: ");
		String fullName = Utilities.instance().getValidatedString("^[a-zA-Z ]+$", "Invalid, re-input full name: ");
		employee.setFullName(fullName);
		
		System.out.print("Birth Date (dd-MM-yyyy)(1900-20/09/2023): ");
		LocalDate birthDay = Utilities.instance().getValidatedDate("Invalid, re-input date: ",
				"Invalid range, re-input(1900-20/09/2023): ", "01-01-1900", "20-09-2023");
		employee.setBirthDay(birthDay);
		
		System.out.print("Phone: ");
		String phone = Utilities.instance().getValidatedString("^\\d{10}$", "Invalid, re-input phone number: ");
		employee.setPhone(phone);
		
		System.out.print("Email: ");
		String email = Utilities.instance().getValidatedString("^[a-zA-Z0-9._]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$",
				"Invalid, re-input email: ");
		employee.setEmail(email);
		
		System.out.print("Employee Type (current: " + employee.getEmployeeType() + "): ");
		int employeeType = Utilities.instance().getValidatedNumber(0, 2, Integer.class);
		employee.setEmployeeType(employeeType);
		
		if (employee instanceof Experience) {
			Experience experience = (Experience) employee;
			System.out.print("Experience in Years: ");
			int expInYear = Utilities.instance().getValidatedNumber(0, Integer.MAX_VALUE, Integer.class);
			experience.setExpInYear(expInYear);

			System.out.print("Professional Skill: ");
			String proSkill = Utilities.instance().getValidatedString("^[a-zA-Z ]+$",
					"Invalid, re-input professional skill: ");
			experience.setProSkill(proSkill);
		} else if (employee instanceof Fresher) {
			Fresher fresher = (Fresher) employee;
			System.out.print("Graduation Date (dd-MM-yyyy)(1980-20/09/2023): ");
			LocalDate graduationDate = Utilities.instance().getValidatedDate("Invalid, re-input date: ",
					"Invalid range, re-input(1980-20/09/2023): ", "01-01-1980", "20-09-2023");

			System.out.print("Graduation Rank: ");
			String graduationRank = Utilities.instance().getValidatedString("^[a-zA-Z ]+$",
					"Invalid, re-input graduation rank: ");

			System.out.print("Education: ");
			String education = Utilities.instance().getValidatedString("^[a-zA-Z ]+$", "Invalid, re-input education: ");

			fresher.setGraduationDate(graduationDate);
			fresher.setGraduationRank(graduationRank);
			fresher.setEducation(education);
		} else if (employee instanceof Intern) {
			Intern intern = (Intern) employee;
			System.out.print("Majors: ");
			String majors = Utilities.instance().getValidatedString("^[a-zA-Z ]+$", "Invalid, re-input majors: ");

			System.out.print("Semester: ");
			String semester = Utilities.instance().getValidatedString("^[a-zA-Z0-9 ]+$",
					"Invalid, re-input semester: ");

			System.out.print("University Name: ");
			String universityName = Utilities.instance().getValidatedString("^[a-zA-Z ]+$",
					"Invalid, re-input university name: ");

			intern.setMajors(majors);
			intern.setSemester(semester);
			intern.setUniversityName(universityName);
		}

		System.out.println("Employee with ID " + id + " has been updated.");
	}

	public void deleteEmployee() {
		if (this.employees.isEmpty()) {
			System.out.println("There is no employee to delete!");
			return;
		}
		System.out.print("Enter Employee ID to delete: ");
		String id = Utilities.instance().getExistingPrimaryKey("Employee ID");
		deleteEmployee(id);
		System.out.println("Employee with ID " + id + " has been deleted.");
	}

	public boolean addEmployee(Employee e) {
		return this.employees.add(e);
	}

	public boolean deleteEmployee(String id) {
		return this.employees.removeIf(e -> e.getId().equalsIgnoreCase(id));
	}

	public void showEmployees() {
		System.out.println("-----Employees List-----");
		employees.stream().forEach(e -> e.showInfor());
	}
	
	public void showEmployeesWithType() {
		System.out.println("0. Experience");
		System.out.println("1. Fresher");
		System.out.println("2. Intern");
		System.out.print("Select employee type: ");
		int employeeType = Utilities.instance().getValidatedNumber(0, 2, Integer.class);
		
		System.out.println("----- Employees List -----");
	    
	    for (Employee employee : employees) {
	        if ((employeeType == 0 && employee instanceof Experience) ||
	            (employeeType == 1 && employee instanceof Fresher) ||
	            (employeeType == 2 && employee instanceof Intern)) {
	            employee.showInfor();
	        }
	    }
	}
}
