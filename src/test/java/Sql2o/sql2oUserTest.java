//package Sql2o;
//
//import models.User;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
////import org.sql2o.Connection;
//import org.sql2o.Sql2o;
//
////import java.sql.Connection;
//import org.sql2o.*;
//import org.junit.*;
//
//
//import static org.junit.Assert.*;
//
//public class sql2oUserTest {
//    private Connection con;
//    private sql2oUser users;
//
//
//    @Before
//    public void setUp() throws Exception {
//        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
//        Sql2o sql2o = new Sql2o(connectionString, "", "");
//        users = new sql2oUser(sql2o);
//        con=sql2o.open();
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        con.close();
//    }
//
//    @Test
//    public void adding_setids() throws Exception {
//       User user = new User("top","ceo",9);
//       int originalId = user.getId();
//       users.create(user);
//       assertNotEquals(originalId,user.getId());
//    }
//
//    @Test
//    public void existingUserscanBeFound()throws Exception {
//        User user = new User("top","ceo",9);
//        users.create(user);
//        User foundUser = users.findbyId(user.getId());
//        assertEquals(user,foundUser);
//    }
//
//    @Test
//    public void addedUserCanBeREturned()throws Exception {
//         User user = new User("top","ceo",9);
//         users.create(user);
//         assertEquals(1,users.findAll().size());
//    }
//
//    @Test
//    public void nousersReturned()throws Exception {
//        assertEquals(0,users.findAll().size());
//    }
//}