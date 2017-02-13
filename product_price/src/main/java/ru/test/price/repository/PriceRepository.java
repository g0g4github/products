package ru.test.price.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ru.test.price.model.Price;

import java.util.List;

/**
 * Created by Администратор on 12.02.2017.
 */
public interface PriceRepository extends MongoRepository<Price, String> {

    public Price findByProductId(Long productId);
}
