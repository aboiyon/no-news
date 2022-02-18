package dao;

import models.Departments;
import models.News;

import java.util.List;

public interface IntNews {

    //    CRUDE
//create
    void create(News news);
//    void  addNewsToRestaurant(News news, Departments departments);

    //read
    List<News> findAll();
//    List<Departments> getallDepartmentNews(int id);
    News findbyId(int id);

//    delete
    void deleteAll();
    void deleteById(int id);

}
