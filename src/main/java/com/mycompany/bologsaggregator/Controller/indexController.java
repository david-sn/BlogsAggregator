package com.mycompany.bologsaggregator.Controller;

import com.mycompany.bologsaggregator.Hibernate.DAO.UserDAO;
import com.mycompany.bologsaggregator.Hibernate.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

    @Autowired
    private UserDAO f;

    @RequestMapping(value = "/")
    public String index(Model m) {
        m.addAttribute("view", "home");
        return "layout/index";
    }

}
