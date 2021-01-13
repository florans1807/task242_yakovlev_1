package web.service;


import org.springframework.stereotype.Service;
import web.model.User;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceSF {

    @PersistenceContext
    private EntityManager em;

    public List<User> getAll() {
        TypedQuery<User> typedQuery = em.createQuery("from User", User.class);
        return typedQuery.getResultList();
    }

    public User get(int id) {
        return em.find(User.class, id);
    }

    public void add(User user) {
        em.persist(user);
    }

    public void update(int id, User updatedUser) {
        User userToBeUpdated = get(id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setSurname(updatedUser.getSurname());
        em.persist(userToBeUpdated);
    }

    public void delete(int id) {
        em.remove(get(id));
    }

}
