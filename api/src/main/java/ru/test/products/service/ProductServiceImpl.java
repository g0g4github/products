package ru.test.products.service;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.test.common.PriceClient;
import ru.test.price.model.Price;
import ru.test.products.model.Product;
import ru.test.products.repository.ProductRepository;

/**
 * Created by Администратор on 11.02.2017.
 */
@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

    String url = "http://localhost:8080/price";

    @Autowired
    private ProductRepository repository;

    PriceClient priceClient = Feign.builder()
            .encoder(new GsonEncoder())
            .decoder(new GsonDecoder())
            .requestInterceptor(template -> System.out.println(template))
            .target(PriceClient.class, url);

    public Product get(String name, Long price) {
        Product product = repository.get(name);
        //If we didn't find the product we save it
        if(product == null){
            Product tempProduct = repository.save(new Product(name, price));
            LOG.info("save product productName: {}, productPrice: {}, productId {}", tempProduct.getName(),
                    tempProduct.getPrice(), tempProduct.getId());


            // and send save request to price service
            LOG.info("create product in price service productName: {}, productPrice: {}, productId {}", tempProduct.getName(),
                    tempProduct.getPrice(), tempProduct.getId());
            priceClient.createPrice(new Price(tempProduct.getId(),tempProduct.getPrice()));
        }else {
            //We've found it and we ask about price
            //Type conversion
            Long avgPrice = priceClient.getAvgPrice(product.getId());
            //need create var in application.yml
            if(avgPrice < (0.3*avgPrice) && (avgPrice > 1.7*avgPrice)){
                priceClient.createPrice(new Price(product.getId(),product.getPrice()));
            }else {
                //status error return
            }
        }
        return product;
    }

    public Product save(Product product) {
        return repository.save(product);
    }
}
