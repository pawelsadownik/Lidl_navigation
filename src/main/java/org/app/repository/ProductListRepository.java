package org.app.repository;

import org.app.model.Product;
import org.app.model.ProductList;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface ProductListRepository extends Repository<Product, Long> {

    List<Product> findAll();
    ProductList save(ProductList productList);
}