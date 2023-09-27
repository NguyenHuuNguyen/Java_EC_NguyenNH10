package jpe.S.A101;

public class Test2 {
	static class Animal{
		int val = 5;
		
		public void bark() {
			System.out.println("---");
		}
	}
	
	static class Dog extends Animal{
		int val = 10;
		
		public void bark() {
			System.out.println("Gau");
		}
		
		public void run() {
			System.out.println("Brr");
		}
	}

	public static void main(String[] args) {
		Animal a = new Dog();
		System.out.println(a.val);
		Dog d = (Dog)a;
		d.run();
		System.out.println(d.val);
		String s1 = "asd";
		String s2 = "111";
		s1.compareTo(s2);
		s1.charAt(0);
	}

}
