package ru.netology.ru.netology.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    Product book1 = new Book(1, "Hellon", 10, "Joy");
    Product smartphone1 = new Smartphone(2, "Iphone", 100, "USA");

    @Test
    public void shouldFindNameElement() {
        manager.add(book1);
        manager.add(smartphone1);

        Product[] actual = manager.searchBy("Hello");
        Product[] expected = {book1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindPartName() {
        manager.add(book1);
        manager.add(smartphone1);

        Product[] actual = manager.searchBy("one");
        Product[] expected = {smartphone1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNotElement() {
        manager.add(book1);
        manager.add(smartphone1);

        Product[] actual = manager.searchBy("yes");
        Product[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNot() {
        manager.add(book1);
        manager.add(smartphone1);

        Product[] actual = manager.searchBy("on");
        Product[] expected = {book1, smartphone1};
        assertArrayEquals(expected, actual);
    }
}
