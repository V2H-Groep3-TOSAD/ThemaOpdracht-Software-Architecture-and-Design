package org.application.definemodule.persistence.PostgresImpl;

import org.application.domain.Category;
import org.application.definemodule.persistence.postgresdao.CategoryDao;

import javax.persistence.EntityManager;

public class CategoryDaoPostgresImpl extends AbstractDaoPostgresImpl<Category> implements CategoryDao {
    public CategoryDaoPostgresImpl(EntityManager entityManager) {super(entityManager);}
}
