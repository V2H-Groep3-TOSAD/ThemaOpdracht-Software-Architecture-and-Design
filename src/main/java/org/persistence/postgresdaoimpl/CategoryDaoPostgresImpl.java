package org.persistence.postgresdaoimpl;

import org.businesslogic.domain.Category;
import org.persistence.postgresdao.CategoryDao;

import javax.persistence.EntityManager;

public class CategoryDaoPostgresImpl extends AbstractDaoPostgresImpl<Category> implements CategoryDao {
    public CategoryDaoPostgresImpl(EntityManager entityManager) {super(entityManager);}
}
