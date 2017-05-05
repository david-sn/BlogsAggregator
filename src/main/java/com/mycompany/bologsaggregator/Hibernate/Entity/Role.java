package com.mycompany.bologsaggregator.Hibernate.Entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Role {

    private int role_dbid;
    private String roleName;
    private Set<User> users=new HashSet<User>();

    public int getRole_dbid() {
        return role_dbid;
    }

    public void setRole_dbid(int role_dbid) {
        this.role_dbid = role_dbid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    
    


    
    
    
  
  
}
