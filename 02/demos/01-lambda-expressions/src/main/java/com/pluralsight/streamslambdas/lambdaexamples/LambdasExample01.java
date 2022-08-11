
package com.pluralsight.streamslambdas.lambdaexamples;

import com.pluralsight.streamslambdas.ExampleData;
import com.pluralsight.streamslambdas.Product;

import java.util.Comparator;
import java.util.List;

public class LambdasExample01 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        // Interface Comparator implemented with an anonymous class.

        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getPrice().compareTo(p2.getPrice());
            }
        });
        // Interface Comparator implemented with a lambda expression.


        products.sort((person1 , person2)-> person1.getPrice().compareTo(person2.getPrice()));

        // The same with a more verbose syntax:
        // - You can optionally specify the type of the parameters
        // - The body can be a block between { and } or a single expression


        for (Product product : products) {
            System.out.println(product);

        }
    }
}
