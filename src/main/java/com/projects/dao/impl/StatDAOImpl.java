package com.projects.dao.impl;

import com.projects.HibernateUtil;
import com.projects.dao.interfaces.objects.StatDAO;
import com.projects.entity.Stat;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class StatDAOImpl implements StatDAO {

    @Override
    public Stat getByUser(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Stat> query = session.createQuery("FROM Stat where user.email like :email");
        query.setParameter("email", "%" + email + "%");
        Stat stat = query.uniqueResult();
        session.close();
        return stat;
    }

}
