package com.mycompany.bologsaggregator.Controller;

import com.mycompany.bologsaggregator.Hibernate.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "users")
    public String users(Model m) {

        m.addAttribute("users", userDAO.getAllUsers());
        m.addAttribute("view", "users");

        return "layout/index";
    }
    
    
    
    
    
     @RequestMapping(value = "users/{id}")
    public String usersDetail(Model m,@PathVariable(name = "id") int id) {

        m.addAttribute("users", userDAO.getUser(id));
        m.addAttribute("view", "usersDetail");

        return "layout/index";
    }
    

}
