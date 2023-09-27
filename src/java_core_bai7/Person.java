package java_core_bai7;

public class Person {
	private String name;
	private int age;
	private String placeOfBirth;
	
	public Person(String name, int age, String placeOfBirth) {
		this.name = name;
		this.age = age;
		this.placeOfBirth = placeOfBirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}
}
