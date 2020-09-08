package org.definemodule.businesslogic.services.postgresserviceimpl;

import org.domain.Category;
import org.definemodule.persistence.postgresdao.CategoryDao;
import org.definemodule.persistence.PostgresImpl.PostgresDaoImplProvider;

import java.util.List;

public class CategoryPostgresService {
//    extends
//} AbstractPostgresServiceImpl<Category> implements CategoryService {
//    public CategoryPostgresService(CategoryDao categoryDao) {
//        super(categoryDao);
//    };

    private CategoryDao categoryDao;
    private PostgresDaoImplProvider postgresDaoImplProvider;

    public CategoryPostgresService(){
        postgresDaoImplProvider = new PostgresDaoImplProvider();
        categoryDao = postgresDaoImplProvider.getCategoryDao();
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