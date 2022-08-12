package com.pluralsight.streamslambdas.streamleveltowexamples;


import java.math.BigInteger;
import java.util.UUID;
import java.util.stream.Stream;

public class AdvancedStreamExample01 {
    public static void main(String[] args) {

        // generates infinite stream of elements produced by a supplier
        Stream<UUID> uuids = Stream.generate(UUID::randomUUID);
        // limited stream print 10 of them
        uuids.limit(10).forEach(System.out::println);

        //1st iterator version
        Stream<BigInteger> powersOfTow = Stream.iterate(BigInteger.ONE, n -> n.multiply(BigInteger.TWO));
        powersOfTow.limit(20).forEach(System.out::println);
        //2t version of iterator
        Stream<Character> alphabet = Stream.iterate('A', letter -> letter <= 'Z', letter -> (char) (letter + 1));
        alphabet.forEach(System.out::println);

        //building string from
        Stream.Builder<String> builder = Stream.builder();
        builder.add("one");
        builder.add("two");
        builder.add("three");
        Stream<String> stringStream = builder.build();
        stringStream.forEach(System.out::println);



    }
}
