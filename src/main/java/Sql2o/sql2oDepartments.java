package Sql2o;
import dao.IntDepartments;
import models.Departments;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class sql2oDepartments implements IntDepartments {


    private final Sql2o sql2o;
    public sql2oDepartments(Sql2o sql2o)
      { this.sql2o = sql2o; }


    @Override
    public void create(Departments departments) {
        String sql = "INSERT INTO departments (departmentName) VALUES(:departmentName)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql,true)
                    .bind(departments)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
            departments.setid(id);
        }catch (Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public void addNewsToDepartments(Departments departments, News news) {

    }

    @Override
    public List<Departments> findAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM departments")
                    .executeAndFetch(Departments.class);
        }
    }

    @Override
    public List<News> getAllNewsByDepartments(int departmentId) {
        return null;
    }

    @Override
    public Departments findbyId(int id) {
        try(Connection con= sql2o.open()){
            return con.createQuery("SELECT * FROM departments WHERE id=:id")
                  .addParameter("id",id)
                    .executeAndFetchFirst(Departments.class);
        }
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE FROM departments";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        }catch(Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM departments WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql).addParameter("id",id)
                    .executeUpdate();
        }catch(Sql2oException e){
            System.out.println("runnn");
        }
    }
}
