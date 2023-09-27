package java_core_bai13;

import java.time.LocalDate;
import java.util.List;

public class Experience extends Employee {
	private int expInYear;
	private String proSkill;

	public Experience(String id, String fullName, LocalDate birthDay, String phone, String email, int employeeType,
			List<Certificate> certificates, int expInYear, String proSkill) {
		super(id, fullName, birthDay, phone, email, employeeType, certificates);
		this.expInYear = expInYear;
		this.proSkill = proSkill;
	}

	public int getExpInYear() {
		return expInYear;
	}

	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}

	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}

	@Override
	public void showInfor() {
		String output = String.format(
				"Employee ID: %-10s | Full Name: %-20s | Birth Date: %-15s\nPhone: %-15s | Email: %-30s | Employee Type: %-5s\nExperience in Years: %-5s | Professional Skill: %-20s",
				id, fullName, birthDay, phone, email, employeeType, expInYear, proSkill);
		System.out.println(output);
		if (certificates.size() != 0) {
			System.out.println("--Certificates--");
			certificates.stream().forEach(c -> c.showInfor());
		}
	}
}
