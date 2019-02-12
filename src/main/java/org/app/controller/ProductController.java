package org.app.controller;

import org.app.elastic.SearchQueryBuilder;
import org.app.model.Product;
import org.app.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@EnableAsync
public class ProductController {

    private ProductService productService;
    public Logger logger = LoggerFactory.getLogger(ProductService.class);

    private boolean testFlag;

    @Autowired
    private SearchQueryBuilder searchQueryBuilder;

    
    @Autowired
    public ProductController(ProductService productService) {
        Assert.notNull(productService, "Service must not be null!");
        this.productService = productService;
    }


    @PutMapping(value = "/products/{id}")
    ResponseEntity<Product> updateProduct(@RequestBody Product product) {

        logger.debug(product.getDescription());
        if (product.getId() == null) {
            return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Product updatedItem = productService.update(product);

        if (updatedItem == null) {
            return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Product>(updatedItem, HttpStatus.OK);
    }

    @PostMapping(value = "/productsList")
    public void createProduct(@RequestBody List<Product> productList) {

        for (int i=0; i<productList.size(); i++) {
            productService.create(productList.get(i));
        }
    }

    @PostMapping(value = "/products")
    ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.create(product), HttpStatus.CREATED);

    }

    @DeleteMapping(value = "/products/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") long id) {
        if (testFlag) {
            productService.delete(id);
        }

        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/products")
    public List<Product> getProductsBySequence(@RequestParam(name = "text") Optional<String> text) {
        try {
            if (text.isPresent() == false) {
                return productService.getAllProducts();
            } else {

            }
            return searchQueryBuilder.getAll(text.get());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }



}
