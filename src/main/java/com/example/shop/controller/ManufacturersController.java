package com.example.shop.controller;


import com.example.shop.domain.manufacturers;
import com.example.shop.repos.ManufacturersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Map;

@Controller
@RequestMapping(path="/m")
public class ManufacturersController {

    @Autowired
    private ManufacturersRepo manufacturersRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model
    ) {
        return "greeting";
    }

    @GetMapping("/all")
    public String main(Model model){
        Iterable<manufacturers> manufacturers = manufacturersRepo.findAll();

        model.addAttribute("manufacturers", manufacturers);

        return "m";
    }

  /*  @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag, Map<String, Object> model) {
        Message message = new Message(text, tag, user);

        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);

        return "main";
    }*/
}
