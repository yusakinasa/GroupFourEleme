package org.example.eleme.service;

import org.example.eleme.model.Food;

import java.util.List;

public interface FoodService {
    List<Food> getFoodsByBusinessId(Long businessid);
}
