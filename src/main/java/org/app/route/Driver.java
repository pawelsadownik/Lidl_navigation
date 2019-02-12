package org.app.route;

import org.app.model.Product;

import java.util.ArrayList;
import java.util.Arrays;

public class Driver {
    private ArrayList<Product> initialProducts = new ArrayList<Product>(Arrays.asList(
            new Product("Water",1,2),
            new Product("Milk",1,6),
            new Product("Coffee",4,3)
            ));


    public static void main(String[] args) {
        Driver driver = new Driver();
        ArrayList<Product> products = new ArrayList<Product>();
        products.addAll(driver.initialProducts);
        driver.printShortestRoute(new NearestNeighbor().findShortestRoute(products));
    }

    private void printShortestRoute(Route shortestRoute) {

        System.out.println("Shortest route found so far: " + shortestRoute);
        System.out.println("w/ total distance: " + shortestRoute.calculateTotalDistance());
    }
}
