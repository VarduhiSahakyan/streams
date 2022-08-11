package com.pluralsight.streamslambdas.functionalinterfacesexamples;

import com.pluralsight.streamslambdas.Category;
import com.pluralsight.streamslambdas.ExampleData;
import com.pluralsight.streamslambdas.Product;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class FunctionalInterfacesExample04 {
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

        Double priceLimit = 2.00;
        // Two simple predicates that can be combined using the functional composition methods in interface Predicate.
        // this predicate checks the product is food opr not
        Predicate<Product> isFood = product -> product.getCategory() == Category.FOOD;
        // this predicate checks is the prise of product less then the limit price
        Predicate<Product> isCheap = product -> product.getPrice().compareTo(priceLimit) < 0;

        findProduct(products, isFood.and(isCheap))
                .ifPresentOrElse(
                        product -> System.out.printf("The price of %s is $ %.2f%n", product.getName(), product.getPrice()),
                        () -> System.out.println("There is no cheap food product")
                );
    }

}
