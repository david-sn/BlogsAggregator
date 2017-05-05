package com.mycompany.bologsaggregator.Hibernate.Entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Blog  implements java.io.Serializable{

    private int blog_dbid;
    private String blogUrl;
    private String blogName;
    private User user;
    private Set<Item> items=new HashSet<Item>();

    public int getBlog_dbid() {
        return blog_dbid;
    }

    public void setBlog_dbid(int blog_dbid) {
        this.blog_dbid = blog_dbid;
    }

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    
    
}
