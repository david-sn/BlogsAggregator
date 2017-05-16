package com.mycompany.bologsaggregator.Hibernate.Session;

import com.mycompany.bologsaggregator.Hibernate.DAO.BlogDAO;
import com.mycompany.bologsaggregator.Hibernate.DAO.ItemDAO;
import com.mycompany.bologsaggregator.Hibernate.DAO.RoleDAO;
import com.mycompany.bologsaggregator.Hibernate.DAO.UserDAO;
import com.mycompany.bologsaggregator.Hibernate.Entity.Blog;
import com.mycompany.bologsaggregator.Hibernate.Entity.Item;
import com.mycompany.bologsaggregator.Hibernate.Entity.Role;
import com.mycompany.bologsaggregator.Hibernate.Entity.User;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

public class InitDB {

    @Autowired
    BlogDAO blogDAO;

    @Autowired
    ItemDAO itemDAO;

    @Autowired
    RoleDAO roleDAO;

    @Autowired
    UserDAO userDAO;
 
    public void Init() {

        
        System.out.println("*******************************");
        
        
        Role roleUser = new Role();
        roleUser.setRoleName("ROLE_USER");

        roleDAO.createRole(roleUser);

        
        Role roleAdmin = new Role();
        roleAdmin.setRoleName("ROLE_ADMIN");

        roleDAO.createRole(roleAdmin);
//
        
        
        
        User userAdmin =new User();
        userAdmin.setUserName("admin");
        userAdmin.setUserPassword("admin");
        Set<Role> roles =new HashSet<Role>();
        roles.add(roleUser);
        roles.add(roleAdmin);
        userAdmin.setRoles(roles);
        
        userDAO.createUser(userAdmin);
        
        
        
        
        
        Blog blogJavaIds=new Blog();
        blogJavaIds.setBlogName("JabaVids");
        blogJavaIds.setBlogUrl("http://feeds.feedburner.com/javavids?format=xml");
        blogJavaIds.setUser(userAdmin);
        
        blogDAO.createBlog(blogJavaIds);
        
        
        
        
        
        
        
        
        Item item1 =new Item();
        item1.setBlog(blogJavaIds);
        item1.setItemTitle("First");
        item1.setItemLink("http://www.javavids.com");
        item1.setItemPublishedDate(new Date());
                
        
        
        
        Item item2 =new Item();
        item2.setBlog(blogJavaIds);
        item2.setItemTitle("Second");
        item2.setItemLink("http://www.javavids.com");
        item2.setItemPublishedDate(new Date());
                
        itemDAO.createItem(item1);
        itemDAO.createItem(item2);
//        
//        
    }

}
