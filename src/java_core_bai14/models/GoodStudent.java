package java_core_bai14.models;

import java.time.LocalDate;

public class GoodStudent extends Student {
	private double gpa;
	private String bestRewardName;

	public GoodStudent(String fullName, LocalDate dateOfBirth, String sex, String phoneNumber, String universityName,
			String gradeLevel, double gpa, String bestRewardName) {
		super(fullName, dateOfBirth, sex, phoneNumber, universityName, gradeLevel);
		this.gpa = gpa;
		this.bestRewardName = bestRewardName;
	}

	@Override
	public void showInfor() {
		System.out.println("Good Student Information:");
	    System.out.println("Full Name: " + getFullName());
	    System.out.println("Date of Birth: " + getDateOfBirth());
	    System.out.println("Sex: " + getSex());
	    System.out.println("Phone Number: " + getPhoneNumber());
	    System.out.println("University Name: " + getUniversityName());
	    System.out.println("Grade Level: " + getGradeLevel());
	    System.out.println("GPA: " + getGpa());
	    System.out.println("Best Reward Name: " + getBestRewardName());
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getBestRewardName() {
		return bestRewardName;
	}

	public void setBestRewardName(String bestRewardName) {
		this.bestRewardName = bestRewardName;
	}
}