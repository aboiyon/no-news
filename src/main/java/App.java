import models.Departments;
import models.News;
import com.google.gson.Gson;
import Sql2o.Sql2oDepartments
import models.User;
import org.sql2o.Sql2o;
import static spark.Spark.*;
import Sql2o.Sql2oNews;
import Sql2o.Sql2oUser;


import java.sql.Connection;

public class App {
        static int getHerokuAssignedPort() {
            ProcessBuilder processBuilder = new ProcessBuilder();
            if (processBuilder.environment().get("PORT") != null) {
                return Integer.parseInt(processBuilder.environment().get("PORT"));
            }
            return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
        }
        public static void main(String[] args) {

            port(getHerokuAssignedPort());
            staticFileLocation("/public");

        Sql2oDepartments departments;
        Sql2oNews sql2oNew ;
        Sql2oUser sql2ouser;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:postgresql://ec2-44-192-245-97.compute-1.amazonaws.com:5432/d25447eo48khd6?sslmode=require"; //!
            Sql2o sql2o = new Sql2o(connectionString, "baovfjsipcsjhq", "9da962fafc193eb2a850ab013db7ed5441025e1cabfaa10171e404752f870839"); //!
//        String connectionString = "jdbc:h2:~/company.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
//        Sql2o sql2o = new Sql2o(connectionString, "moringa", "");

        departments = new Sql2oDepartments(sql2o);
        sql2oNew = new Sql2oNews(sql2o);
        sql2ouser = new Sql2oUser(sql2o);
//        conn = sql2o.open();

        post("/department/new", "application/json", (req, res) -> {
            Departments department1 = gson.fromJson(req.body(), Departments.class);
            departments.create(department1);
            res.status(201);
            res.type("application/json");
            return gson.toJson(department1);
        });
        get("/department", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(departments.findAll());
        });

        post("/news/new", "application/json", (req, res) -> {
            News news = gson.fromJson(req.body(), News.class);
            sql2oNew.create(news);
            res.status(201);
            res.type("application/json");
            return gson.toJson(news);
        });
        get("/news", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(sql2oNew.findAll());
        });

        post("/users/new", "application/json", (req, res) -> {
            User user = gson.fromJson(req.body(), User.class);
            sql2ouser.create(user);
            res.status(201);
            res.type("application/json");
            return gson.toJson(user);
        });
        get("/users", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(sql2ouser.findAll());
        });


    }
}
