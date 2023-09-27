package java_core_bai5;

public class Customer {
	private String identityNumber;
	private String name;
	private int age;

	public Customer(String identityNumber, String name, int age) {
		this.identityNumber = identityNumber;
		this.name = name;
		this.age = age;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
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
	
	public void showInfor() {
        System.out.println("Customer Information:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Identity Number: " + identityNumber);
    }
}
