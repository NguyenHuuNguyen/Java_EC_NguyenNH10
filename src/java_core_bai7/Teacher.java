package java_core_bai7;

public class Teacher extends Person {
	private String teacherIdentityNumber;
	private int basicSalary;

	public Teacher(String name, int age, String placeOfBirth, String teacherIdentityNumber, int basicSalary) {
		super(name, age, placeOfBirth);
		this.teacherIdentityNumber = teacherIdentityNumber;
		this.basicSalary = basicSalary;
	}

	public String getTeacherIdentityNumber() {
		return teacherIdentityNumber;
	}

	public void setTeacherIdentityNumber(String teacherIdentityNumber) {
		this.teacherIdentityNumber = teacherIdentityNumber;
	}

	public int getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(int basicSalary) {
		this.basicSalary = basicSalary;
	}

	public void showTeacher() {
        System.out.println("Teacher Identity Number: " + teacherIdentityNumber);
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Place of Birth: " + getPlaceOfBirth());
        System.out.println("Basic Salary: $" + basicSalary);
    }
}
