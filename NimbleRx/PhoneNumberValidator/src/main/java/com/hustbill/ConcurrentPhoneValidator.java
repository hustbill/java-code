package com.hustbill;


import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.groupingByConcurrent;
import static java.util.stream.StreamSupport.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by Hua Zhang on May 10, 2016.
 */
public class ConcurrentPhoneValidator {

    private static Path inputPath = Paths.get("src/main/resources/phone.txt");

    public ConcurrentPhoneValidator(String inputPath) {
        this.inputPath = Paths.get(inputPath);
    }

	public static void main(String[] args) throws IOException {
		ConcurrentPhoneValidator validator1 = new ConcurrentPhoneValidator("src/main/resources/phone.txt");

		testSequentially();
		testWithFixedBatchSpliterator();
		testParallel();
		
		
	

    }
	
    public static void testSequentially() throws IOException {
        System.out.println("testSequentially:");

        long start = System.currentTimeMillis();

        Stream<String> lines = Files.lines(inputPath);
        Map<Object, Long> words = lines
                .map((String line) -> line.split("\\n"))
                .flatMap(Arrays::stream)
                .map(String::toLowerCase)
                .collect(groupingBy(s -> s, counting()));
        lines.close();

        System.out.println("Execution time: " + (System.currentTimeMillis() - start) + " ms");

        System.out.println("Words: " + words.keySet().size());
        System.out.println();
    }


    public static void testParallel() throws IOException {
        System.out.println("testParallel:");

        long start = System.currentTimeMillis();

        Stream<String> lines = Files.lines(inputPath);
        Map<String, Long> words = lines.parallel()
                .map(line -> line.split("\\n"))
                .flatMap(Arrays::stream)
                .map(String::toLowerCase)
                .collect(groupingByConcurrent(s -> s, counting()));
        lines.close();

        
        System.out.println("Execution time: "
                + (System.currentTimeMillis() - start) + " ms");

        System.out.println("Words: " + words.keySet().size());
        System.out.println();
    }


    public static void testWithFixedBatchSpliterator() throws IOException {
        System.out.println("testWithFixedBatchSpliterator:");

        long start = System.currentTimeMillis();

        Stream<String> lines = withBatchSize(Files.lines(inputPath), 10);

        Map<Object, Long> words = lines.parallel()
                .map(line -> line.split("\\n"))
                .flatMap(Arrays::stream)
                .map(String::toLowerCase)
                .collect(groupingByConcurrent(s -> s, counting()));
        lines.close();

        System.out.println("Execution time: "
                + (System.currentTimeMillis() - start) + " ms");

        System.out.println("Words: " + words.keySet().size());
        System.out.println();
    }


	public static <T> Stream<T> withBatchSize(Stream<T> in, int batchSize) {
		return stream(new FixedBatchSpliterator<>(in.spliterator(), batchSize), true);
	}

}