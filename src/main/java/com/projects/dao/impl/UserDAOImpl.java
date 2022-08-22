package com.projects.dao.impl;

import com.projects.HibernateUtil;
import com.projects.dao.interfaces.objects.UserDao;
import com.projects.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAOImpl implements UserDao {

    @Override
    public List<User> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<User> query = session.createQuery("FROM User");
        List<User> users = query.getResultList();
        session.close();
        return users;
    }

    @Override
    public List<User> findAll(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<User> query = session.createQuery("FROM User where email like :email");
        query.setParameter("email", "%" + email + "%");
        List<User> users = query.getResultList();
        session.close();
        return users;
    }

    @Override
    public User get(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    @Override
    public void update(User obj) {
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
        User user = new User();
        user.setId(id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void add(User obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public User getByEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<User> query = session.createQuery("FROM User where email like :email");
        query.setParameter("email", "%" + email + "%");
        User user = query.uniqueResult();
        session.close();
        return user;
    }
}
