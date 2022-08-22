package com.projects.dao.impl;

import com.projects.HibernateUtil;
import com.projects.dao.interfaces.objects.ActivityDAO;
import com.projects.entity.Activity;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class ActivityDAOImpl implements ActivityDAO {

    @Override
    public Activity get(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Activity activity = session.get(Activity.class, id);
        session.close();
        return activity;
    }

    @Override
    public void update(Activity obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(obj);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        throw new IllegalStateException("You can't DELETE activity by yourself! Only DB's trigger can!");
    }

    @Override
    public void add(Activity obj) {
        throw new IllegalStateException("You can't ADD activity by yourself! Only DB's trigger can!");
    }

    @Override
    public Activity getByUser(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Activity> query = session.createQuery("FROM Activity where user.email like :email");
        query.setParameter("email", "%" + email + "%");
        Activity activity = query.uniqueResult();
        session.close();
        return activity;
    }
}
