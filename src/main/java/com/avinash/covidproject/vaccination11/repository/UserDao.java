package com.avinash.covidproject.vaccination11.repository;

import com.avinash.covidproject.vaccination11.entity.User;

import java.util.List;

public interface UserDao {

     User findByUserName(String userName);

     User save(User user);

     List<User> findAllByStatus();

     List<User> findAll();

     void deleteUser(int theId);

     User findById(int theId);

     List<User> findAllDoctors();

}