package com.pluralsight.streamslambdas.streamexamples;

import com.pluralsight.streamslambdas.ExampleData;
import com.pluralsight.streamslambdas.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BasicStreamsExample02 {
    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        // get stream
        // call stream() on the collection
        Stream<Product> stream1 = products.stream();
        // from tne Array
        String[] array = new String[]{"ane", "two", "three"};
        Stream<String> strim2 = Arrays.stream(array);

        // if array have small fixed of elements cen using of()
        Stream<String> strim3 = Stream.of("ane", "two", "three");

        // ofNullable() returns an empty stream if the argument if is null or a single element of stream
        Stream<String> strim4 = Stream.of("three");


        // Create an empty Stream with Stream.empty()
        Stream<?> stream5 = Stream.empty();

        // Returns an infinite stream of random numbers between 1 (inclusive) and 7 (exclusive)
        IntStream dice = new Random().ints(1, 7);


        // There are more methods in the Java standard library that create streams, for example BufferedReader.lines()
        try (BufferedReader in = new BufferedReader(new FileReader("README.md", StandardCharsets.UTF_8))) {
            in.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
