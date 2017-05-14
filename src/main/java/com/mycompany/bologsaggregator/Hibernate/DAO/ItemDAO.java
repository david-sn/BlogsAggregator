package com.mycompany.bologsaggregator.Hibernate.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.bologsaggregator.Hibernate.Entity.Item;
import com.mycompany.bologsaggregator.Hibernate.Session.NewHibernateUtil;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Transactional
@Service
@Repository
public class ItemDAO {

    public ItemDAO() {
        System.out.println("Item-DAO-Impl");
    }

    @Autowired
    private NewHibernateUtil hibernateUtil;

    public int createItem(Item item) {
        return (int) hibernateUtil.create(item);
    }

    public Item updateItem(Item item) {
        return hibernateUtil.update(item);
    }

    public void deleteItem(int id) {
        Item item = new Item();
        item.setItem_dbid(id);
        hibernateUtil.delete(item);
    }

    public List<Item> getAllItems() {
        return hibernateUtil.fetchAll(Item.class);
    }

    public Item getItem(int id) {
        return hibernateUtil.fetchById(id, Item.class);
    }

//    @SuppressWarnings("unchecked")
//    public List<Item> getAllItems(String employeeName) {
//        String query = "SELECT e.* FROM asd e WHERE e.name like '%" + employeeName + "%'";
//        List<Object[]> employeeObjects = hibernateUtil.fetchAll(query);
//        List<Item> employees = new ArrayList<Item>();
//        for (Object[] employeeObject : employeeObjects) {
//            Item employee = new Item();
//            long id = ((BigInteger) employeeObject[0]).longValue();
//            int age = (int) employeeObject[1];
//            String name = (String) employeeObject[2];
//            float salary = (float) employeeObject[3];
//            employee.setItem_dbid((int) id);
//            employee.setItemName(name);
//
//            employees.add(employee);
//        }
//        System.out.println(employees);
//        return employees;
//    }
}
