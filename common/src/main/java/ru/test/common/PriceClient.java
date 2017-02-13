package ru.test.common;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;
import ru.test.price.model.Price;

/**
 * Created by Администратор on 12.02.2017.
 */
public interface PriceClient {
    @RequestLine("GET /{productId}")
    Long getAvgPrice(@Param("productId") Long productId);

    @RequestLine("PUT /")
    @Headers("Content-Type: application/json")
    void createPrice(Price price);
}
