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
import org.springframework.web.bind.annotation.*;

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


    @Autowired
    private ordersRepo ordersRepo;
    @Autowired
    private UserRepo userRepo;

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

    @GetMapping("orders")
    public String addBox(@AuthenticationPrincipal User user,
                         @RequestParam(required = false) String name,
                         Model model){

        /*User users;
        users = userRepo.findByUsername(user);
        Iterable<orders> orders = ordersRepo.findAll();

        orders = ordersRepo.findById_User(users.getId());
        model.addAttribute("orders", orders);*/

        Iterable<orders> orders = ordersRepo.findById_User(user);
        model.addAttribute("orders", orders);
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

        return "orders";
    }

    @GetMapping("delit/{id}")
    public String delit(@AuthenticationPrincipal User id_User,
                        @RequestParam orders id,
                        Model model){


        ordersRepo.deleteById(id.getId());

        Iterable<orders> order = ordersRepo.findById_User(id_User);
        model.addAttribute("orders", order);


        return "orders";
    }

    @PostMapping(path = "allorders")
    public String add(@AuthenticationPrincipal User user,
                      @RequestParam products products,
                      Map<String, Object> model){

        orders orders = new orders(1,user,products);

        ordersRepo.save(orders);



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
