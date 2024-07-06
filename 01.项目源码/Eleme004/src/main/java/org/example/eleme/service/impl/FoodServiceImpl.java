package org.example.eleme.service.impl;

import org.example.eleme.mapper.FoodMapper;
import org.example.eleme.model.Food;
import org.example.eleme.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodMapper foodMapper;

    @Override
    public List<Food> getFoodsByBusinessId(Long businessid) {
        return foodMapper.getFoodsByBusinessId(businessid);
    }
}

