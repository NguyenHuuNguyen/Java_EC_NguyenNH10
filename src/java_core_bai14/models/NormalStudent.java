package java_core_bai14.models;

import java.time.LocalDate;

public class NormalStudent extends Student {
    private int englishScore;
    private double entryTestScore;

    public NormalStudent(String fullName, LocalDate dateOfBirth, String sex, String phoneNumber, String universityName,
                         String gradeLevel, int englishScore, double entryTestScore) {
        super(fullName, dateOfBirth, sex, phoneNumber, universityName, gradeLevel);
        this.englishScore = englishScore;
        this.entryTestScore = entryTestScore;
    }

	@Override
	public void showInfor() {
		System.out.println("Normal Student Information:");
	    System.out.println("Full Name: " + getFullName());
	    System.out.println("Date of Birth: " + getDateOfBirth());
	    System.out.println("Sex: " + getSex());
	    System.out.println("Phone Number: " + getPhoneNumber());
	    System.out.println("University Name: " + getUniversityName());
	    System.out.println("Grade Level: " + getGradeLevel());
	    System.out.println("English Score: " + getEnglishScore());
	    System.out.println("Entry Test Score: " + getEntryTestScore());
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public void setEnglishScore(int englishScore) {
		this.englishScore = englishScore;
	}

	public double getEntryTestScore() {
		return entryTestScore;
	}

	public void setEntryTestScore(double entryTestScore) {
		this.entryTestScore = entryTestScore;
	}
}