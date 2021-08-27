package com.avinash.covidproject.vaccination11.service;



import com.avinash.covidproject.vaccination11.dto.UserDto;
import com.avinash.covidproject.vaccination11.mapper.UserMapper;
import com.avinash.covidproject.vaccination11.repository.RoleDao;
import com.avinash.covidproject.vaccination11.repository.UserDao;
import com.avinash.covidproject.vaccination11.entity.Role;
import com.avinash.covidproject.vaccination11.entity.User;
import com.avinash.covidproject.vaccination11.usercheck.CrmUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    // need to inject user dao
    @Autowired
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User findByUserName(String userName) {
        // check the database if the user already exists
        return userDao.findByUserName(userName);
    }

    @Override
    @Transactional
    public void save(CrmUser crmUser) {
        User user = new User();
        // assign user details to the user object
        user.setUserName(crmUser.getUserName());
        user.setPassword(passwordEncoder.encode(crmUser.getPassword()));
        user.setFirstName(crmUser.getFirstName());
        user.setLastName(crmUser.getLastName());
        user.setEmail(crmUser.getEmail());
        user.setGender(crmUser.getGender());
        user.setAge(crmUser.getAge());
        user.setAdharCard(crmUser.getAdharCard());
        user.setVaccinationStatus(crmUser.getVaccinationStatus());


        // give user default role of "user"
        user.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_USER")));

        // save user in the database
        userDao.save(user);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userDao.findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    //find all users



    //find user by id
    @Override
    @Transactional
    public UserDto findById(int theId)
    {
        Optional<User> result= Optional.ofNullable(userDao.findById(theId));
        User theUser=null;
        if(result.isPresent())
        {
            theUser=result.get();
        }
        else{
            throw new RuntimeException("Did not find user id "+theId);
        }
        System.out.println("in user dto"+theUser);
        System.out.println("in user dto"+UserMapper.INSTANCE.entityToDto(theUser));
        return UserMapper.INSTANCE.entityToDto(theUser);

    }

    @Override
    @Transactional
    public User save(UserDto theUserDto)
    {
        User theUser=UserMapper.INSTANCE.dtoToEntity(theUserDto);
        userDao.save(theUser);
        return theUser;

    }

    @Override
    @Transactional

    public Role findRoleByName(String theRoleName)
    {
        return roleDao.findRoleByName(theRoleName);
    }

    @Override
    @Transactional
    public List<User> findAllByStatus()
    {
        return userDao.findAllByStatus();
    }

    @Override
    @Transactional
    public List<UserDto> findAll()
    {

        return UserMapper.INSTANCE.entitiesToDtos(userDao.findAll());
    }

    @Override
    @Transactional
    public  void deleteUser(int theId)
    {
        userDao.deleteUser(theId);
    }



    @Override
    @Transactional
    public List<User> findAllDoctors()
    {
        return userDao.findAllDoctors();
    }
}