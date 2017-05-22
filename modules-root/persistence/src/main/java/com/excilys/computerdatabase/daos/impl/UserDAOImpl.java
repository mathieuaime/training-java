package com.excilys.computerdatabase.daos.impl;

import javax.persistence.NoResultException;

import org.hibernate.Session;

import org.springframework.stereotype.Repository;

import com.excilys.computerdatabase.config.hibernate.HibernateConfig;
import com.excilys.computerdatabase.daos.interfaces.UserDAO;
import com.excilys.computerdatabase.exceptions.UserNotFoundException;
import com.excilys.computerdatabase.models.User;

@Repository
public class UserDAOImpl implements UserDAO {

    public User findByUserName(String username) throws UserNotFoundException {
        try (Session session = HibernateConfig.getSessionFactory().openSession();) {
            return session.createQuery("from User where username=:username", User.class)
                    .setParameter("username", username).getSingleResult();
        } catch (NoResultException e) {
            throw new UserNotFoundException("User " + username + " Not Found");
        }
    }

}