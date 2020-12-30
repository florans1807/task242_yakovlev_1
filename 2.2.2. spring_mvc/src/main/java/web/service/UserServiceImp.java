/*
package web.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import web.Util;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Component
public class UserServiceImp implements UserDao {
    SessionFactory sessionFactory;

    public UserServiceImp() {
        sessionFactory = Util.getSessionFactory();
    }

    @Override
    public void add(User user) {
        Transaction ts = null;
        try (Session session = sessionFactory.openSession()) {
            ts = session.beginTransaction();
            session.save(user);
            ts.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            ts.rollback();
        }
    }

    @Override
    public User get(int id) {
        Transaction ts = null;
        User usr = null;
        try (Session session = sessionFactory.openSession()) {
            ts = session.beginTransaction();
            usr = session.get(User.class, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            ts.rollback();
        }
        return usr;
    }

    @Override
    public List<User> getAll() {
        List<User> users = null;
        Transaction ts = null;
        users.add(get(1));
        users.add(get(2));
        users.add(get(3));
 try (Session session = sessionFactory.openSession()) {
            ts = session.beginTransaction();
            users = session.createQuery("SELECT * FROM USER", User.class).list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            ts.rollback();
        }

        return users;
    }

    @Override
    public void update(int id, User updatedUser) {
        Transaction ts = null;
        try (Session session = sessionFactory.openSession()) {
            ts = session.beginTransaction();
            User userToBeUpdated = get(id);
            userToBeUpdated.setName(updatedUser.getName());
            userToBeUpdated.setSurname(updatedUser.getSurname());
            session.update(userToBeUpdated);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            ts.rollback();
        }
    }

    @Override
    public void delete(int id) {
        Transaction ts = null;
        try (Session session = sessionFactory.openSession()) {
            ts = session.beginTransaction();
            session.delete(get(id));
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            ts.rollback();
        }
    }

}
*/
