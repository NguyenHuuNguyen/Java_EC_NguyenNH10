package exception_handling;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class UncheckException {
	public static void Main(String arg[]) throws FileNotFoundException {
		FileReader fileReader = new FileReader("abc.txt");
	}
}
