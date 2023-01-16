package com.example.shop.domain;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class orders {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private Integer product_count;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_User")
    private User id_User;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Products")
    private products id_Products;

    public orders() {
    }

    public orders(Integer product_count, User id_User, products id_Products) {
        this.product_count = product_count;
        this.id_User = id_User;
        this.id_Products = id_Products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProduct_count() {
        return product_count;
    }

    public void setProduct_count(Integer product_count) {
        this.product_count = product_count;
    }

    public User getId_User() {
        return id_User;
    }

    public void setId_User(User id_User) {
        this.id_User = id_User;
    }

    public products getId_Products() {
        return id_Products;
    }

    public void setId_Products(products id_Products) {
        this.id_Products = id_Products;
    }

}
