package java_core_bai7;

import java.util.ArrayList;
import java.util.List;

import common.Utilities;

public class CourseManagement {
	private List<Teacher> teachers = new ArrayList<Teacher>();
	private List<Student> students = new ArrayList<Student>();
	private List<Course> courses = new ArrayList<Course>();
	private static CourseManagement _instance;
	
	public static CourseManagement instance() {
		if (_instance == null) {
			_instance = new CourseManagement();
		}
		return _instance;
	}
	
	private CourseManagement() {
		
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public void addStudent() {
        System.out.println("===== Add New Student =====");
        System.out.print("Student name: ");
        String name = Utilities.instance().getValidatedString("^[A-Za-z\\s]*$", "Invalid name format. Re-enter student's name: ");
        System.out.print("Student identity number: ");
        String studentIdentityNumber = Utilities.instance().getNewPrimaryKey("student identity number");
        System.out.print("Age: ");
        int age = Utilities.instance().getValidatedNumber(15, 50, Integer.class);
        System.out.print("Place of birth: ");
        String placeOfBirth = Utilities.instance().getValidatedString("^[A-Za-z\\s]*$", "Invalid place of birth format. Re-enter place of birth: ");
        System.out.print("Major: ");
        String major = Utilities.instance().getValidatedString("^[A-Za-z\\s]*$", "Invalid major format. Re-enter major: ");

        Student newStudent = new Student(studentIdentityNumber, name, age, placeOfBirth, major);
        students.add(newStudent);
    }
	
	public void addTeacher() {
        System.out.println("===== Add New Teacher =====");
        System.out.print("Teacher name: ");
        String name = Utilities.instance().getValidatedString("^[A-Za-z\\s]*$", "Invalid name format. Re-enter teacher's name: ");
        System.out.print("Age: ");
        int age = Utilities.instance().getValidatedNumber(20, 70, Integer.class);
        System.out.print("Place of birth: ");
        String placeOfBirth = Utilities.instance().getValidatedString("^[A-Za-z\\s]*$", "Invalid place of birth format. Re-enter place of birth: ");
        System.out.print("Teacher identity number: ");
        String teacherIdentityNumber = Utilities.instance().getNewPrimaryKey("teacher identity number");
        System.out.print("Basic salary: ");
        int basicSalary = Utilities.instance().getValidatedNumber(0, Integer.MAX_VALUE, Integer.class);

        Teacher newTeacher = new Teacher(name, age, placeOfBirth, teacherIdentityNumber, basicSalary);
        teachers.add(newTeacher);
    }
	
	public void addCourse() {
		if (students.isEmpty()) {
			System.out.println("There is no student to add to course.");
			return;
		}
		
		if (teachers.isEmpty()) {
			System.out.println("There is no teacher to add to course.");
			return;
		}
		
		System.out.print("Course name: ");
		String courseName = Utilities.instance().getValidatedString("^[A-Za-z0-9\\s]*$", "Invalid course name format. Re-enter: ");

        System.out.print("Select teacher for the course (by teacher identity number): ");
        String teacherIdentityNumber = Utilities.instance().getExistingPrimaryKey("teacher identity number");
        Teacher selectedTeacher = null;

        for (Teacher teacher : teachers) {
            if (teacher.getTeacherIdentityNumber().equals(teacherIdentityNumber)) {
                selectedTeacher = teacher;
                break;
            }
        }

        if (selectedTeacher == null) {
            System.out.println("Teacher not found.");
            return;
        }

        List<Student> selectedStudents = new ArrayList<Student>();
        while (true) {
            System.out.print("Select students for the course (by student identity number, or press Enter to finish): ");
            String studentIdentityNumber = Utilities.instance().scanner.nextLine();
            if (studentIdentityNumber.isEmpty()) {
                break;
            }

            Student selectedStudent = null;
            for (Student student : students) {
                if (student.getStudentIdentityNumber().equals(studentIdentityNumber)) {
                    selectedStudent = student;
                    break;
                }
            }

            if (selectedStudent != null) {
                selectedStudents.add(selectedStudent);
                System.out.println("Student added to the course.");
            } else {
                System.out.println("Student not found.");
            }
        }
        
        System.out.print("Bonus salary for teacher: ");
        int bonusSalaryForTeacher = Utilities.instance().getValidatedNumber(0, 1000, Integer.class);
        System.out.print("Penalty salary for teacher: ");
        int penaltySalaryForTeacher = Utilities.instance().getValidatedNumber(0, 1000, Integer.class);

        Course newCourse = new Course(courseName, selectedTeacher, selectedStudents, bonusSalaryForTeacher, penaltySalaryForTeacher);
        courses.add(newCourse);
        System.out.println("Course added successfully.");
	}
	
	public void showStudents() {
        System.out.println("===== Students List =====");
        for (Student student : students) {
            student.showStudent();
            System.out.println("-----------------------");
        }
    }

    public void showTeachers() {
        System.out.println("===== Teachers List =====");
        for (Teacher teacher : teachers) {
            teacher.showTeacher();
            System.out.println("-----------------------");
        }
    }

    public void showCourses() {
        System.out.println("===== Courses List =====");
        for (Course course : courses) {
        	System.out.println("-----------------------");
            course.showCourse();
        }
    }
    
    public void calculateTotalIncomeForTeachers() {
        for (Teacher teacher : teachers) {
            int totalIncome = teacher.getBasicSalary();;

            for (Course course : courses) {
                if (course.getTeacher() == teacher) {
                    totalIncome += course.getBonusSalaryForTeacher() - course.getPenaltySalaryForTeacher();
                }
            }
            System.out.println("-----------------------");
            System.out.println("Teacher Name: " + teacher.getName());
            System.out.println("Total Income: " + totalIncome);
        }
    }
}
