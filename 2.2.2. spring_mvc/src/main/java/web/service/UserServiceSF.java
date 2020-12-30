package web.service;


import org.springframework.stereotype.Service;
import web.model.User;

import javax.persistence.*;
import java.util.List;

@Service
public class UserServiceSF {

    @PersistenceContext
    private EntityManager em;

    public List<User> getAll() {
        Query query = em.createQuery("from User");
        return query.getResultList();
    }
}
