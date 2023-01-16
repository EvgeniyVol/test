package com.example.shop.controller;


import com.example.shop.CategoController;
import com.example.shop.domain.manufacturers;
import com.example.shop.repos.ManufacturersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Map;

@Controller
@RequestMapping(path="/manufacturers")
public class ManufacturersController extends CategoController {

    private final ManufacturersRepo manufacturersRepo;

    public ManufacturersController(ManufacturersRepo manufacturersRepo) {
        this.manufacturersRepo = manufacturersRepo;
    }

    @GetMapping
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model){
        Iterable<manufacturers> manufacturers = manufacturersRepo.findAll();

        if (filter != null && !filter.isEmpty()) {
            manufacturers = manufacturersRepo.findByManufacturer_name(filter);
        }else {
            manufacturers = manufacturersRepo.findAll();
        }

        model.addAttribute("manufacturers", manufacturers);

        return "manufacturers";
    }


    @PostMapping
    public String add(@RequestParam String manufacturer_name, Map<String, Object> model){
        manufacturers manufacturers = new manufacturers(manufacturer_name);

        manufacturersRepo.save(manufacturers);

        Iterable<manufacturers> newmanufac = manufacturersRepo.findAll();

        model.put("manufacturers", newmanufac);


        return "manufacturers";
    }
}
