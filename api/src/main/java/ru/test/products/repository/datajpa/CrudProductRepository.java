package ru.test.products.repository.datajpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.test.products.model.Product;

import java.util.Optional;

/**
 * Created by Администратор on 11.02.2017.
 */

@Transactional(readOnly = true)
public interface CrudProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);
}

