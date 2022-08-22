package com.projects;

import com.projects.dao.impl.*;
import com.projects.entity.*;
import lombok.extern.log4j.Log4j2;

import java.util.Date;

@Log4j2
public class Main {
    public static void main(String[] args) {

//        СЦЕНАРИЙ:
//        создаем пользователя (триггеры создадут сразу же тестовые данные)
//        активируем пользователя (поле activated)
//        создаем новую категорию
//        создаем новый приоритет
//        создаем несколько новых задач (помимо тестовых) с новыми категорией и приоритетом
//        завершаем задачу
//        удаляем задачу
//        считываем статистику по любой категории пользователя
//        считываем общую статистику пользователя


//        // создаем пользователя (триггеры создадут сразу же тестовые данные)
//        User user = new User();
//        user.setUsername("testuser");
//        user.setPassword("testuser");
//        user.setEmail("testuser@gmail.com");
//
//        UserDAOImpl userDAO = new UserDAOImpl();
//        userDAO.add(user);
//
//        // активируем пользователя (поле activated)
//        ActivityDAOImpl activityDAO = new ActivityDAOImpl();
//        Activity activity = activityDAO.getByUser(user);
//        activity.setActivated(true);
//        activityDAO.update(activity);

        UserDAOImpl userDAO = new UserDAOImpl();

        User user = userDAO.get(10025L);

        // создаем справочные значения
        PriorityDAOImpl priorityDAO = new PriorityDAOImpl();

        Priority priority = new Priority();
        priority.setColor("#fff");
        priority.setTitle("Новый приоритет");
        priority.setUser(user);
        priorityDAO.add(priority);

        CategoryDAOImpl categoryDAO = new CategoryDAOImpl();

        Category category = new Category();
        category.setTitle("Новая категория");
        category.setUser(user);
        categoryDAO.add(category);

        TaskDAOImpl taskDAO = new TaskDAOImpl();

        Task task = new Task();
        task.setUser(user);
        task.setTitle("Супер новая задача222");
        task.setCategory(category);
        task.setPriority(priority);
        task.setTaskDate(new Date());
        task.setIsCompleted(false);
        taskDAO.add(task);

        task.setIsCompleted(true);
        taskDAO.update(task);

//        taskDAO.delete(task.getId());

        StatDAOImpl statDAO = new StatDAOImpl();
        Stat stat = statDAO.getByUser(user.getEmail());

        log.info(stat.getCompletedTotal());

        log.info(category.getCompletedCount());
        log.info(categoryDAO.get(category.getId()).getCompletedCount());

        HibernateUtil.shutdown();
    }
}
