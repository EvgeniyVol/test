package com.example.shop;

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
    /*


    @PostMapping
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        Message message = new Message(text, tag);

        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Message> messages;

        if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByTag(filter);
        } else {
            messages = messageRepo.findAll();
        }

        model.put("messages", messages);

        return "main";
    }

    */
}
