package ru.netology.ru.netology.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.NotFoundException;
import ru.netology.repository.ProductRepository;

public class RepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    Product book1 = new Book(1, "Hello", 10, "Joy");
    Product smartphone1 = new Smartphone(2, "Iphone", 100, "USA");

    @Test
    public void removeById() {
        repository.addProduct(book1);
        repository.addProduct(smartphone1);
        repository.removeById(2);

        Product[] actual = repository.findAllProduct();
        Product[] expected = {book1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByNotId() {
        repository.addProduct(book1);
        repository.addProduct(smartphone1);

        Product[] actual = repository.findAllProduct();
        Product[] expected = {book1, smartphone1};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void notFoundException() {
        repository.addProduct(book1);
        repository.addProduct(smartphone1);

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(-2);
        });
    }
}
