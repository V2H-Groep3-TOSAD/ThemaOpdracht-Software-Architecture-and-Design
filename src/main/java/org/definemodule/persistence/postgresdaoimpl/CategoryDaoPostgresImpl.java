package org.definemodule.persistence.postgresdaoimpl;

import org.domain.Category;
import org.definemodule.persistence.postgresdao.CategoryDao;

import javax.persistence.EntityManager;

public class CategoryDaoPostgresImpl extends AbstractDaoPostgresImpl<Category> implements CategoryDao {
    public CategoryDaoPostgresImpl(EntityManager entityManager) {super(entityManager);}
}
