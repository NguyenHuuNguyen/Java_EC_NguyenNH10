package exception_handling;

public class FinallizeExample {
	static class A {
		@Override
		protected void finalize(){
	        // Phương thức finalize() sẽ được gọi trước khi đối tượng bị thu gom rác
	        System.out.println("Do something");
	    }
	}
	public static void main(String[] args) {
		A a = new A();   
        a = null;
        System.gc(); // gọi garbage conllection
	}
}
