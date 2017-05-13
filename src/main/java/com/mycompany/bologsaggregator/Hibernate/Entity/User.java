/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bologsaggregator.Hibernate.Entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author David Shire
 */
public class User  implements java.io.Serializable{
    private int user_dbid;
    private String userName;
    private String userEmail;
    private Set<Role> roles=new HashSet<Role>();
    private Set<Blog> blogs=new HashSet<Blog>();;

    public int getUser_dbid() {
        return user_dbid;
    }

    public void setUser_dbid(int user_dbid) {
        this.user_dbid = user_dbid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }

    
    
    
}