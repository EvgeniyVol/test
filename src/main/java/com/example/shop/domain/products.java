package com.example.shop.domain;

import javax.persistence.*;

@Entity
public class products {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String product_name;
    private Integer product_price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Manufacturers")
    private manufacturers id_Manufacturers;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Сategories")
    private categories id_Сategories;

    public products() {
    }

    public products(String product_name, Integer product_price, manufacturers id_Manufacturers, categories id_Сategories) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.id_Manufacturers = id_Manufacturers;
        this.id_Сategories = id_Сategories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Integer getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Integer product_price) {
        this.product_price = product_price;
    }

    public manufacturers getId_Manufacturers() {
        return id_Manufacturers;
    }

    public void setId_Manufacturers(manufacturers id_Manufacturers) {
        this.id_Manufacturers = id_Manufacturers;
    }

    public categories getId_Сategories() {
        return id_Сategories;
    }

    public void setId_Сategories(categories id_Сategories) {
        this.id_Сategories = id_Сategories;
    }


}
/*
*
*
    private String text;
    private String tag;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Message() {
    }

    public Message(String text, String tag, User user) {
        this.author = user;
        this.text = text;
        this.tag = tag;
    }
public String getAuthorName(){
        return author != null ? author.getUsername() : "<none>";
}
    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}

* */