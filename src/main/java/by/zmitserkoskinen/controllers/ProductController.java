package by.zmitserkoskinen.controllers;

import by.zmitserkoskinen.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("/products")
    public String listProducts(Model model){
        model.addAttribute("products", service.listAllProducts());
        return "products";
    }

}