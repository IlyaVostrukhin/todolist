package com.projects.dao.interfaces.objects;

import com.projects.dao.interfaces.CommonDAO;
import com.projects.dao.interfaces.FindDAO;
import com.projects.entity.User;

public interface UserDao extends CommonDAO<User>, FindDAO<User> {

    User getByEmail(String email);

}
