package org.app.route;

import org.app.model.Product;

import java.util.ArrayList;

public class NearestNeighbor {
	public Route findShortestRoute(ArrayList<Product> products) {

		ArrayList<Product> shortestRouteProducts = new ArrayList<Product>(products.size());

		Product product = products.get(0);
		updateRoutes(shortestRouteProducts, products, product);
		while (products.size() >= 1) {
			product = getNextProduct(products, product);
			updateRoutes(shortestRouteProducts, products, product);
		}
		return new Route(shortestRouteProducts);
	}
	private void updateRoutes(ArrayList<Product> shortestRouteProducts, ArrayList<Product> products, Product product) {
		shortestRouteProducts.add(product);
		products.remove(product);

	}
	private Product getNextProduct(ArrayList<Product> products, Product product) {
		return products.stream().min((product1, product2) -> {
			int flag = 0;
			if (product1.measureDistance(product) < product2.measureDistance(product)) flag = -1;
			else if (product1.measureDistance(product) > product2.measureDistance(product)) flag = 1;
			return flag;
		}).get();
	}
}
