package com.example.shop.repos;


import com.example.shop.domain.products;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//public interface ProductsRepo {
public interface ProductsRepo extends CrudRepository<products, Long> {

    @Query("select p from products p where p.product_name = ?1")
    List<products> findByProduct_name(String Product_name);

    @Query("select p from products p where p.id_Сategories = ?1")
    List<products> findById_Сategories(String Product_name);

}
