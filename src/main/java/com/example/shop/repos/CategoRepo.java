package com.example.shop.repos;


import com.example.shop.domain.categories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoRepo extends CrudRepository<categories, Long> {

    @Query("select c from categories c where c.category_name = ?1")
    List<categories> findByCategory_name(String category_name);

}
