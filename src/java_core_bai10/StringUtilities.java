package java_core_bai10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringUtilities {
	private static StringUtilities _instance;

	public static StringUtilities instance() {
		if (_instance == null) {
			_instance = new StringUtilities();
		}
		return _instance;
	}

	private StringUtilities() {

	}

	public int countWords(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}
		
		String[] words = input.split("\\s+");
		return words.length;
	}
	
	public Map<String, Integer> countWordsWithFrequency(String input) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        
        if (input == null || input.isEmpty()) {
            return wordFrequency;
        }

        String[] words = input.split("\\s+");

        for (String word : words) {
            String key = word.toLowerCase();

            if (wordFrequency.containsKey(key)) {
                wordFrequency.put(key, wordFrequency.get(key) + 1);
            } else {
                wordFrequency.put(key, 1);
            }
        }

        return wordFrequency;
    }
	
	public int countCharacter(String input, String c) {
//        if (input == null || input.isEmpty()) {
//            return 0;
//        }
//
//        int count = 0;
//        for (int i = 0; i < input.length(); i++) {
//            char c = input.charAt(i);
//            if (c == 'A' || c == 'a') {
//                count++;
//            }
//        }
//
//        return count;
		return (int) Arrays.stream(input.split("")).filter(i -> i.equalsIgnoreCase(c)).count();
    }
	
	public String trimString(String input) {
		return input.trim().replaceAll("\\s+", " ");
	}
}
