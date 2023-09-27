package java_core_bai7;

public class Student extends Person {
	private String studentIdentityNumber;
	private String major;

	public Student(String studentIdentityNumber, String name, int age, String placeOfBirth, String major) {
		super(name, age, placeOfBirth);
		this.major = major;
		this.studentIdentityNumber = studentIdentityNumber;
	}

	public String getStudentIdentityNumber() {
		return studentIdentityNumber;
	}

	public void setStudentIdentityNumber(String studentIdentityNumber) {
		this.studentIdentityNumber = studentIdentityNumber;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public void showStudent() {
        System.out.println("Student Identity Number: " + studentIdentityNumber);
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Place of Birth: " + getPlaceOfBirth());
        System.out.println("Major: " + major);
    }
}
