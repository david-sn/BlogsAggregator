package com.mycompany.bologsaggregator.Hibernate.DAO;

import com.mycompany.bologsaggregator.Hibernate.Entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.bologsaggregator.Hibernate.Entity.User;
import com.mycompany.bologsaggregator.Hibernate.Session.NewHibernateUtil;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Transactional
@Service
@Repository
public class UserDAO {

    public UserDAO() {
        System.out.println("Users-DAO");
    }

    @Autowired
    private NewHibernateUtil hibernateUtil;

    @Autowired
    private RoleDAO roleDAO;
    
    public int createUser(User user) {
        user.setUserEnable(true);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setUserPassword(encoder.encode(user.getUserPassword()));

        Set<Role> roles = new HashSet<Role>();
        roles.add(roleDAO.getRole(1));
        user.setRoles(roles);

        return (int) hibernateUtil.create(user);
    }

    public User updateUser(User user) {
        return hibernateUtil.update(user);
    }

    public void deleteUser(int id) {
        User user = new User();
        user.setUser_dbid(id);
        hibernateUtil.delete(user);
    }

    public List<User> getAllUsers() {
        return hibernateUtil.fetchAll(User.class);
    }

    public User getUser(int id) {
        return hibernateUtil.fetchById(id, User.class);
    }
     
    
    @SuppressWarnings("unchecked")
    public List<User> getUsersByName(String UserName) {
        List<User> usersObjects = hibernateUtil.getByName("userName",UserName,User.class);
        return usersObjects;
    }
}
