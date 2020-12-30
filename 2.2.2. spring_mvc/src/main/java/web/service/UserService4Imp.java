package web.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.model.User;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

@Service
@PropertySource(value = "classpath:db.properties")
public class UserService4Imp {

    private Environment environment;

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    private static int counter = 3;


    private static final String URL = "jdbc:h2:C:\\db.mv.db/yakovlev;MV_STORE=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Loskov10";


   /* private final String URL = environment.getRequiredProperty("db.url");
    private final String USERNAME = environment.getRequiredProperty("db.username");
    private final String PASSWORD = environment.getRequiredProperty("db.password");*/


    //private static Connection connection;

   /* private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }*/


    public List<User> getAll() {
       List<User> users = new ArrayList<>();
       try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
           Statement statement = connection.createStatement();
           String SQL = "SELECT * FROM USER";
           ResultSet resultSet = statement.executeQuery(SQL);
           while(resultSet.next()) {
               User user = new User();
               user.setId(resultSet.getInt("Id"));
               user.setName(resultSet.getString("fristname"));
               user.setSurname(resultSet.getString("secondname"));
               users.add(user);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return users;
    }

    public List<User> getAll2() {
        List<User> users = new ArrayList<>();
        users.add(new User(++counter, "Tom", "asx"));
        users.add(new User(++counter, "Bob", "sxaxa"));
        return users;
    }

   /* public List<User> getAll3() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM USER").list();
    }*/







/*
 static {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM USER";
            ResultSet resultSet = statement.executeQuery(SQL);
            while(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("Id"));
                user.setName(resultSet.getString("fristname"));
                user.setSurname(resultSet.getString("secondname"));
                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }





public void add(User user) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO USER VALUES(?, ?, ?)");

            preparedStatement.setInt(1, counter++);
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getSurname());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public User get(int id) {
        User user = null;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM USER WHERE Id=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            user = new User();

            user.setId(resultSet.getInt("Id"));
            user.setName(resultSet.getString("firstname"));
            user.setSurname(resultSet.getString("secondname"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user;
    }

    public void update(int id, User updatedUser) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE USER SET firstname=?, secondname=?, WHERE Id=?");

            preparedStatement.setString(1, updatedUser.getName());
            preparedStatement.setString(2, updatedUser.getSurname());
            preparedStatement.setInt(3, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM USER WHERE Id=?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }*/


}
