package models;

import java.util.Objects;

public class News {
    private int id;
    private String General_News;
    private String Department_News;
    private int departmentid;
//    private int department;

    public News(String general_News, String department_News,int departmentid) {
        General_News = general_News;
        Department_News = department_News;
       this.departmentid=departmentid;
    }

    public int getId() {
        return id;
    }
    public int getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getGeneral_News() {
        return General_News;
    }

    public void setGeneral_News(String general_News) {
        General_News = general_News;
    }

    public String getDepartment_News() {
        return Department_News;
    }

    public void setDepartment_News(String department_News) {
        Department_News = department_News;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return id == news.id &&
                departmentid == news.departmentid &&
                Objects.equals(General_News, news.General_News) &&
                Objects.equals(Department_News, news.Department_News);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, General_News, Department_News, departmentid);
    }
}
