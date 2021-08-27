package com.avinash.covidproject.vaccination11.repository;

import com.avinash.covidproject.vaccination11.entity.Role;

public interface RoleDao {

    public Role findRoleByName(String theRoleName);


}