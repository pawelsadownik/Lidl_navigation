package org.app.service;

import org.app.model.Product;
import org.app.model.ProductList;
import org.app.repository.ProductListRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductListService {

    private ProductListRepository productListRepository;

    ProductList productList = new ProductList();

    public void addProductsList(List<Product> productsList)
    {
        List<Product> shoppingList = new ArrayList<>(productsList);
        productList.setProductList(shoppingList);
    }

    public List<Product> getProductsList()
    {
        return productList.getProductList();
    }
}
