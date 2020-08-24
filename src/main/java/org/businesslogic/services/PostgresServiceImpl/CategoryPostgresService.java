package org.businesslogic.services.PostgresServiceImpl;

import org.businesslogic.domain.Category;
import org.persistence.postgresdao.CategoryDao;
import org.businesslogic.services.postgresservice.CategoryService;

public class CategoryPostgresService extends AbstractPostgresServiceImpl<Category> implements CategoryService {
    public CategoryPostgresService(CategoryDao categoryDao) {
        super(categoryDao);
    };

}
