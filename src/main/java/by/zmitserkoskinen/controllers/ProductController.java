package by.zmitserkoskinen.controllers;

import by.zmitserkoskinen.domain.Product;
import by.zmitserkoskinen.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", service.listAllProducts());
        return "products";
    }

    @RequestMapping("/product/{id}")
    public String get(@PathVariable int id, Model model) {
        model.addAttribute("product", service.productsById(id));
        return "product";
    }

    @RequestMapping("/product/new")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "productform";
    }

    @RequestMapping("/product/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", service.productsById(id));
        return "productform";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveOrUpdateProduct(Product product) {
        Product productSaved = service.saveOrUpdateProduct(product);
        return "redirect:/product/" + productSaved.getId();
    }


    @RequestMapping(value = "/product/delete/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "redirect:/products";
    }
}
