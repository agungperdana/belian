package com.kratonsolution.belian.access.api.rest.user;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kratonsolution.belian.access.api.connector.UserServiceProxy;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserServiceProxy proxy;
	
	@GetMapping("/users/all-users")
	@RolesAllowed({"ROLE_USER_READ", "ROLE_USER_ADD", "ROLE_USER_EDIT", "ROLE_USER_DELETE", "ROLE_USER_PRINT"})
	public Map<String, Object> list() {
		
		Map<String, Object> map = new HashMap<>();
		
		try {
			
			map.put("status", true);
			map.put("result", proxy.getAllUsers());
			map.put("message", "success");			
		} 
		catch (Exception e) {
			
			map.put("status", false);
			map.put("message", e.getMessage());
		}
		
		return map;
	}
}
