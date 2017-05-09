

package com.mycompany.bologsaggregator.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 

public class indexController {
    
    
    
    
   @RequestMapping(value = "/")
    public String index(Model m)
    {
        m.addAttribute("view","home");
        return "JSP/index";
    }
    
    
    
    
    
}
