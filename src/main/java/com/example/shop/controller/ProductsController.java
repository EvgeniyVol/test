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

/*    @GetMapping("/")
    public String greeting(Map<String, Object> model
    ) {
        return "greeting";
    }*/

/*
    @GetMapping("/serhc")
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
*/


    @GetMapping
    public String categ(@RequestParam(required = false, defaultValue = "") String name,
                        @RequestParam(required = false, defaultValue = "") String categorie,
                        Model model) {
        Iterable<products> products = productsRepo.findAll();
        Iterable<categories> categories;

        if (categorie != null && !categorie.isEmpty()&&name != null && !name.isEmpty()) {
            //categories = categoRepo.findByCategory_name(categorie);
        } else if (name != null && !name.isEmpty()) {
            products = productsRepo.findByProduct_name(name);
        } else if (categorie != null && !categorie.isEmpty()) {
            categories = categoRepo.findByCategory_name(categorie);
            products = productsRepo.findById_Categories(categories);
        } else {
            Iterable<products> p = productsRepo.findAll();
            model.addAttribute("products", p);
            model.addAttribute("name", name);
            model.addAttribute("categorie", categorie);
            return "p";
        }

        model.addAttribute("products", products);
        model.addAttribute("name", name);
        model.addAttribute("categorie", categorie);

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


        return "p";
    }

/*    @GetMapping
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
    }*/



    /////
    /////
    /////не работает пока что
    /////
/*
    @GetMapping("orders")
    public String addBox(@AuthenticationPrincipal User user,
                         @RequestParam(required = false) String name,
                         Model model){

        */
    /*User users;
        users = userRepo.findByUsername(user);
        Iterable<orders> orders = ordersRepo.findAll();

        orders = ordersRepo.findById_User(users.getId());
        model.addAttribute("orders", orders);*//*

        Iterable<orders> orders = ordersRepo.findById_User(user);
        model.addAttribute("orders", orders);
        */
    /*
        * public String main( {
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
        *
        * */
    /*

        return "orders";
    }

    @GetMapping("delit")
    public String delit(@AuthenticationPrincipal User id_User,
                        @AuthenticationPrincipal products id_Products,
                        Map<String, Object> model){

        orders orders = new orders(1,id_User, id_Products);

        ordersRepo.delete(orders);


        return "orders";
    }

    @PostMapping("allorders")
    public String add(@AuthenticationPrincipal User id_User,
                      @AuthenticationPrincipal products id_Products,
                      @RequestParam() Integer product_count,
                      Map<String, Object> model) {

        orders orders = new orders(product_count,id_User,id_Products);

        ordersRepo.save(orders);



        return "p";
    }*/
    //
    ///
    ////Динозавры
    ///
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
