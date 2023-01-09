package com.example.shop.repos;



import com.example.shop.domain.manufacturers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ManufacturersRepo extends CrudRepository<manufacturers, Long> {
    @Query("select m from manufacturers m where m.manufacturer_name = ?1")
    List<manufacturers> findByManufacturer_name(String manufacturer_name);
}
