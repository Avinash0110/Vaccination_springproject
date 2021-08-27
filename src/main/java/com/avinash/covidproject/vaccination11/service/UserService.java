package com.avinash.covidproject.vaccination11.service;

import com.avinash.covidproject.vaccination11.dto.UserDto;
import com.avinash.covidproject.vaccination11.entity.Role;
import com.avinash.covidproject.vaccination11.entity.User;
import com.avinash.covidproject.vaccination11.usercheck.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public   interface UserService extends UserDetailsService {

     User findByUserName(String userName);

      void save(CrmUser crmUser);

      List<UserDto> findAll();

      UserDto findById(int theId);

      User save(UserDto theUserDto);

      List<User> findAllByStatus();

      void deleteUser(int theId);


      Role findRoleByName(String theRoleName);



      List<User> findAllDoctors();
}