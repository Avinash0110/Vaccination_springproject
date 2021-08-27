package com.avinash.covidproject.vaccination11.repository;


import javax.persistence.EntityManager;

import com.avinash.covidproject.vaccination11.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private RoleDao roleDao;

    @Override
    public User findByUserName(String theUserName) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // now retrieve/read from database using username
        Query<User> theQuery = currentSession.createQuery("from User where userName=:uName", User.class);
        theQuery.setParameter("uName", theUserName);
        User theUser = null;
        try {
            theUser = theQuery.getSingleResult();
        } catch (Exception e) {
            theUser = null;
        }

        return theUser;
    }

    @Override
    public User save(User theUser) {
        // get current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create the user ... finally LOL

        if(theUser.getId()==0)
            currentSession.save(theUser);
        else
        {
            User tempUser=findById(theUser.getId());

            tempUser.setVaccinationStatus(theUser.getVaccinationStatus());

            currentSession.save(tempUser);
        }

       return theUser;
    }

    @Override
    public List<User> findAllByStatus() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<User> theQuery =
                currentSession.createQuery("from User where vaccinationStatus=:vStatus", User.class);

        theQuery.setParameter("vStatus", "Not vaccinated");

        // execute query and get result list
        List<User> Users = theQuery.getResultList();

        // return the results
        return Users;
    }

    @Override
    public List<User> findAllDoctors()
    {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<User> theQuery =
                currentSession.createQuery("from User where userName like 'Doctor%'", User.class);



        // execute query and get result list
        List<User> Users = theQuery.getResultList();

        // return the results
        return Users;
    }




    @Override
    public List<User> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<User> theQuery =
                currentSession.createQuery("from User ", User.class);



        // execute query and get result list
        List<User> Users = theQuery.getResultList();

        // return the results
        return Users;
    }


    @Override
    public User findById(int theId)
    {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // now retrieve/read from database using the primary key
        User theUser = currentSession.get(User.class, theId);

        return theUser;
    }


    @Override
    public void deleteUser(int theId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from User where id=:userId");
        theQuery.setParameter("userId", theId);

        theQuery.executeUpdate();
    }



}