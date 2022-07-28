package com.example.productmanagement.controller;

import com.example.productmanagement.model.Product;
import com.example.productmanagement.service.CategoryService;
import com.example.productmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public ModelAndView getList() {
        return new ModelAndView("list", "products", productService.getAll());
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return new ModelAndView("create", "product", new Product());
    }

    @PostMapping("/create")
    public String createProduct(@Validated @ModelAttribute Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("categories", categoryService.getAll());
            return "create";
        }
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Integer id, Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return new ModelAndView("edit", "product", productService.findById(id));
    }

    @PostMapping("/edit")
    public String updateProduct(@RequestParam Integer id,  @ModelAttribute Product product) {
        product.setId(id);
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showFormDelete(@PathVariable Integer id) {
        return new ModelAndView("delete", "product", productService.findById(id));
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam Integer id) {
        productService.deleteById(id);
        return "redirect:/";
    }
}
