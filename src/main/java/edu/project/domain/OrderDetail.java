package edu.project.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Created by Marango on 19/03/2017.
 *
 *
 */
@Entity
public class OrderDetail extends AbstractDomainClass {

    @ManyToOne
    private ProductOrder productOrder;

    @OneToOne
    private Product product;

    private Integer quantity;

    public ProductOrder getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(ProductOrder productOrder) {
        this.productOrder = productOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
