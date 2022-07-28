package com.blog.controller;

import com.blog.model.Blog;
import com.blog.service.BlogService;
import com.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ModelAndView getAll(Pageable page) {
        return new ModelAndView("list", "blogs", blogService.findAllWithPage(page));
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categoryService.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable("id") Integer code, Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return new ModelAndView("edit", "blog", blogService.findById(code));
    }

    // Path variable: /edit/5
    // Request Param: /edit?id=5
//    @PostMapping("/edit")
//    public String update(@RequestParam Integer id, @ModelAttribute Blog blog) {
    @PostMapping("/edit/{id}")
    public String update(@PathVariable Integer id, @ModelAttribute Blog blog) {
        blog.setId(id);
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showFormDelete(@PathVariable Integer id) {
        return new ModelAndView("delete", "blog", blogService.findById(id));
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        blogService.deleteById(id);
        return "redirect:/";
    }
    //Detail la delete xoa nut delete
}
