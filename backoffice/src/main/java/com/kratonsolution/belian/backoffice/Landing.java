package com.kratonsolution.belian.backoffice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
@Controller
public class Landing {
    
    @GetMapping(name = "/")
    public String landing() {
        return "redirect:/login";
    }
    
    @GetMapping("/login")
    public String showLogin() {
    	return "login";
    }
}
