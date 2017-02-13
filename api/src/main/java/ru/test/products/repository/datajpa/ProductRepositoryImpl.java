package ru.test.products.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.test.products.model.Product;
import ru.test.products.repository.ProductRepository;

/**
 * Created by Администратор on 11.02.2017.
 */

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private CrudProductRepository crudProductRepository;


    @Transactional
    public Product save(Product product) {
        return crudProductRepository.save(product);
    }

    public Product get(String name) {
        //Not null?
        Product product = crudProductRepository.findByName(name);
        return product;
    }
}
