//                       _oo0oo_
//                      o8888888o
//                      88" . "88
//                      (| -_- |)
//                      0\  =  /0
//                    ___/`---'\___
//                  .' \\|     |// '.
//                 / \\|||  :  |||// \
//                / _||||| -:- |||||- \
//               |   | \\\  -  /// |   |
//               | \_|  ''\---/''  |_/ |
//               \  .-\__  '-'  ___/-. /
//             ___'. .'  /--.--\  `. .'___
//          ."" '<  `.___\_<|>_/___.' >' "".
//         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//         \  \ `_.   \_ __\ /__ _/   .-` /  /
//     =====`-.____`.___ \_____/___.-`___.-'=====
//                       `=---='
//
//     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//            Phật phù hộ, không bao giờ BUG
//     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
package common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {
	private static Utilities _instance;
	public Scanner scanner = new Scanner(System.in);
	public static Map<String, List<String>> primaryKeys = new HashMap<>();

	public static Utilities instance() {
		if (_instance == null) {
			_instance = new Utilities();
		}
		return _instance;
	}

	public void addPrimaryKey(String key, String primaryKey) {
		if (!primaryKeys.containsKey(key)) {
			primaryKeys.put(key, new ArrayList<>());
		}
		List<String> values = primaryKeys.get(key);
		values.add(primaryKey);
	}

	public String getNewPrimaryKey(String keyName) {
		while (true) {
			String val = Utilities.instance().getValidatedString("^[a-zA-Z0-9]+$",
					"Invalid, re-input" + keyName + ": ");
			if (checkDuplicatePrimaryKey(keyName, val)) {
				System.out.print(String.format("%s existed, please re-input %s: ", keyName, keyName));
			} else {
				addPrimaryKey(keyName, val);
				return val;
			}
		}
	}

	public String getExistingPrimaryKey(String keyName) {
		String primaryKeyValue;
		while (true) {
			primaryKeyValue = Utilities.instance().getValidatedString("^[a-zA-Z0-9]+$",
					"Invalid, re-input " + keyName + " : ");
			if (Utilities.instance().checkDuplicatePrimaryKey(keyName, primaryKeyValue)) {
				break;
			} else {
				System.out.print(keyName + " not exist, re-input: ");
			}
		}
		return primaryKeyValue;
	}

	public boolean checkDuplicatePrimaryKey(String key, String primaryKey) {
		if (primaryKeys.containsKey(key)) {
			List<String> values = primaryKeys.get(key);
			return values.contains(primaryKey);
		}
		return false;
	}

	public <T extends Number> T getValidatedNumber(T beginNumber, T endNumber, Class<T> numberType) {
		T value = null;

		while (true) {
			try {
				if (numberType == Integer.class) {
					value = numberType.cast(scanner.nextInt());
				} else if (numberType == Double.class) {
					value = numberType.cast(scanner.nextDouble());
				} else if (numberType == Float.class) {
					value = numberType.cast(scanner.nextFloat());
				}

				scanner.nextLine();

				double doubleValue = value.doubleValue();
				if (doubleValue < beginNumber.doubleValue() || doubleValue > endNumber.doubleValue()) {
					System.out.print(String.format("Invalid, please re-input(%s-%s): ", beginNumber, endNumber));
				} else {
					break;
				}
			} catch (Exception e) {
				scanner.nextLine();
				System.out.print(String.format("Invalid, please re-input(%s-%s): ", beginNumber, endNumber));
			}
		}

		return value;
	}

	public String getValidatedString(String regex, String invalidMessage) {
		String val;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher;

		while (true) {
			val = scanner.nextLine().trim();
			matcher = pattern.matcher(val);
			if (!matcher.matches()) {
				System.out.print(invalidMessage);
			} else
				break;
		}

		return val;
	}

	public String getValidatedString(String regex, Exception customException) throws Exception {
		String val = scanner.nextLine().trim();
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(val);
		
		if (!matcher.matches()) {
			throw customException;
		}
		
		return val;
	}

	// nên đưa vào là Date hơn là string vì có thể đưa vào Date.now()
	public LocalDate getValidatedDate(String invalidMessage, String outOfRangeMessage, String minDateStr,
			String maxDateStr) {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date = null;
		LocalDate minDate = LocalDate.parse(minDateStr, dateFormatter);
		LocalDate maxDate = LocalDate.parse(maxDateStr, dateFormatter);

		while (true) {
			String dateString = scanner.nextLine().trim();

			try {
				String[] dateParts = dateString.split("-");
				int day = Integer.parseInt(dateParts[0]);
				int month = Integer.parseInt(dateParts[1]);
				int year = Integer.parseInt(dateParts[2]);

				if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
					if (month == 2 && (day < 1 || day > 29)) {
						System.out.print(invalidMessage);
					}
				} else {
					if (month == 2 && (day < 1 || day > 28)) {
						System.out.print(invalidMessage);
					}
				}
				date = LocalDate.parse(dateString, dateFormatter);

				if (date.isAfter(maxDate) || date.isBefore(minDate)) {
					System.out.print(outOfRangeMessage);
				} else {
					break;
				}
			} catch (DateTimeParseException e) {
				System.out.print(invalidMessage);
			}
		}

		return date;
	}
}
