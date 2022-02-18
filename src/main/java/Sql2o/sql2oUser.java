package Sql2o;

import dao.IntUser;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class sql2oUser implements IntUser {

    private final Sql2o sql2o;

    public sql2oUser(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override

    public void create(User user) {
        String sql ="INSERT INTO user(position,role,department) VALUES (:position,:role,:department)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql,true)
                    .bind(user)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
            user.setId(id);
        }catch(Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public List<User> findAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM users")
                    .executeAndFetch(User.class);
        }
    }

    @Override
    public User findbyId(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM users WHERE id=:id")
                    .addParameter("id",id)
                    .executeAndFetchFirst(User.class);
        }
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE FROM Users";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        }catch(Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM users WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql).addParameter("id",id)
                    .executeUpdate();
        }catch(Sql2oException e){
            System.out.println("runnn");
        }
    }
}
