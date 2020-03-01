package com.kratonsolution.belian.backoffice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
@Controller
public class Landing {
    
    @RequestMapping("/")
    public String landing() {
        return "redirect:/secure/login";
    }
}
