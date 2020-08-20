package org.services.PostgresServiceImpl;

import org.business.domain.Category;
import org.persistence.CategoryDao;
import org.persistence.PostgresImpl.PostgresImplService;

import java.util.List;

public class CategoryPostgresService {
//    extends
//} AbstractPostgresServiceImpl<Category> implements CategoryService {
//    public CategoryPostgresService(CategoryDao categoryDao) {
//        super(categoryDao);
//    };

    private CategoryDao categoryDao;
    private PostgresImplService postgresImplService;

    public CategoryPostgresService(){
        postgresImplService = new PostgresImplService();
        categoryDao = postgresImplService.getCategoryDao();
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
