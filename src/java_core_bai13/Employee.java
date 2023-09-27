package java_core_bai13;

import java.time.LocalDate;
import java.util.List;

public abstract class Employee {
	protected String id;
	protected String fullName;
	protected LocalDate birthDay;
	protected String phone;
	protected String email;
	protected int employeeType;
	protected List<Certificate> certificates;
	static private int employeeCount = 0;

	public Employee(String id, String fullName, LocalDate birthDay, String phone, String email, int employeeType,
			List<Certificate> certificates) {
		this.id = id;
		this.fullName = fullName;
		this.birthDay = birthDay;
		this.phone = phone;
		this.email = email;
		this.employeeType = employeeType;
		this.certificates = certificates;
		employeeCount++;
	}

	public List<Certificate> getCertificates() {
		return certificates;
	}

	public void setCertificates(List<Certificate> certificates) {
		this.certificates = certificates;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(int employeeType) {
		this.employeeType = employeeType;
	}

	public int getEmployeeCount() {
		return employeeCount;
	}
	
	public abstract void showInfor();
}
