package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {

    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void save(Product product) {
        repository.save(product);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Product[] searchById(String text) {
        Product[] results = new Product[0];
        for (Product product : repository.findAll()) {
           if (matches(product, text)) {
               Product[] tmp = new Product[results.length + 1];
               int i = 0;
               for(Product result : results) {
                   tmp[i] = result;
                   i++;
               }
               tmp[results.length] = product;
               results = tmp;

           }
        }
        return results;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
