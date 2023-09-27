package java_core_bai13;

import java.time.LocalDate;
import java.util.List;

public class Intern extends Employee {
	private String majors;
	private String semester;
	private String universityName;

	public Intern(String id, String fullName, LocalDate birthDay, String phone, String email, int employeeType,
			List<Certificate> certificates, String majors, String semester, String universityName) {
		super(id, fullName, birthDay, phone, email, employeeType, certificates);
		this.majors = majors;
		this.semester = semester;
		this.universityName = universityName;
	}

	public String getMajors() {
		return majors;
	}

	public void setMajors(String majors) {
		this.majors = majors;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	@Override
	public void showInfor() {
		String output = String.format(
				"Employee ID: %-10s | Full Name: %-20s | Birth Date: %-15s\nPhone: %-15s | Email: %-30s | Employee Type: %-5s\nMajors: %-20s | Semester: %-10s | University: %-30s",
				id, fullName, birthDay, phone, email, employeeType, majors, semester, universityName);
		System.out.println(output);
		if (certificates.size() != 0) {
			System.out.println("--Certificates--");
			certificates.forEach(certificate -> certificate.showInfor());
		}
	}
}
