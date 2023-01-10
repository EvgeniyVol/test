package com.example.shop.controller;



import com.example.shop.domain.User;
import com.example.shop.domain.categories;
import com.example.shop.domain.products;
import com.example.shop.repos.CategoRepo;
import com.example.shop.repos.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path="/p")
public class ProductsController {


    @Autowired
    private ProductsRepo productsRepo;


    @Autowired
    private CategoRepo categoRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model
    ) {
        return "greeting";
    }

    @GetMapping("/all")
    public String main(@RequestParam(required = false, defaultValue = "") String name,
                       Model model) {
        List<products> products = productsRepo.findByProduct_name(name);
        if (name != null && !name.isEmpty()) {
            products = productsRepo.findByProduct_name(name);
        } else {
            Iterable<products> p = productsRepo.findAll();
            model.addAttribute("products", p);
            model.addAttribute("name", name);
            return "p";
        }
        model.addAttribute("products", products);
        model.addAttribute("name", name);

        return "p";
    }


    @GetMapping("/categories")
    public String categ(@RequestParam(required = false, defaultValue = "") String categorie,
                       Model model) {

        Iterable<categories> categories;
        if (categorie != null && !categorie.isEmpty()) {
            categories = categoRepo.findByCategory_name(categorie);
        } else {
            Iterable<products> p = productsRepo.findAll();
            model.addAttribute("products", p);
            model.addAttribute("categorie", categorie);
            return "p";
        }

        List<products> products;

            products = productsRepo.findById_Categories(categories);

        model.addAttribute("products", products);
        model.addAttribute("categorie", categorie);

        return "p";
    }

/*    @GetMapping("/categories")
    public String categ(@RequestParam(required = false, defaultValue = "") String categorie,
                       Model model) {
        Iterable<products> products = productsRepo.findAll();
        Iterable<categories> categories = categoRepo.findAll();

        if (categorie != null && !categorie.isEmpty()) {
            categories = categoRepo.findByCategory_name(categorie);
        } else {
            categories = null;
        }



        if (categorie != null && !categorie.isEmpty()) {
            products = productsRepo.findById_Сategories(categorie);
        } else {
            products = productsRepo.findAll();
        }
        model.addAttribute("products", products);
        model.addAttribute("categories", categorie);

        return "p";
    }*/
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
