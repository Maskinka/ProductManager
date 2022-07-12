package ru.netology.ru.netology;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class RichTest {
        private ProductRepository repository = new ProductRepository();
        private ProductManager manager = new ProductManager(repository);
        Product book1 = new Book(1, "Cinderella", 1000, "Perro");
        Product book2 = new Book(2, "Cotoboy", 1500, "Anderson");
        Product smartphone1 = new Smartphone(3, "Iphone", 100, "Usa");
        Product smartphone2 = new Smartphone(4, "Samsung", 100, "China");

        @Test
        public void shouldFindAuthor() {
            manager.add(book1);
            manager.add(book2);
            Product[] actual = manager.searchBy("Perro");
            Product[] expected = {book1};
            assertArrayEquals(expected, actual);
        }
    @Test
    public void shouldFind2Author() {
        manager.add(book1);
        manager.add(book2);
        Product[] actual = manager.searchBy("er");
        Product[] expected = {book1,book2};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindProducer() {
        manager.add(smartphone1);
        manager.add(smartphone2);
        Product[] actual = manager.searchBy("Usa");
        Product[] expected = {smartphone1};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFind2Producer() {
        manager.add(smartphone1);
        manager.add(smartphone2);
        Product[] actual = manager.searchBy("a");
        Product[] expected = {smartphone1,smartphone2};
        assertArrayEquals(expected, actual);
    }
}
