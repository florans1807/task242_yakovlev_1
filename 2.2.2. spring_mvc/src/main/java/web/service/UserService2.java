/*
package web.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class UserService2 {

    @PersistenceContext
    public EntityManager em;

    public List<User> getAll() {
        String query = "from USER";
        //String query = "from User";
        //String query = "FROM USER";
        //String query = "FROM User";
        TypedQuery<User> typedQuery = em.createQuery(query, User.class);
        return typedQuery.getResultList();
    }

   */
/* public User get(int id) {
        return em.find(User.class, id);
    }

    public void add(User user) {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    public void update(int id, User updatedUser) {
        em.getTransaction().begin();
        User userToBeUpdated = get(id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setSurname(updatedUser.getSurname());
        em.merge(updatedUser);
        em.getTransaction().commit();
    }

    public void delete(int id) {
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }*//*

}
*/
