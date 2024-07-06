package org.example.eleme.service;

import org.example.eleme.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategoriesByBusinessId(Long businessid);
}
