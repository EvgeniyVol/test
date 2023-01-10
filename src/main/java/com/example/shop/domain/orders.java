package com.example.shop.domain;

import javax.persistence.*;

//@Entity
public class orders {
    /*@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;*/

    /*
    *
    * package com.example.shop.domain;

import javax.persistence.*;


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
    @JoinColumn(name = "id_Categories")
    private categories id_Categories;

    public products() {
    }

    public products(String product_name, Integer product_price, manufacturers id_Manufacturers, categories id_Categories) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.id_Manufacturers = id_Manufacturers;
        this.id_Categories = id_Categories;
    }

    public String getCategoriesName(){
        return id_Categories != null ? id_Categories.getCategory_name() : "h";
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

    public categories getId_Categories() {
        return id_Categories;
    }

    public void setId_Categories(categories id_Categories) {
        this.id_Categories = id_Categories;
    }


}

    * */
}
