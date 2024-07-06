package org.example.eleme.service.impl;

import org.example.eleme.mapper.CategoryMapper;
import org.example.eleme.model.Category;
import org.example.eleme.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getCategoriesByBusinessId(Long businessid
    ) {
        return categoryMapper.getCategoriesByBusinessId(businessid);
    }
}

