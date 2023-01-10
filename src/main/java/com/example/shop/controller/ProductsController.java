package com.example.shop.controller;



import com.example.shop.domain.products;
import com.example.shop.repos.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping(path="/p")
public class ProductsController {


    @Autowired
    private ProductsRepo productsRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model
    ) {
        return "greeting";
    }

    @GetMapping("/all")
    public String main(@RequestParam(required = false, defaultValue = "") String name,
                       Model model) {
        Iterable<products> products = productsRepo.findAll();

        if (name != null && !name.isEmpty()) {
            products = productsRepo.findByProduct_name(name);
        } else {
            products = productsRepo.findAll();
        }
        model.addAttribute("products", products);
        model.addAttribute("name", name);

        return "p";
    }


    @GetMapping("/categories")
    public String categories(@RequestParam(required = false, defaultValue = "") String categorie,
                       Model model) {
        Iterable<products> products = productsRepo.findAll();

        if (categorie != null && !categorie.isEmpty()) {
            products = productsRepo.findByProduct_name(categorie);
        } else {
            products = productsRepo.findAll();
        }
        model.addAttribute("products", products);
        model.addAttribute("name", categorie);

        return "p";
    }
    /*
    @Autowired
    private ProductsRepo ProductsRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model
    ) {
        return "greeting";
    }

    @GetMapping("/")
    public String main(Model model){
        Iterable<products> categories = ProductsRepo.findAll();

        model.addAttribute("categories", categories);

        return "products";
    }*/

}
