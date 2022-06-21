package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] products = new Product[0];

    public void addProduct(Product product) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        int newProduct = tmp.length - 1;
        tmp[newProduct] = product;
        products = tmp;
    }

    public Product[] findAllProduct() {
        return products;
    }

    public void removeById(int id) {
        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int copy = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copy] = product;
                copy++;
            }
        }
        products = tmp;
    }
}