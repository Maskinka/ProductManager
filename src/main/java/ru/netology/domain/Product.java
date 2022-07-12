package ru.netology.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {
    protected int id;
    protected String name;
    protected int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public boolean matches(String search) {
        if (this.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}