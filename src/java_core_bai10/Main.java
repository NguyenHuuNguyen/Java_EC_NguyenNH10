package java_core_bai10;

import java.util.Map;

import common.Utilities;

public class Main {

	public static void main(String[] args) {
		while (true) {
			System.out.print("Input string: ");
			String input = Utilities.instance().getValidatedString("^(?!\\s*$).+$", "Input string: ");
			
			if (input.equalsIgnoreCase("break")) System.exit(0);
			
			int numberOfWords = StringUtilities.instance().countWords(input);
			int numberOfCharA = StringUtilities.instance().countCharacter(input, "a");
			String trimmedString = StringUtilities.instance().trimString(input);
			Map<String, Integer> wordsWithFrequency = StringUtilities.instance().countWordsWithFrequency(input);
			
			System.out.println("------------------------------");
			System.out.println("Number of words: " + numberOfWords);
			System.out.println("Number of char A: " + numberOfCharA);
			System.out.println("Trimmed string: " + trimmedString);
			System.out.println("List words with frequency");
			
			wordsWithFrequency.entrySet().forEach(e -> {
				System.out.println(String.format("%-10s : %s", e.getKey(), e.getValue()));
			});
			
			System.out.println("------------------------------");
			Utilities.instance().scanner.nextLine();
		}
	}

}
