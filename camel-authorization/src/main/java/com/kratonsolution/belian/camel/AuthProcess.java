package com.kratonsolution.belian.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.kratonsolution.belian.security.jwt.JWTTokenUtil;

import io.jsonwebtoken.Claims;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0.0
 */
@Slf4j
public class AuthProcess implements Processor {

	private String role;
	
	AuthProcess(){}
	
	public AuthProcess(String role) {
		this.role = role;
	}
	
	public static AuthProcess forRole(@NonNull String role) {
		return new AuthProcess(role);
	}
	
	@Override
	public void process(Exchange exchange) throws Exception {
		
		String token = exchange.getIn().getHeader("Authorization", String.class);
				
		if(Strings.isNullOrEmpty(token)) {
			throw new AccessDeniedException();
		}
		
		Claims claims = JWTTokenUtil.decode(token.split(" ")[1]);
		if(claims == null || Strings.isNullOrEmpty(claims.getSubject())) {
			throw new AccessDeniedException();
		}
		
		User user = new Gson().fromJson(claims.getSubject(), User.class);
		if(user != null) {
			boolean hasRole = user.getRoles().stream().anyMatch(role->role.getName().equalsIgnoreCase(this.role));
			if(!hasRole) {
				throw new AccessDeniedException();
			}				
		}
		
		log.info("User access granted ...");
	}
}
