package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    Product book = new Book(12, "War and Peace", 120, "Lev Tolstoy");
    Product smartphone = new Smartphone(254, "Iphone 14 Pro", 950, "Apple");
    Product product = new Product(25, "Bread", 25);

    @Test

    public void shouldSaveOneItem() {
        repository.save(book);
        Product[] expected = {book};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSaveAllItems() {
        repository.save(book);
        repository.save(smartphone);
        repository.save(product);
        Product[] expected = {book, smartphone, product};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repository.save(book);
        repository.save(smartphone);
        repository.save(product);
        repository.removeById(254);
        Product[] expected = {book, product};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAllById() {
        repository.save(book);
        repository.save(smartphone);
        repository.save(product);
        repository.removeById(12);
        repository.removeById(254);
        repository.removeById(25);
        Product[] expected = {};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }


}
