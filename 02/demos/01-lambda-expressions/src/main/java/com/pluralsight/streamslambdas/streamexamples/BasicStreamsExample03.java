package com.pluralsight.streamslambdas.streamexamples;

import com.pluralsight.streamslambdas.Category;
import com.pluralsight.streamslambdas.ExampleData;
import com.pluralsight.streamslambdas.Product;

import java.util.List;
import java.util.regex.Pattern;


public class BasicStreamsExample03 {
    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        //transform products by category
        products.stream()
                // takes predicate to decode which element should be passed to the output stream (intermediate operation(returns stream object (IO)))
                .filter(product -> product.getCategory() == Category.FOOD)
                // terminal operation forEach() (returns not stream object(TO)) to make stream do the work !
                .forEach(System.out::println);


        //transform products by name and price
        products.stream()
                // takes a function and transforms each element in the stream by calling that function on it.(IO)
                //one-to-one transformation
                .map(product -> String.format("The price of %s is $ %.2f", product.getName(), product.getPrice()))
                //(TO)
                .forEach(System.out::println);

        //transform products by multipart name split on a parts
        Pattern spaces = Pattern.compile("\\s+");
        products.stream()
                // takes ane argument returns mor of one or 0 (one string by getName())(IO)
                //one-to-many transformation
                .flatMap(product -> spaces.splitAsStream(product.getName()))
                 // (TO)
                .forEach(System.out::println);


    }
}
