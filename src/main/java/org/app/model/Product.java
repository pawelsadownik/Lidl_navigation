
package org.app.model;


import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;

@Entity
@Table(name = "Product")
@Document(indexName = "products", type = "products", shards = 1)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String description;
    private double x;
    private double y;

    public Product() {
    }

    public Product(String description, double x, double y) {
        this.description = description;
        this.x = x;
        this.y = y;
    }

    public Product(Long id, String description, double x, double y) {
        this.id = id;
        this.description = description;
        this.x = x;
        this.y = y;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public double getY() {
        return this.y;
    }

    public double getX() {
        return this.x;
    }

    public double measureDistance(Product product) {

        double distance = Math.sqrt(Math.pow(product.getX() - this.getX(), 2) + Math.pow(product.getY() - this.getY(), 2));

        return distance;
    }

    public String toString() {
        return this.description;
    }
}
