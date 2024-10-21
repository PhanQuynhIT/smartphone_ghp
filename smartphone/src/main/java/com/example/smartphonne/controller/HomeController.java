package com.example.smartphonne.controller;
import com.example.smartphonne.model.Products;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    public List<Products> usersList = new ArrayList<Products>();

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("name", "Hello World");

        return "index";
    }
}
