package java_core_bai6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import common.Utilities;

public class StudentManagement {
	private static StudentManagement _instance;
	private List<Student> students = new ArrayList<>();

	private StudentManagement() {
		
	}

	public static StudentManagement instance() {
		if (_instance == null) {
			_instance = new StudentManagement();
		}
		return _instance;
	}

	public void addStudent() {
		System.out.print("Enter student's name: ");
		String name = Utilities.instance().getValidatedString("^[A-Za-z ]+$", "Invalid name, re-enter: ");
		System.out.print("Enter student's age: ");
		int age = Utilities.instance().getValidatedNumber(0, 120, Integer.class);
		System.out.print("Enter student's hometown: ");
		String hometown = Utilities.instance().getValidatedString("^[A-Za-z ]+$", "Invalid hometown, re-enter: ");
		students.add(new Student(name, age, hometown));
		System.out.println("Student added successfully.");
	}

	public void showStudentsAt20() {
		List<Student> studentsAt20 = students.stream().filter(student -> student.getAge() == 20)
				.collect(Collectors.toList());

		if (studentsAt20.isEmpty()) {
			System.out.println("No students aged 20 found.");
		} else {
			System.out.println("Students aged 20:");
			for (Student student : studentsAt20) {
				student.showInfo();
			}
		}
	}

	public void showNumberOfStudents23FromDN() {
		long count = students.stream()
				.filter(student -> student.getAge() == 23 && student.getHomeTown().equalsIgnoreCase("DN")).count();

		System.out.println("Number of students aged 23 and from DN: " + count);
	}

	public void showAllStudents() {
		if (students.isEmpty()) {
			System.out.println("No students found.");
		} else {
			System.out.println("All students:");
			for (Student student : students) {
				student.showInfo();
			}
		}
	}
}
