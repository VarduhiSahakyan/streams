package com.pluralsight.streamslambdas.streamexamples;

import com.pluralsight.streamslambdas.Category;
import com.pluralsight.streamslambdas.ExampleData;
import com.pluralsight.streamslambdas.Product;


import java.util.List;
import java.util.stream.Collectors;


public class BasicStreamsExample05 {
    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        // create new list from food names
        List<String> foodProductNames =
        products.stream()
                .filter(product -> product.getCategory() == Category.FOOD)
                .map(Product::getName)
                .collect(Collectors.toList());
        System.out.println(foodProductNames);

        //single string from names
        String categories = products.stream()
                .map(Product::getCategory)
                .distinct()
                .map(Category::name)
                .collect(Collectors.joining("; "));
        System.out.println(categories);
    }
}
