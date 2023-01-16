package com.example.shop.controller;



import com.example.shop.domain.*;
import com.example.shop.repos.CategoRepo;
import com.example.shop.repos.ProductsRepo;
import com.example.shop.repos.UserRepo;
import com.example.shop.repos.ordersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path="/products")
public class ProductsController {


    @Autowired
    private ProductsRepo productsRepo;


    @Autowired
    private CategoRepo categoRepo;


    @Autowired
    private ordersRepo ordersRepo;
    @Autowired
    private UserRepo userRepo;
    @GetMapping
    public String categ(@AuthenticationPrincipal User user,
            @RequestParam(required = false, defaultValue = "0") String name,
                        @RequestParam(required = false, defaultValue = "0") String categorie,
                        Model model) {
        Iterable<products> products = productsRepo.findAll();
        List<categories> categories= categoRepo.findByCategory_name(categorie);

        if (!categorie.equals("0") && !categorie.isEmpty()&& !name.equals("0") && !name.isEmpty()) {
            //categories = categoRepo.findByCategory_name(categorie);
        } else if (!name.equals("0") && !name.isEmpty()) {
            products = productsRepo.findByProduct_name(name);
        } else if (!categorie.equals("0") && !categorie.isEmpty()) {
            categories = categoRepo.findByCategory_name(categorie);
            if (categories.size()!=0){
                products = productsRepo.findById_Categories(categories);
            }else {
                products = productsRepo.findByProduct_name(name);
                model.addAttribute("products", products);
                model.addAttribute("User", user.getUsername());
                return "p";
            }
        } else {
            Iterable<products> p = productsRepo.findAll();
            model.addAttribute("products", p);
            model.addAttribute("User", user.getUsername());
            return "p";
        }

        model.addAttribute("products", products);
        model.addAttribute("User", user.getUsername());
        return "p";
    }
    @PostMapping
    public String add(@AuthenticationPrincipal User user,
                      @RequestParam(required = true) Integer id,
                      Model model){
        products products = productsRepo.findById(id);
        orders orders = new orders(1,user,products);
        ordersRepo.save(orders);

        Iterable<products> p = productsRepo.findAll();
        model.addAttribute("products", p);
        model.addAttribute("User", user.getUsername());

        return "p";
    }
}
