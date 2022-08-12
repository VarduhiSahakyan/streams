package com.pluralsight.streamslambdas.streamexamples;

import com.pluralsight.streamslambdas.Category;
import com.pluralsight.streamslambdas.ExampleData;
import com.pluralsight.streamslambdas.Product;

import java.util.List;
import java.util.Optional;

public class BasicStreamsExample04 {
    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        // find first office product
        Optional<Product> opt =
        products.stream()
                .filter(product -> product.getCategory() == Category.OFFICE)
                //TO
                .findFirst();
        System.out.println(opt.toString());

        // If you only want to check if the stream contains an element that matches your search criteria,
        // then you can use anyMatch(), which will return a boolean result
        // Unlike findFirst() and findAny(), you don't have to filter first - anyMatch() takes a Predicate
        boolean foundOfficeProduct = products.stream()
                .anyMatch(product -> product.getCategory() == Category.OFFICE);
        System.out.println("Does the list contain at least one office product? " + foundOfficeProduct);

        // To check if all elements of the stream match specific criteria, use allMatch()
        Double priceLimit = 10.00;
        boolean allProductsAreCheap = products.stream()
                .allMatch(product -> product.getPrice().compareTo(priceLimit) < 0);
        System.out.println("Are all products cheap? " + allProductsAreCheap);

        // noneMatch() returns the opposite of anyMatch()
        boolean allProductsAreExpensive = products.stream()
                .noneMatch(product -> product.getPrice().compareTo(priceLimit) < 0);
        System.out.println("Are all products expensive? " + allProductsAreExpensive);
    }
}
