package ru.test.products.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Администратор on 11.02.2017.
 */

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Long price;

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getPrice() {

        return price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Product() {
    }

    public Product(Long id, String name, Long price) {

        this.id = id;
        this.price = price;
        this.name = name;
    }

    public Product(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
