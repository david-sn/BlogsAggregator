package com.mycompany.bologsaggregator.Hibernate.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
import com.mycompany.bologsaggregator.Hibernate.Entity.User;
import com.mycompany.bologsaggregator.Hibernate.Session.NewHibernateUtil;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
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

    public int createUser(User user) {
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

//    @SuppressWarnings("unchecked")
//    public List<User> getAllUsers(String employeeName) {
//        String query = "SELECT e.* FROM asd e WHERE e.name like '%" + employeeName + "%'";
//        List<Object[]> employeeObjects = hibernateUtil.fetchAll(query);
//        List<User> employees = new ArrayList<User>();
//        for (Object[] employeeObject : employeeObjects) {
//            User employee = new User();
//            long id = ((BigInteger) employeeObject[0]).longValue();
//            int age = (int) employeeObject[1];
//            String name = (String) employeeObject[2];
//            float salary = (float) employeeObject[3];
//            employee.setUser_dbid((int)id);
//            employee.setUserName(name);
//            
//            employees.add(employee);
//        }
//        System.out.println(employees);
//        return employees;
//    }
}
