package com.example.camboelectro;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {
    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }

    @GetMapping("/product-details")
    public String productDetailsPage(Model model) {
        model.addAttribute(appName, appName);
        return "product-details";
    }

    @GetMapping("/about")
    public String aboutPage(Model model) {
        model.addAttribute(appName, appName);
        return "about";
    }

    @GetMapping("/cart")
    public String cartPage(Model model) {
        model.addAttribute(appName, appName);
        return "cart";
    }
}
