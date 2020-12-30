package web.controller;

import web.model.User;

import javax.persistence.*;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {

        EntityManager em = null;
        Query query = em.createQuery("from User");
        System.out.println(query.getResultList());

    }
}
