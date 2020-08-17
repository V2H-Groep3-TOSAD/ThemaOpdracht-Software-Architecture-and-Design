package org.services.PostgresServiceImpl;

import org.domain.Category;
import org.persistence.CategoryDao;
import org.persistence.PostgresImpl.PostgresImplService;
import org.services.CategoryService;

import java.util.List;

public class CategoryPostgresService extends AbstractPostgresServiceImpl<Category> implements CategoryService {
    public CategoryPostgresService(CategoryDao categoryDao) {
        super(categoryDao);
    };

}
