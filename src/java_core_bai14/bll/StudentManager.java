package java_core_bai14.bll;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import common.Utilities;
import java_core_bai14.dal.Dao;
import java_core_bai14.models.GoodStudent;
import java_core_bai14.models.NormalStudent;
import java_core_bai14.models.Student;

public class StudentManager {
	private static StudentManager _instance;

	private StudentManager() {

	}

	public static StudentManager instance() {
		if (_instance == null) {
			_instance = new StudentManager();
		}
		return _instance;
	}

	public void addStudent() {
		System.out.println("Enter student information:");

		try {
			System.out.print("Full Name: ");
			String fullName = Utilities.instance().getValidatedString("^[a-zA-Z ]{10,50}$",
					"Invalid full name format. Please use only letters and spaces (10-50 characters): ");

			System.out.print("Date of Birth (dd-MM-yyyy): ");
			LocalDate dob = Utilities.instance().getValidatedDate(
					"Invalid date format. Please use the format dd-MM-yyyy: ",
					"Date is out of range. Please enter a valid date.", "01-01-1900", "31-12-2030");

			System.out.print("Sex (Male/Female/Other): ");
			String sex = Utilities.instance().getValidatedString("^(Male|Female|Other)$",
					"Invalid sex format. Please use Male, Female, or Other: ");

			System.out.print("Phone Number: ");
			String phoneNumber = Utilities.instance().getValidatedString("^(090|098|091|031|035|038)\\d{7}$",
					"Invalid phone number format. Please use a valid format: ");

			System.out.print("University Name: ");
			String universityName = Utilities.instance().getValidatedString("^[a-zA-Z0-9 ]{1,255}$",
					"Invalid university name format. Please use only letters, numbers, and spaces (1-255 characters): ");

			System.out.print("Grade Level: ");
			String gradeLevel = Utilities.instance().getValidatedString("^[a-zA-Z0-9 ]{1,15}$",
					"Invalid grade level format. Please use only letters, numbers, and spaces (1-15 characters): ");

			System.out.print("Student Type (1 for GoodStudent, 2 for NormalStudent): ");
			int studentType = Utilities.instance().getValidatedNumber(1, 2, Integer.class);

			if (studentType == 1) {
				System.out.print("GPA (0.0 - 4.0): ");
				double gpa = Utilities.instance().getValidatedNumber(0.0, 4.0, Double.class);

				System.out.print("Best Reward Name: ");
				String bestRewardName = Utilities.instance().getValidatedString("^[a-zA-Z0-9 ]{1,255}$",
						"Invalid reward name format. Please use only letters, numbers, and spaces (1-255 characters): ");

				GoodStudent student = new GoodStudent(fullName, dob, sex, phoneNumber, universityName, gradeLevel, gpa,
						bestRewardName);
				Dao.instance().addStudent(student);
			} else if (studentType == 2) {
				System.out.print("English Score (0 - 990): ");
				int englishScore = Utilities.instance().getValidatedNumber(0, 990, Integer.class);

				System.out.print("Entry Test Score (0.0 - 10.0): ");
				double entryTestScore = Utilities.instance().getValidatedNumber(0.0, 10.0, Double.class);

				NormalStudent student = new NormalStudent(fullName, dob, sex, phoneNumber, universityName, gradeLevel,
						englishScore, entryTestScore);
				Dao.instance().addStudent(student);
			} else {
				System.out.println("Invalid student type.");
			}

			System.out.println("Student added successfully!");
		} catch (Exception e) {
			System.out.println("Input files have unknow errors");
			System.out.println("Error adding student: " + e.getMessage());
		}
	}

	public void showStudents(List<Student> students) {
		Collections.sort(students, Comparator
			    .comparing(Student::getFullName)
			    .thenComparing(Student::getPhoneNumber));
		
		for (Student student : students) {
			student.showInfor();
			System.out.println("----------------------------------");
		}
	}

	public void showAllStudents() {
		System.out.println("====List of Students====");
		List<Student> students = Dao.instance().getStudents();

		if (students.isEmpty()) {
			System.out.println("There is no student to show");
			return;
		}

		showStudents(students);
	}
	
	public void selectCandidates() {
		System.out.print("Input number of candidate (1-20): ");
		int numberOfCandidates = Utilities.instance().getValidatedNumber(1, 20, Integer.class);
        List<Student> goodStudents = Dao.instance().getGoodStudents();
        List<Student> normalStudents = Dao.instance().getNormalStudents();

        if (numberOfCandidates > goodStudents.size()) {
        	System.out.println("====List of " + goodStudents.size() + " good students====");
            showStudents(goodStudents);
            numberOfCandidates -= goodStudents.size();
        } else {
        	goodStudents.sort(Comparator.<Student, Double>comparing(student -> {
                if (student instanceof GoodStudent) {
                    return ((GoodStudent) student).getGpa();
                } else {
                    return 0.0; 
                }
            }).reversed()
            .thenComparing(Student::getFullName));

            System.out.println("====List of " + numberOfCandidates + " good students====");
            showStudents(goodStudents.subList(0, numberOfCandidates));
            return;
        }

        if (numberOfCandidates > normalStudents.size()) {
            System.out.println("====List of " + normalStudents.size() + " normal students====");
            showStudents(normalStudents);
            return;
        } else {
        	normalStudents.sort(Comparator.<Student, Double>comparing(student -> {
                if (student instanceof NormalStudent) {
                    return ((NormalStudent) student).getEntryTestScore();
                } else {
                    return 0.0;
                }
            }, Double::compare)
            .thenComparing(student -> {
                if (student instanceof NormalStudent) {
                    return Double.valueOf(((NormalStudent) student).getEnglishScore());
                } else {
                    return 0.0;
                }
            }, Double::compare)
            .thenComparing(Student::getFullName));

            System.out.println("====List of " + numberOfCandidates + " normal students====");
            showStudents(normalStudents.subList(0, numberOfCandidates));
        }
    }
}
