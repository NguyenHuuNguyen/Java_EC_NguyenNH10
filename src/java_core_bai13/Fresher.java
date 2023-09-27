package java_core_bai13;

import java.time.LocalDate;
import java.util.List;

public class Fresher extends Employee {
	private LocalDate graduationDate;
	private String graduationRank;
	private String education;

	public Fresher(String id, String fullName, LocalDate birthDay, String phone, String email, int employeeType,
			List<Certificate> certificates, LocalDate graduationDate, String graduationRank, String education) {
		super(id, fullName, birthDay, phone, email, employeeType, certificates);
		this.graduationDate = graduationDate;
		this.graduationRank = graduationRank;
		this.education = education;
	}

	public LocalDate getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(LocalDate graduationDate) {
		this.graduationDate = graduationDate;
	}

	public String getGraduationRank() {
		return graduationRank;
	}

	public void setGraduationRank(String graduationRank) {
		this.graduationRank = graduationRank;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@Override
	public void showInfor() {
		String output = String.format(
				"Employee ID: %-10s | Full Name: %-20s | Birth Date: %-15s\nPhone: %-15s | Email: %-30s | Employee Type: %-5s\nGraduation Date: %-15s | Graduation Rank: %-15s | Education: %-20s",
				id, fullName, birthDay, phone, email, employeeType, graduationDate, graduationRank, education);
		System.out.println(output);
		if (certificates.size() != 0) {
			System.out.println("--Certificates--");
			certificates.forEach(certificate -> certificate.showInfor());
		}
	}
}
