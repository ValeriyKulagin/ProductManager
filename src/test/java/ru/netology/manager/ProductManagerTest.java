package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Product book = new Book(12, "Chair", 120, "Unknown Author");
    Product smartphone = new Smartphone(254, "Iphone 14 Pro", 950, "Apple");
    Product product = new Product(25, "Chair", 25);

    @Test
    public void shouldAddItem() {
        manager.save(book);
        Product[] expected = {book};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddAll() {
        manager.save(book);
        manager.save(smartphone);
        manager.save(product);
        Product[] expected = {book, smartphone, product};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByText() {
        manager.save(book);
        manager.save(smartphone);
        manager.save(product);
        String name = "Iphone 14 Pro";
        Product[] expected = {smartphone};
        Product[] actual = manager.searchById(name);
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchWhenSeveralProductsSuit() {
        manager.save(book);
        manager.save(smartphone);
        manager.save(product);
        String name = "Chair";
        Product[] expected = {book, product};
        Product[] actual = manager.searchById(name);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWhenProductsNotSuit() {
        manager.save(book);
        manager.save(smartphone);
        manager.save(product);
        String name = "Haier";
        Product[] expected = {};
        Product[] actual = manager.searchById(name);
        Assertions.assertArrayEquals(expected, actual);
    }


}
