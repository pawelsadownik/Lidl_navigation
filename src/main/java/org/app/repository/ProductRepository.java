package org.app.repository;

import org.app.model.Product;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface ProductRepository extends Repository<Product, Long> {
    Product findOne(Long id);
    List<Product> findAll();
    List<Product>findByDescription(String description);
    Product save(Product product);
    void delete(Long id);
}
