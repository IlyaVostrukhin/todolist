package com.projects.dao.interfaces.objects;

import com.projects.entity.Stat;

public interface StatDAO {

    Stat getByUser(String email);

}
