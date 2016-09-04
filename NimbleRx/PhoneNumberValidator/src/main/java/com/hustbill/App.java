package com.hustbill;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.twilio.sdk.TwilioRestException;

/**
 * 1st round Validated Cell Phone Numbers: 3605532393 2025550104 2025550197
 * 2025550156 2025550142 2025550117 2025550169 Run time: 5988ms
 * 
 * 2nd round Validated Cell Phone Numbers: Using LRU Cache 3605532393 2025550104
 * 2025550197 2025550156 2025550142 2025550117 2025550169 Run time: 5145ms
 *
 * 
 */
public class App {

	private static Set<String> readFromFile() throws IOException {
		Set<String> phoneNumbers = new HashSet<String>();
		final Path inputPath = Paths.get("src/main/resources/phone.txt");

		Stream<String> lines = Files.lines(inputPath);
		Map<String, Long> words = lines.map((String line) -> line.split("\\n")).flatMap(Arrays::stream)
				.map(String::toLowerCase).collect(groupingBy(s -> s, counting()));
		lines.close();

		phoneNumbers = words.keySet();

		return phoneNumbers;

	}

	public static void main(String[] args) throws TwilioRestException, IOException {

		List<String> phoneNumbers = new ArrayList<String>();
		Set<String> result = readFromFile();

		phoneNumbers.add("360-553-2393"); // MOBILE
		phoneNumbers.add("408.441.8300"); // LANDLINE

		phoneNumbers.add("202-555-0142");
		phoneNumbers.add("202-555-0104");
		phoneNumbers.add("202-555-0197");
		phoneNumbers.add("202-555-0156");
		phoneNumbers.add("202-555-0117");
		phoneNumbers.add("202-555-0169");

		// Invalid phone numbers
		phoneNumbers.add("(123) 456 7890");
		phoneNumbers.add("555-541-1234");
		phoneNumbers.add("12-12-111");
		phoneNumbers.add("280 456 7890");

		List<String> phoneNumbers2 = new ArrayList<String>();
		phoneNumbers2.add("360-553-2393"); // MOBILE
		phoneNumbers2.add("408.441.8300"); // LANDLINE

		phoneNumbers2.add("202-555-0142");
		phoneNumbers2.add("202-555-0104");
		phoneNumbers2.add("202-555-0197");
		phoneNumbers2.add("202-555-0156");
		phoneNumbers2.add("202-555-0117");
		phoneNumbers2.add("202-555-0169");

		System.out.println("1st round Validated Cell Phone Numbers:");

		PhoneNumberValidator validator = new PhoneNumberValidator();

		Set<PhoneNumber> set = new HashSet<PhoneNumber>();

		long startTime = System.currentTimeMillis();
		set = validator.getValidaPhoneNumber(result);
		// for (PhoneNumber phoneNum : set) {
		// long nationalNumber = phoneNum.getNationalNumber();
		// System.out.println(nationalNumber + " " );
		// }
		System.out.printf("1st set = %d\n", set.size());

		long endTime = System.currentTimeMillis();

		System.out.println("Run time:  " + (endTime - startTime) + "ms");

		System.out.println("\n2nd round Validated Cell Phone Numbers:");

		startTime = System.currentTimeMillis();
		set = validator.getValidaPhoneNumber(result);
		System.out.printf("2nd set = %d\n", set.size());
		endTime = System.currentTimeMillis();
		System.out.println("Run time:  " + (endTime - startTime) + "ms");

		System.out.println("\n3rd round Validated Cell Phone Numbers:");
		startTime = System.currentTimeMillis();
		set = validator.getValidaPhoneNumber(result);
		System.out.printf("3rd set = %d\n", set.size());

		endTime = System.currentTimeMillis();
		System.out.println("Run time:  " + (endTime - startTime) + "ms");

	}

	private static void write2file() throws IOException {
		final Path inputPath = Paths.get("src/main/resources/validednum.txt");
		try (PrintWriter w = new PrintWriter(Files.newBufferedWriter(inputPath))) {
			for (int i = 0; i < 600; i++) {
				final String text = String.valueOf(System.nanoTime());
				for (int j = 0; j < 15; j++)
					w.print(text);
				w.println();
			}
		}

	}
}
