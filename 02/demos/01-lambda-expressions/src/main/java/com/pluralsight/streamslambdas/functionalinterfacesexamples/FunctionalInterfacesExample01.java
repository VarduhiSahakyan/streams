package com.pluralsight.streamslambdas.functionalinterfacesexamples;

import com.pluralsight.streamslambdas.ExampleData;
import com.pluralsight.streamslambdas.Product;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class FunctionalInterfacesExample01 {
    // method to find the product of list
    // Go through a list of products, and return the first product for which the predicate returns true.
    static Optional<Product> findProduct(List<Product> products , Predicate<Product> predicate){
        for (Product p : products) {
            if (predicate.test(p)){
                return Optional.of(p);
            }
        } return Optional.empty();
    }

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        String name = "Spaghetti";

        // A combination of functional interfaces implemented by lambda expressions and method references is used here:
        // - findProduct() takes a Predicate<Product> to find the product with the specified name
        // - map() takes a Function<Product, BigDecimal> to get the price of the product
        // - ifPresentOrElse() takes a Consumer<Product> and a Runnable and calls one of them, depending on whether
        //      the Optional contains a value or is empty

        findProduct(products, product -> product.getName().equals(name))
                .map(Product::getPrice)
        .ifPresentOrElse(
                // Consumer impl for value
                price -> System.out.printf("The price of %s is $ %.2f%n", name , price),
                // Runnable impl for empty
                () -> System.out.printf("%s is not available%n", name)
        );
    }

}
