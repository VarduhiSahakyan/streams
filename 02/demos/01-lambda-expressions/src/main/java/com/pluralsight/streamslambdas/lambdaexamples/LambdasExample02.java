
package com.pluralsight.streamslambdas.lambdaexamples;

import com.pluralsight.streamslambdas.ExampleData;
import com.pluralsight.streamslambdas.Product;

import java.util.List;

public class LambdasExample02 {

    // Print the products that cost less than the price limit.
    // without filter interface (bed practice)
    static void printProducts(List<Product> products, Double priceLimit) {
        for (Product product : products) {
            if (product.getPrice().compareTo(priceLimit) < 0) {
                System.out.println(product);
            }
        }
    }

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        Double priceLimit = 5.00;

        printProducts(products, priceLimit);
    }
}
