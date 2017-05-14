package com.mycompany.bologsaggregator.Hibernate.Session;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
import com.mycompany.bologsaggregator.Hibernate.Entity.User;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Transactional
@Service
@Repository
public class EmployeeDAOImpl {

    public EmployeeDAOImpl() {
        System.out.println("EmployeeDAOImpl");
    }

    @Autowired
    private NewHibernateUtil hibernateUtil;

    public long createEmployee(User employee) {
        return (Long) hibernateUtil.create(employee);
    }

    public User updateEmployee(User employee) {
        return hibernateUtil.update(employee);
    }

    public void deleteEmployee(long id) {
        User employee = new User();
        employee.setUser_dbid((int)id);
        hibernateUtil.delete(employee);
    }

    public List<User> getAllEmployees() {
        return hibernateUtil.fetchAll(User.class);
    }

    public User getEmployee(long id) {
        return hibernateUtil.fetchById(id, User.class);
    }

    @SuppressWarnings("unchecked")
    public List<User> getAllEmployees(String employeeName) {
        String query = "SELECT e.* FROM asd e WHERE e.name like '%" + employeeName + "%'";
        List<Object[]> employeeObjects = hibernateUtil.fetchAll(query);
        List<User> employees = new ArrayList<User>();
        for (Object[] employeeObject : employeeObjects) {
            User employee = new User();
            long id = ((BigInteger) employeeObject[0]).longValue();
            int age = (int) employeeObject[1];
            String name = (String) employeeObject[2];
            float salary = (float) employeeObject[3];
            employee.setUser_dbid((int)id);
            employee.setUserName(name);
            
            employees.add(employee);
        }
        System.out.println(employees);
        return employees;
    }
}
