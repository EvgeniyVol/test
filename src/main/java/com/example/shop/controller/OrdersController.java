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

import java.util.List;
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
                         @RequestParam(required = false, defaultValue = "0") Integer mode,
                         @RequestParam(required = false, defaultValue = "") Integer id,
                         Model model){

        switch (mode){
            case 1: {
                orders orders = ordersRepo.findById(id);
                ordersRepo.delete(orders);
                break;
            }
            case 2:{
                orders orders = ordersRepo.findById(id);
                orders.setProduct_count(orders.getProduct_count()+1);
                ordersRepo.save(orders);
                break;
            }
            case 3:{
                orders orders = ordersRepo.findById(id);
                orders.setProduct_count(orders.getProduct_count()-1);
                ordersRepo.save(orders);
                break;
            }
            case 4:{
                orders orders = ordersRepo.findById(id);
                ordersRepo.delete(orders);
                break;
            }
            case 0:{
                break;
            }
            default:{
                Iterable<orders> order = ordersRepo.findById_User(user);
                model.addAttribute("orders", order);
                model.addAttribute("User", user.getUsername());
                return "orders";

            }
        }
        Iterable<orders> order = ordersRepo.findById_User(user);
        model.addAttribute("orders", order);
        model.addAttribute("User", user.getUsername());
        return "orders";
    }


}
