package ru.test.products.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.test.products.model.Product;
import ru.test.products.repository.ProductRepository;
import ru.test.products.service.ProductService;

import java.math.BigInteger;

/**
 * Created by Администратор on 11.02.2017.
 */

@RestController
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);


    @Autowired
    private ProductService productService;

    @GetMapping(value = "/{name}/{price}")
    public Product get(@PathVariable("name") String name, @PathVariable("price") long price)
    {
        LOG.info("get product {}", name);
        return productService.get(name, price);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody Product product) {

        productService.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
