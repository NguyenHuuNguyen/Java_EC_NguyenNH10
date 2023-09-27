package java_core_bai7;

import common.Utilities;

public class Main {

	public static void main(String[] args) {
		while (true) {
			System.out.println("===== Course Management =====");
			System.out.println("1. Add new teacher");
			System.out.println("2. Add new student");
			System.out.println("3. Add new course");
			System.out.println("4. Show all teachers");
			System.out.println("5. Show all students");
			System.out.println("6. Show all courses");
			System.out.println("7. Calculate Income for teacher");
			System.out.println("8. Exit");
			System.out.print("Input choice(1-8): ");
			int choice = Utilities.instance().getValidatedNumber(1, 8, Integer.class);

			switch (choice) {
			case 1:
				CourseManagement.instance().addTeacher();
				break;
			case 2:
				CourseManagement.instance().addStudent();
				break;
			case 3:
				CourseManagement.instance().addCourse();
				break;
			case 4:
				CourseManagement.instance().showTeachers();
				break;
			case 5:
				CourseManagement.instance().showStudents();
				break;
			case 6:
				CourseManagement.instance().showCourses();
				break;
			case 7:
				CourseManagement.instance().calculateTotalIncomeForTeachers();
				break;
			case 8:
				System.out.println("===== Exited =====");
				System.exit(0);
			default:
				System.out.println("Invalid choice");
			}
			Utilities.instance().scanner.nextLine();
		}
	}

}
