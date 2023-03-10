package com.example.shop.controller;

import com.example.shop.domain.categories;
import com.example.shop.repos.CategoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(path="/categories")
public class CategoController {

    @Autowired
    private CategoRepo categoRepo;

    @GetMapping
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model){
        Iterable<categories> categories = categoRepo.findAll();

        if (filter != null && !filter.isEmpty()) {
            categories = categoRepo.findByCategory_name(filter);
        }else {
            categories = categoRepo.findAll();
        }

        model.addAttribute("categories", categories);
        return "categories";
    }

    @PostMapping
    public String add(@RequestParam String category_name, Map<String, Object> model){
        categories categories = new categories(category_name);

        categoRepo.save(categories);

        Iterable<categories> newcatego = categoRepo.findAll();

        model.put("categories", newcatego);

        return "categories";



    }
}
