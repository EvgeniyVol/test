package com.example.shop.repos;

import com.example.shop.domain.User;
import com.example.shop.domain.orders;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ordersRepo extends CrudRepository<orders, Long> {


    @Query("select o from orders o where o.id_User = ?1")
    List<orders> findById_User(User Id_User);

}
