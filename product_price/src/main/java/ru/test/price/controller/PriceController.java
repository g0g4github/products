package ru.test.price.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.test.price.model.Price;
import ru.test.price.repository.PriceRepository;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

/**
 * Created by Администратор on 12.02.2017.
 */
@RestController
@RequestMapping(value = "/price", produces = MediaType.APPLICATION_JSON_VALUE)
public class PriceController {
    private static final Logger LOG = LoggerFactory.getLogger(PriceController.class);


    @Autowired
    private PriceRepository priceRepository;

    @GetMapping(value = "/{productId}")
    public Long getAvgPrice(@PathVariable("productId") Long productId) {
        LOG.info("get average productId {}", productId);

        //List<Price> price = priceRepository.findByProductId(productId);
        //Здесь находим среднее и возвращаем его

        Long price = 0L;

        return price;
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody Price price) {
        LOG.info("save product productId: {}, price: {}", price.getProductId(), price.getPrice());
        priceRepository.save(price);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
