package com.hustbill;


import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.groupingByConcurrent;
import static java.util.stream.StreamSupport.stream;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

//import static ua.kpi.burdun.diploma.fixedbatchspliterator.FixedBatchSpliterator.withBatchSize;

/**
 * Created by burdun on 28.05.2015.
 */
public class WordCountBenchmark {

    private final Path inputPath;

    public WordCountBenchmark(String inputPath) {
        this.inputPath = Paths.get(inputPath);
    }


    public void testSequentially() throws IOException {
        System.out.println("testSequentially:");

        long start = System.currentTimeMillis();

        Stream<String> lines = Files.lines(inputPath);
        Map<Object, Long> words = lines
                .map((String line) -> line.split("\\n"))
                .flatMap(Arrays::stream)
                .map(String::toLowerCase)
                .collect(groupingBy(s -> s, counting()));
        lines.close();

        System.out.println("Execution time: " + (System.currentTimeMillis() - start));

        System.out.println("Words: " + words);
        System.out.println();
    }


    public void countTheNumberOfWords() throws IOException {
        System.out.println("countTheNumberOfWords:");

        long start = System.currentTimeMillis();

        Stream<String> lines = Files.lines(inputPath);
        Map<Object, Long> words = lines
                .map((String line) -> line.split("\\n"))
                .flatMap(Arrays::stream)
                .map(String::toLowerCase)
                .collect(groupingBy(s -> s, counting()));
        lines.close();

        /*Stream<String>*/ lines = Files.lines(inputPath);
        Long numberOfWords = lines
                .map((String line) -> line.split("\\n"))
                .count();
        lines.close();

        System.out.println("Execution time: " + (System.currentTimeMillis() - start));

        System.out.println("Words: " + words);
        System.out.println("Number of words: " + numberOfWords);
        System.out.println();
    }


    public void testParallel() throws IOException {
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
                + (System.currentTimeMillis() - start));

        System.out.println("Words: " + words);
        System.out.println();
    }


    public void testWithFixedBatchSpliterator() throws IOException {
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
                + (System.currentTimeMillis() - start));

        //System.out.println("Words: " + words);
        System.out.println();
    }


	public static <T> Stream<T> withBatchSize(Stream<T> in, int batchSize) {
		return stream(new FixedBatchSpliterator<>(in.spliterator(), batchSize), true);
	}





	public static void main(String[] args) throws IOException {
        WordCountBenchmark wordCountBenchmark = new WordCountBenchmark("src/main/resources/phone.txt");
        wordCountBenchmark.testSequentially();
//        wordCountBenchmark.countTheNumberOfWords();
        wordCountBenchmark.testParallel();
//        wordCountBenchmark.testWithFixedBatchSpliterator();
    }
}