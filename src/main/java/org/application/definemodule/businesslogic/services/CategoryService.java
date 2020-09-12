package org.application.definemodule.businesslogic.services;

import org.application.domain.Category;
import org.application.definemodule.persistence.postgresdao.CategoryDao;

import java.util.List;

public class CategoryService {
//    extends
//} AbstractPostgresServiceImpl<Category> implements CategoryService {
//    public CategoryPostgresService(CategoryDao categoryDao) {
//        super(categoryDao);
//    };
//
    private final CategoryDao categoryDao;

    public CategoryService(CategoryDao categoryDao){
        this.categoryDao = categoryDao;
    };


    public void saveOrUpdate(Category category){
        categoryDao.insert(category);
    };

    public List<Category> getAllCategorys(){
        return categoryDao.getAll();
    };

    public Category getCategoryById(int id){
        return categoryDao.findById(id);
    };

}
