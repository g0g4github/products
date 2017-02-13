package ru.test.products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.test.products.model.Product;
import ru.test.products.repository.ProductRepository;

/**
 * Created by Администратор on 11.02.2017.
 */

public interface ProductService {
    Product get(String name, Long price);
    Product save(Product product);
}
