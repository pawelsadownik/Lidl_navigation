package org.app.controller;

import org.app.model.Product;
import org.app.route.NearestNeighbor;
import org.app.service.ProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@EnableAsync
public class ProductListController {

    @Autowired
    ProductListService productListService;

    @PostMapping(value = "/products/shoppingList")
    public ResponseEntity<List<Product>> addProductsList(@RequestBody List<Product> productList) {

        ArrayList<Product> products = new ArrayList<Product>(Arrays.asList(new Product("Entrance", 0, 0)));

        products.addAll(productList);

        NearestNeighbor nearestNeighbor = new NearestNeighbor();
        List<Product> sortedList = new ArrayList<Product>(nearestNeighbor.findShortestRoute(products).getProducts());
        return new ResponseEntity<List<Product>>(sortedList, HttpStatus.OK);
    }

}


