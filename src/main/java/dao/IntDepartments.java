package dao;

import models.Departments;
import models.News;

import java.util.List;

public interface IntDepartments {
//   create
    void create(Departments departments);
    void addNewsToDepartments(Departments departments,News news);
//    read
    List<Departments> findAll();
    List<News> getAllNewsByDepartments(int departmentId);
    Departments findbyId(int id);
//    delete
    void deleteAll();
    void deleteById(int id);
}
