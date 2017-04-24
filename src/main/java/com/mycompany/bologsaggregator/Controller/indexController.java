

package com.mycompany.bologsaggregator.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class indexController {
    
    
    
    
    @RequestMapping(value = "/start")
    public org.springframework.web.servlet.ModelAndView mod()
    {
        org.springframework.web.servlet.ModelAndView modelAndView =new org.springframework.web.servlet.ModelAndView("start");
        modelAndView.addObject("s","My Msg");
        return modelAndView;
    }
    
    
    
    
    
}
