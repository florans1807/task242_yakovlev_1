package web.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import web.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:h2:C:\\db.mv.db/yakovlev;MV_STORE=false";
        String username = "root";
        String password = "Loskov10";

       /* List<User> users = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection successful!");
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
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
        for (User us: users) {
            System.out.println(us.getName());
        }*/

/*
        List<User> users = new ArrayList<>();

        SessionFactory sessionFactory = null;
        Session session = sessionFactory.getCurrentSession();
        users = session.createQuery("from USER").list();
        for (User us: users) {
            System.out.println(us.getName());
        }*/
    }
}
