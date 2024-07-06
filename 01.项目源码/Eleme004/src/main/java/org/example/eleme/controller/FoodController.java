package org.example.eleme.controller;

import org.example.eleme.model.Food;
import org.example.eleme.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/business/{businessid}")
    public List<Food> getFoodsByBusinessId(@PathVariable Long businessid) {
        return foodService.getFoodsByBusinessId(businessid);
    }
}

