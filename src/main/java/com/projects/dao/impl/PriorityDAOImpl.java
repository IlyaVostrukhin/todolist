package com.projects.dao.impl;

import com.projects.HibernateUtil;
import com.projects.dao.interfaces.objects.PriorityDAO;
import com.projects.entity.Priority;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PriorityDAOImpl implements PriorityDAO {
    
    @Override
    public List<Priority> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Priority> query = session.createQuery("FROM Priority");
        List<Priority> users = query.getResultList();
        session.close();
        return users;
    }

    @Override
    public List<Priority> findAll(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Priority> query = session.createQuery("FROM Priority where user.email like :email");
        query.setParameter("email", "%" + email + "%");
        List<Priority> users = query.getResultList();
        session.close();
        return users;
    }

    @Override
    public Priority get(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Priority priority = session.get(Priority.class, id);
        session.close();
        return priority;
    }

    @Override
    public void update(Priority obj) {
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
        Priority priority = new Priority();
        priority.setId(id);
        session.delete(priority);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void add(Priority obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
        session.close();
    }
    
}
