package com.projects.dao.impl;

import com.projects.HibernateUtil;
import com.projects.dao.interfaces.objects.CategoryDAO;
import com.projects.entity.Category;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {
    
    @Override
    public List<Category> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Category> query = session.createQuery("FROM Category");
        List<Category> users = query.getResultList();
        session.close();
        return users;
    }

    @Override
    public List<Category> findAll(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Category> query = session.createQuery("FROM Category c where c.user.email like :email");
        query.setParameter("email", "%" + email + "%");
        List<Category> users = query.getResultList();
        session.close();
        return users;
    }

    @Override
    public Category get(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Category category = session.get(Category.class, id);
        session.close();
        return category;
    }

    @Override
    public void update(Category obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(obj);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Category category = new Category();
        category.setId(id);
        session.delete(category);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void add(Category obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
        session.close();
    }
    
}
