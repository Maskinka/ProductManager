package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.addProduct(product);
    }

    public boolean matches(Product product, String search) {
        if (product.matches(search)) {
            return true;
        } else {
            return false;
        }
    }
    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAllProduct()) {
            if (matches(product, text)) {
                int length = result.length + 1;
                Product[] tmp = new Product[length];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                int newProduct = tmp.length - 1;
                tmp[newProduct] = product;
                result = tmp;
            }
        }
        return result;
    }
}