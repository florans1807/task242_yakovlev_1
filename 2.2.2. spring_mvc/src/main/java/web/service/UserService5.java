/*
package web.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

@Transactional
@Repository
public class UserService5 {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from USER").list();
    }

public void add(Film film) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(film);
    }


    public void delete(Film film) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(film);
    }

    public void edit(Film film) {
        Session session = sessionFactory.getCurrentSession();
        session.update(film);
    }


    public Film getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Film.class, id);
    }

    public int filmsCount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from Film", Number.class).getSingleResult().intValue();
    }

    public boolean checkTitle(String title) {
        Session session = sessionFactory.getCurrentSession();
        Query query;
        query = session.createQuery("from Film where title = :title");
        query.setParameter("title", title);
        return query.list().isEmpty();
    }

}
*/
