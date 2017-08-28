package edu.project.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Marango on 17/02/2017.
 * Mock product list for testing
 */
@Entity
public class Product extends AbstractDomainClass {

    private String description;
    private BigDecimal price;
    private String imageUrl;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
