package java_core_bai8;

public class Student {
	private String studentName;
	private int age;
	private String className;

	public Student(String studentName, int age, String className) {
		this.studentName = studentName;
		this.age = age;
		this.className = className;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
}
