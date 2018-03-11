package com.adaptive.ui.beans;

import com.adaptive.ui.entity.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {

    @PostConstruct
    public void init() {
        orderedProducts = new ArrayList<>();
    }

    private List<Product> orderedProducts = new ArrayList<>();

    public Cart() {
        this.orderedProducts = new ArrayList<>();
    }

    public List<Product> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(List<Product> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    public void addProduct(final Product productToAdd) {
        if(orderedProducts == null) {
            orderedProducts = new ArrayList<>();
        }
        Product product;
        if(orderedProducts.contains(productToAdd)) {
            product = orderedProducts.stream().filter(p -> p.equals(productToAdd)).findAny().get();

        } else {
            product = productToAdd;
            orderedProducts.add(productToAdd);
        }
        product.setCount(product.getCount() + 1);
    }

    public double getTotalPrice() {
        return orderedProducts.stream()
                .map(product -> (Double.valueOf(product.getPrice()) * product.getCount()))
                .reduce(0.0, (a, b) -> a + b);
    }

    public Product getProductById(String productId) {
        return orderedProducts.stream()
                .filter(p -> p.getId().equals(productId))
                .findAny().get();

    }

    public void incrementQuantity(String productId) {
        Product product = getProductById(productId);
        product.setCount(product.getCount() + 1);
    }

    public void decrementQuantity(String productId) {
        Product product = getProductById(productId);
        if(product.getCount() > 1) {
            product.setCount(product.getCount() - 1);
        }
    }

    public void setQuantity(String productId, int value) {
        Product product = getProductById(productId);
        if(value > 0) {
            product.setCount(value);
        }
    }

    public void removeFromCart(String productId) {
        Product product = getProductById(productId);
        orderedProducts.remove(product);
    }
}
