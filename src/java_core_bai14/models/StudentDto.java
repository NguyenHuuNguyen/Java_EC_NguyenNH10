package java_core_bai14.models;

import java.util.Date;

public class StudentDto {
    private String fullName;
    private Date dateOfBirth;
    private String sex;
    private String phoneNumber;
    private String universityName;
    private String gradeLevel;
    private double gpa;
    private String bestRewardName;
    private int englishScore;
    private double entryTestScore;
    private int type;

    public StudentDto(String fullName, Date dateOfBirth, String sex, String phoneNumber, String universityName,
                      String gradeLevel, double gpa, String bestRewardName, int englishScore, double entryTestScore, int type) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.universityName = universityName;
        this.gradeLevel = gradeLevel;
        this.gpa = gpa;
        this.bestRewardName = bestRewardName;
        this.englishScore = englishScore;
        this.entryTestScore = entryTestScore;
        this.type = type;
    }

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getGradeLevel() {
		return gradeLevel;
	}

	public void setGradeLevel(String gradeLevel) {
		this.gradeLevel = gradeLevel;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}