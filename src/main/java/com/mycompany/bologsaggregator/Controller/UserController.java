package com.mycompany.bologsaggregator.Controller;

import com.mycompany.bologsaggregator.Hibernate.DAO.BlogDAO;
import com.mycompany.bologsaggregator.Hibernate.DAO.UserDAO;
import com.mycompany.bologsaggregator.Hibernate.Entity.User;
import com.mycompany.bologsaggregator.Hibernate.Entity.Blog;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BlogDAO blogDAO;

    @RequestMapping(value = "users")
    public String users(Model m) {

        m.addAttribute("users", userDAO.getAllUsers());
        m.addAttribute("view", "users");

        return "layout/index";
    }

    @RequestMapping(value = "users/{id}")
    public String usersDetail(Model m, @PathVariable(name = "id") int id) {

        m.addAttribute("users", userDAO.getUser(id));
        m.addAttribute("view", "usersDetail");

        return "layout/index";
    }

    @ModelAttribute(binding = true, name = "userModel")
    public User userAttr() {
        return new User();
    }

    @ModelAttribute(binding = true, name = "blogModel")
    public Blog blogAttr() {
        return new Blog();
    }

    @RequestMapping(value = "/register")
    public String Register(Model m) {

        m.addAttribute("users", userDAO.getAllUsers());
        m.addAttribute("view", "userRegister");

        return "layout/index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String SumitRegister(Model m, @ModelAttribute("userModel") User user) {

        userDAO.createUser(user);

        m.addAttribute("view", "userRegister");

        return "layout/index";
    }

    @RequestMapping(value = "accout")
    public String accouts(Model m, Principal principal) {

        m.addAttribute("users", userDAO.getUsersByName(principal.getName()).get(0));
        m.addAttribute("view", "usersDetail");

        return "layout/index";
    }

    @RequestMapping(value = "/accout", method = RequestMethod.POST)
    public String SumitAccoutBlog(Model m, @ModelAttribute("blogModel") Blog blog,Principal principal) {

        blogDAO.createBlog(blog,principal.getName());

        m.addAttribute("view", "userRegister");

        return "layout/index";
    }
    
    
    
    @RequestMapping("/blog/remove/{id}")
    public String removeBlog(Model m,@PathVariable("id")int id)
    {
        blogDAO.deleteBlog(id);
        m.addAttribute("view", "usersDetail");
        return "layout/index";
    }
    
      @RequestMapping("/users/remove/{id}")
    public String removeUser(Model m,@PathVariable("id")int id)
    {
        userDAO.deleteUser(id);
        m.addAttribute("view", "users");
        return "layout/index";
    }
}
