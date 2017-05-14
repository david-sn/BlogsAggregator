package com.mycompany.bologsaggregator.Controller;

import com.mycompany.bologsaggregator.Hibernate.Entity.User;
import com.mycompany.bologsaggregator.Hibernate.Session.EmployeeDAOImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class indexController {

    @Autowired
    //@Qualifier("EmployeeDAOImpl")
    private EmployeeDAOImpl f;

    @RequestMapping(value = "/a")
    public String index(Model m) {
        m.addAttribute("view", "home");
        return "layout/index";
    }

    @RequestMapping(value = {"/"})
    public String getAllEmployees(Model m) {
        List<User> employeeList = f.getAllEmployees();
        m.addAttribute("employeeList",employeeList);
        return  "JSP/employeeList";
    }

}
