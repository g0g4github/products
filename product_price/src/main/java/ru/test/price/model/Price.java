package ru.test.price.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created by Администратор on 12.02.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {
    @Id
    String id;
    Long productId;
    Long price;

    public Price() {
    }

    public Price(Long productId, Long price) {
        this.productId = productId;
        this.price = price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getPrice() {

        return price;
    }

    public String getId() {
        return id;
    }

    public Price(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
