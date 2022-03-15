package com.codegym.service.category;

import com.codegym.dao.category.CategoryDao;
import com.codegym.dao.category.ICategoryDao;
import com.codegym.model.Category;

import java.util.List;

public class CategoryService implements ICategoryService{
    ICategoryDao categoryDao = new CategoryDao();
    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    @Override
    public boolean save(Category category) {
        return false;
    }

    @Override
    public boolean update(int id, Category category) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Category findById(int id) {
        return categoryDao.findById(id);
    }
}
