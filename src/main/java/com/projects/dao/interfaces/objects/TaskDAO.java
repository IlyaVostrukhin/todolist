package com.projects.dao.interfaces.objects;

import com.projects.dao.interfaces.CommonDAO;
import com.projects.dao.interfaces.FindDAO;
import com.projects.entity.Task;

import java.util.List;

public interface TaskDAO extends CommonDAO<Task>, FindDAO<Task> {

    List<Task> find(boolean isCompleted, String email);

}
