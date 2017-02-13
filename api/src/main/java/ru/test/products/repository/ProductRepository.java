package ru.test.products.repository;

import ru.test.products.model.Product;

import java.util.Collection;

/**
 * Created by Администратор on 11.02.2017.
 */
public interface ProductRepository {
    Product save(Product product);
    Product get(String name);
}
