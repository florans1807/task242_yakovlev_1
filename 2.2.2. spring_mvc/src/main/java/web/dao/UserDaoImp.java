/*
package web.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    */
/*private static final String URL = "jdbc:h2:C:\\db.mv.db/yakovlev;MV_STORE=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Loskov10";

    @Override
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
    }*//*




    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from USER").list();
    }

}
*/
