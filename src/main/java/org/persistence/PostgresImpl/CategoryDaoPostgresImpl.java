package org.persistence.PostgresImpl;

import org.business.domain.Category;
import org.persistence.CategoryDao;

import javax.persistence.EntityManager;

public class CategoryDaoPostgresImpl extends AbstractDaoPostgresImpl<Category> implements CategoryDao {
    public CategoryDaoPostgresImpl(EntityManager entityManager) {super(entityManager);}
}
