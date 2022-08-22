package com.projects.dao.interfaces.objects;

import com.projects.dao.interfaces.CommonDAO;
import com.projects.entity.Activity;

public interface ActivityDAO extends CommonDAO<Activity> {

    Activity getByUser(String email);

}
