package com.projects.dao.impl;

import com.projects.HibernateUtil;
import com.projects.dao.interfaces.objects.TaskDAO;
import com.projects.entity.Task;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TaskDAOImpl implements TaskDAO {
    @Override
    public List<Task> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Task> query = session.createQuery("FROM Task");
        List<Task> users = query.getResultList();
        session.close();
        return users;
    }

    @Override
    public List<Task> findAll(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Task> query = session.createQuery("FROM Task t where t.user.email like :email");
        query.setParameter("email", "%" + email + "%");
        List<Task> users = query.getResultList();
        session.close();
        return users;
    }

    @Override
    public Task get(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Task task = session.get(Task.class, id);
        session.close();
        return task;
    }

    @Override
    public void update(Task obj) {
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
        Task task = new Task();
        task.setId(id);
        session.delete(task);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void add(Task obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Task> find(boolean isCompleted, String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Task> query = session.createQuery("FROM Task where user.email like :email and isCompleted = :isCompleted");
        query.setParameter("email", "%" + email + "%");
        query.setParameter("isCompleted", isCompleted);
        List<Task> users = query.getResultList();
        session.close();
        return users;
    }
}
