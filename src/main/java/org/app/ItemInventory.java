package org.app;

import org.app.model.Product;
import org.app.repository.ProductRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;


@Component
public class ItemInventory {

    private ProductRepository itemRepository;


    public ItemInventory(ProductRepository itemRepository) {
        Assert.notNull(itemRepository, "Repository must not be null!");
        this.itemRepository= itemRepository;

        for (Product product: itemRepository.findAll()) {
            System.out.println(product.getId()+":"+product.getDescription()+" "+ product.getX()+" "+product.getY());
        }
    }
}
