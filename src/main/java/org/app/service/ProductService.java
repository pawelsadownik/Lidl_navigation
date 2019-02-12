package org.app.service;

import org.app.model.Product;
import org.app.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class ProductService {

    public Logger logger = LoggerFactory.getLogger(ProductService.class);

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        Assert.notNull(productRepository, "Repository must not be null!");
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByDescription(String description) {
        return productRepository.findByDescription(description);
    }

    public Product getProductWithId(Long id) {

        return productRepository.findOne(id);
    }

    public Product create(Product product) throws IllegalArgumentException {
        if (product.getId() != null) {
            throw new IllegalArgumentException("id in Product must be null");
        }
        return productRepository.save(product);
    }
    public Product update(Product todo) {
        //logger.debug(todo.getId());

        if (productRepository.findOne(todo.getId()) == null) {
            return null;
        }
        return productRepository.save(todo);
    }

    public void delete(long id) {
        productRepository.delete(id);
    }
}

