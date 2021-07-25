package com.kratonsolution.belian.access.api.rest.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kratonsolution.belian.security.jwt.JWTTokenUtil;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@RestController
@CrossOrigin
public class LoginController {
	
	@Autowired
	private AuthenticationManager manager;
	
	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody LoginData login) {
		
		Map<String, Object> map = new HashMap<>();
		
		try {
			
			Authentication auth = manager.authenticate(
									new UsernamePasswordAuthenticationToken(
											login.getUsername(), login.getPassword()));
			
			if(auth.isAuthenticated()) {
				
				map.put("status", true);
				map.put("token", JWTTokenUtil.encode(login.getUsername()));
				map.put("message", "success");
			}
			else {
				
				map.put("status", false);
				map.put("message", "login failed, username/password not match");
			}
			
		} catch (Exception e) {

			map.put("status", false);
			map.put("message", e.getMessage());
		}
		
		return map;
	}
}
