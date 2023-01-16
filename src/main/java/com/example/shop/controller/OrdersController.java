package com.example.shop.controller;

import com.example.shop.domain.User;
import com.example.shop.domain.orders;
import com.example.shop.domain.products;
import com.example.shop.repos.CategoRepo;
import com.example.shop.repos.ProductsRepo;
import com.example.shop.repos.ordersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping(path="/orders")
public class OrdersController {


    @Autowired
    private ProductsRepo productsRepo;


    @Autowired
    private CategoRepo categoRepo;


    @Autowired
    private com.example.shop.repos.ordersRepo ordersRepo;



    @GetMapping
    public String addBox(@AuthenticationPrincipal User user,
                         Model model){


        Iterable<orders> orders = ordersRepo.findById_User(user);
        model.addAttribute("orders", orders);

        return "orders";
    }



}
