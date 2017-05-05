/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bologsaggregator.Hibernate.Session;

import com.mycompany.bologsaggregator.Hibernate.Entity.Blog;
import com.mycompany.bologsaggregator.Hibernate.Entity.Item;
import com.mycompany.bologsaggregator.Hibernate.Entity.User;
import com.mycompany.bologsaggregator.Hibernate.Entity.Role;
import org.hibernate.Session;

/**
 *
 * @author David Shire
 */
public class Test {

    public static void main(String[] args) {

        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();

        User u1 = new User();
        u1.setUserName("david");
        User u2 = new User();
        u2.setUserName("shiref");

        Role r1 = new Role();
      
        u1.getRoles().add(r1);
        r1.getUsers().add(u1);
        

        s.save(u1);
        s.save(u2);
        s.save(r1);
        s.getTransaction().commit();

    }

}
