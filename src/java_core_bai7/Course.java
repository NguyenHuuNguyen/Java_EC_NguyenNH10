package java_core_bai7;

import java.util.ArrayList;
import java.util.List;

public class Course {
	private String courseName;
	private Teacher teacher;
	private List<Student> students = new ArrayList<Student>();
	private int bonusSalaryForTeacher;
	private int penaltySalaryForTeacher;

	public Course(String courseName, Teacher teacher, List<Student> students, int bonusSalaryForTeacher,
			int penaltySalaryForTeacher) {
		super();
		this.courseName = courseName;
		this.teacher = teacher;
		this.students = students;
		this.bonusSalaryForTeacher = bonusSalaryForTeacher;
		this.penaltySalaryForTeacher = penaltySalaryForTeacher;
	}

	public int getPenaltySalaryForTeacher() {
		return penaltySalaryForTeacher;
	}

	public void setPenaltySalaryForTeacher(int penaltySalaryForTeacher) {
		this.penaltySalaryForTeacher = penaltySalaryForTeacher;
	}

	public int getBonusSalaryForTeacher() {
		return bonusSalaryForTeacher;
	}

	public void setBonusSalaryForTeacher(int bonusSalaryForTeacher) {
		this.bonusSalaryForTeacher = bonusSalaryForTeacher;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void showCourse() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Teacher: " + teacher.getName());
        System.out.println("Bonus Salary for Teacher: $" + bonusSalaryForTeacher);
        System.out.println("Penalty Salary for Teacher: $" + penaltySalaryForTeacher);
        System.out.println("Student List:");
        for (Student student : students) {
            System.out.println("Student Identity Number: " + student.getStudentIdentityNumber());
            System.out.println("Student Name: " + student.getName());
            System.out.println("Student Age: " + student.getAge());
            System.out.println("Major: " + student.getMajor());
        }
    }
}
