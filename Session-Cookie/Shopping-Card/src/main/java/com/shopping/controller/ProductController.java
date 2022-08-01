package com.shopping.controller;

import com.shopping.entity.Product;
import com.shopping.model.Cart;
import com.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private ProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }


    @GetMapping({"/", "/index"})
    public ModelAndView getIndex(@CookieValue String JSESSIONID, HttpServletResponse response, HttpServletRequest request) {
        Cookie cookie = new Cookie("JSESSIONID", JSESSIONID);
        cookie.setMaxAge(3 * 60);
        response.addCookie(cookie);
        return new ModelAndView("index", "products", productService.findAll());
    }

    @GetMapping("/add/{id}")
    public String addProductToCart(@ModelAttribute Cart cart, @PathVariable Integer id, @RequestParam String page) {
        Optional<Product> productOptional = productService.findById(id);
        if(!productOptional.isPresent())
            return "error-404";
        cart.addProduct(productOptional.get());
        if("shopping-cart".equals(page))
            return "redirect:/shopping-cart";
        return "redirect:/index";
    }


    @GetMapping("/sub/{id}")
    public String subProductToCart(@ModelAttribute Cart cart, @PathVariable Integer id, @RequestParam String page) {
        Optional<Product> productOptional = productService.findById(id);
        if(!productOptional.isPresent())
            return "error-404";

        cart.subProduct(productOptional.get());
        if("shopping-cart".equals(page))
            return "redirect:/shopping-cart";

        return "redirect:/index";
    }
}
