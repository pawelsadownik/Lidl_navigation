package org.app.route;


import org.app.model.Product;

import java.util.ArrayList;
import java.util.Arrays;

public class Route {

	private ArrayList<Product> products = new ArrayList<Product>();

	public Route(ArrayList<Product> products) { this.products.addAll(products); }

    public ArrayList<Product> getProducts() { return products; }

    public int calculateTotalDistance() {
		int productsSize = this.getProducts().size();
		return (int) (this.getProducts().stream().mapToDouble(x -> {
			int productIndex = this.getProducts().indexOf(x);
			double returnValue = 0;
			if (productIndex < productsSize - 1) returnValue = x.measureDistance(this.getProducts().get(productIndex + 1));
			return returnValue;
		}).sum() + this.getProducts().get(productsSize - 1).measureDistance(this.getProducts().get(0)));
	}
    public String toString() { return Arrays.toString(products.toArray()); }
}
