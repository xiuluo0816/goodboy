package com.novel.basic.cms.service.impl;


import com.novel.basic.cms.model.Category;
import com.novel.basic.cms.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
@Service
public class CategoryServiceImpl implements CategoryService {


    @Override
    public List<Category> findAll() {
        return new ArrayList<>();
    }

    @Override
    public void add(Category category) {

    }

    @Override
    public Category findById(String id) {
        return new Category();
    }

    @Override
    public void update(Category category) {

    }

    @Override
    public void delete(String[] marked) {

    }
}
