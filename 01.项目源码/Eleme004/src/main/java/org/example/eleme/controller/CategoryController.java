package org.example.eleme.controller;

import org.example.eleme.model.Category;
import org.example.eleme.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/business/{businessid}")
    public List<Category> getCategoriesByBusinessId(@PathVariable Long businessid) {
        return categoryService.getCategoriesByBusinessId(businessid);
    }
}

