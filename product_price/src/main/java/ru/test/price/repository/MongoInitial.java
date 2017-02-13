package ru.test.price.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.test.price.model.Price;

import java.util.ArrayList;

/**
 * Created by Администратор on 12.02.2017.
 */
@Component
public class MongoInitial implements CommandLineRunner {

    @Autowired
    private PriceRepository priceRepository;


    public void run(String... strings) throws Exception {

        priceRepository.deleteAll();

        ArrayList<Long> arrayList = new ArrayList<Long>();
        Price price = priceRepository.save(new Price(100L, 200L));
        System.out.println(priceRepository.findOne(price.getId()).getId());
        System.out.println(priceRepository.findOne(price.getId()).getProductId());
        System.out.println(priceRepository.findOne(price.getId()).getPrice());

    }
}
