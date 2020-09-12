package org.application.definemodule.businesslogic.services;

import org.application.domain.Category;
import org.application.definemodule.persistence.postgresdao.CategoryDao;

public class CategoryService extends AbstractService<Category> {
//    extends
//} AbstractPostgresServiceImpl<Category> implements CategoryService {
//    public CategoryPostgresService(CategoryDao categoryDao) {
//        super(categoryDao);
//    };
//
//    private CategoryDao categoryDao;
//    private PostgresDaoImplProvider postgresDaoImplProvider;

    public CategoryService(CategoryDao categoryDao){
        super(categoryDao);
    };


//    public void saveOrUpdate(Category category){
//        categoryDao.insert(category);
//    };
//
//    public List<Category> getAllCategorys(){
//        return categoryDao.getAll();
//    };
//
//    public Category getCategoryById(int id){
//        return categoryDao.findById(id);
//    };

}
