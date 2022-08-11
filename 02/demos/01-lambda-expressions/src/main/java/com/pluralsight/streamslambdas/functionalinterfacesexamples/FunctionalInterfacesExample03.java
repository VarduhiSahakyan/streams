package com.pluralsight.streamslambdas.functionalinterfacesexamples;

import com.pluralsight.streamslambdas.ExampleData;
import com.pluralsight.streamslambdas.Product;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfacesExample03 {


    static Optional<Product> findProduct(List<Product> products, Predicate<Product> predicate) {
        for (Product p : products) {
            if (predicate.test(p)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        String name = "Spaghetti";

        Function<Product, Double> productToPrice = Product::getPrice;
        Function<Double, String> priceToMessage = price -> String.format("The price of %s is $ %.2f%n", name, price);
        // Compose a new function out of the two functions above by using andThen(...)
        Function<Product, String> productToMessage = productToPrice.andThen(priceToMessage);

        // Alternative: use compose(...), which is the same as andThen(...) except that the order of the functions is reversed
//        Function<Product, String> productToMessage = priceToMessage.compose(productToPrice);


        findProduct(products, product -> product.getName().equals(name))
                // replace 2 call by one by compose by use andThen()
//                .map(productToPrice)
//                .map(priceToMessage )
                .map(productToMessage)
                .ifPresentOrElse(
                      System.out::println,
                        () -> System.out.printf("%s is not available%n", name)
                );
    }
}
