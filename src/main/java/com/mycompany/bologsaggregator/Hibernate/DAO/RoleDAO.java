package com.mycompany.bologsaggregator.Hibernate.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.bologsaggregator.Hibernate.Entity.Role;
import com.mycompany.bologsaggregator.Hibernate.Session.NewHibernateUtil;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Transactional
@Service
@Repository
public class RoleDAO {

    public RoleDAO() {
        System.out.println("Role-DAO");
    }

    @Autowired
    private NewHibernateUtil hibernateUtil;

    public int createRole(Role role) {
        return (int) hibernateUtil.create(role);
    }

    public Role updateRole(Role role) {
        return hibernateUtil.update(role);
    }

    public void deleteRole(int id) {
        Role role = new Role();
        role.setRole_dbid (id);
        hibernateUtil.delete(role);
    }

    public List<Role> getAllRoles() {
        return hibernateUtil.fetchAll(Role.class);
    }

    public Role getRole(int id) {
        return hibernateUtil.fetchById(id, Role.class);
    }

//    @SuppressWarnings("unchecked")
//    public List<Role> getAllRoles(String employeeName) {
//        String query = "SELECT e.* FROM asd e WHERE e.name like '%" + employeeName + "%'";
//        List<Object[]> employeeObjects = hibernateUtil.fetchAll(query);
//        List<Role> employees = new ArrayList<Role>();
//        for (Object[] employeeObject : employeeObjects) {
//            Role employee = new Role();
//            long id = ((BigInteger) employeeObject[0]).longValue();
//            int age = (int) employeeObject[1];
//            String name = (String) employeeObject[2];
//            float salary = (float) employeeObject[3];
//            employee.setRole_dbid((int) id);
//            employee.setRoleName(name);
//
//            employees.add(employee);
//        }
//        System.out.println(employees);
//        return employees;
//    }
}
