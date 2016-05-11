package com.hustbill;

import static java.util.concurrent.TimeUnit.SECONDS;
import static java.util.stream.StreamSupport.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.twilio.sdk.LookupsClient;
import com.twilio.sdk.TwilioRestException;

public class ParallelPhoneValidator {
	static double sink;
	static Set<PhoneNumber> result = new HashSet<PhoneNumber>();

	private final Path inputPath;

	// Find your Account Sid and Token at twilio.com/user/account
	public static final String ACCOUNT_SID = "AC180c23689eab0b992235e6d14a1efd91";
	public static final String AUTH_TOKEN = "7b290425b3a0d209bcbd74be314574ea";

	public ParallelPhoneValidator(String inputPath) {
		// TODO Auto-generated constructor stub
		this.inputPath = Paths.get(inputPath);
	}

	public static void main(String[] args) throws IOException {
		// final Path inputPath = Paths.get("src/main/resources/phone.txt");
		final Path inputPath = Paths.get("src/main/resources/small.txt");
		for (int i = 1; i < 3; i++) {
			System.out.printf("Start Sequentially processing %d round stream \n", i);
			measureProcessing(Files.lines(inputPath));
			
			System.out.printf("Start Parallel processing %d round stream \n", i);
			measureProcessing(withBatchSize(Files.lines(inputPath), 10));
		 }

		System.out.println("Validated Cell Numbers");
		for (PhoneNumber phoneNum : result) {
			long nationalNumber = phoneNum.getNationalNumber();
			System.out.println("   " + nationalNumber );
		}
	}

	private static void measureProcessing(Stream<String> input) throws IOException {
		final long start = System.nanoTime();

		try (Stream<String> lines = input) {
			final long totalTime = lines.parallel().mapToLong(ParallelPhoneValidator::processLine).sum();

			final double cpuTime = totalTime, realTime = System.nanoTime() - start;
			final int cores = Runtime.getRuntime().availableProcessors();
			System.out.println(" Cell Phone Num: " + result.size());
			System.out.println("          Cores: " + cores);
			System.out.format("       CPU time: %.2f s\n", cpuTime / SECONDS.toNanos(1));
			System.out.format("      Real time: %.2f s\n", realTime / SECONDS.toNanos(1));
			System.out.format("CPU utilization: %.2f%%\n\n", 100.0 * cpuTime / realTime / cores);

		}
	}

	/*
	 * Determine if the phone number is a valid phone number using Google's
	 * libphonenumber
	 * 
	 * Google's common Java, C++ and JavaScript library for parsing, formatting,
	 * and validating international phone numbers.
	 */
	private static long processLine(String usaNumberStr) {
		final long localStart = System.nanoTime();

		PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
		LRUCache cache = new LRUCache(1000);

		try {
			PhoneNumber usaNumberProto = phoneUtil.parse(usaNumberStr, "US");
			boolean isValid = phoneUtil.isValidNumber(usaNumberProto);

			if (isValid) {
				long key = usaNumberProto.getNationalNumber();
				if (cache.get(key) != -1) {
					if (cache.get(key) == 1) { // 1 - MOBILE
						result.add(usaNumberProto);
					}
				} else {
					if (twilioLookup(usaNumberProto) == "MOBILE") {
						result.add(usaNumberProto);
						cache.set(key, 1);
					} else {
						cache.set(key, 0); // 0 - LANDLINE
					}
				}
			}
		} catch (Exception e) {
			System.err.println("NumberParseException was thrown: " + e.toString());
		}

		return System.nanoTime() - localStart;
	}

	public static <T> Stream<T> withBatchSize(Stream<T> in, int batchSize) {
		return stream(new FixedBatchSpliterator<>(in.spliterator(), batchSize), true);
	}

	/*
	 * Get the type of a phone : Landline or Mobile by Twilio Lookup API.
	 * 
	 * Twilio Lookup is a simple REST API with a ton of utility. Twilio
	 * https://www.twilio.com/lookup determine whether a phone is a landline or
	 * can receive text messages, and even discover information about the
	 * carrier associated with that phone number.
	 */
	public static String twilioLookup(PhoneNumber number) throws TwilioRestException {
		String strNum = String.valueOf(number.getNationalNumber());

		LookupsClient client = new LookupsClient(ACCOUNT_SID, AUTH_TOKEN);
		com.twilio.sdk.resource.instance.lookups.PhoneNumber phoneNumber = client.getPhoneNumber(strNum, true);

		return phoneNumber.getType().toString();
	}

}