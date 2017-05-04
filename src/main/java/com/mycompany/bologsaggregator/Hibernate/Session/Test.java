/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bologsaggregator.Hibernate.Session;

import com.mycompany.bologsaggregator.Hibernate.Entity.User;
import org.hibernate.Session;

/**
 *
 * @author David Shire
 */
public class Test {
    
    public static void main(String[] args) {

        Session s=NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        User u=new User();
        s.save(u);
        s.getTransaction().commit();
        
        
    }
    
    
    
    
}
