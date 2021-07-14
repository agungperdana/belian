package com.kratonsolution.belian.security.jwt;

import java.security.Key;
import java.util.Date;
import java.util.Optional;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0.0
 */
public class JWTTokenUtil {

	private static final Key KEY = Keys.hmacShaKeyFor(JWTConstant.KEY.getBytes());

	public static String encode(String jsonUser) {

		Date exp = new Date(System.currentTimeMillis() + JWTConstant.EXPIRED);

		Claims claims = Jwts.claims()
				.setSubject(jsonUser)
				.setExpiration(exp)
				.setIssuedAt(new Date())
				.setIssuer("www.kratonsolution.com");

		String token = Jwts.builder().setClaims(claims).signWith(KEY, SignatureAlgorithm.HS512).compact();

		return token;
	}

	public static Claims decode(String jwt) {

		Claims claims = Jwts.parserBuilder()
				.setSigningKey(KEY)
				.build()
				.parseClaimsJws(jwt)
				.getBody();

		return claims;
	}

	public static Optional<String> getUserName(String token) {

		Claims claim = decode(token);
		if(claim != null) {
			return Optional.of(claim.getSubject());
		}

		return Optional.ofNullable(null);
	}

	public static Boolean isTokenExpired(String token) {
		
		Claims claims = decode(token);
		if(claims != null) {
			
			return claims.getExpiration().compareTo(new Date()) < 0;
		}
		
		return true;
	}
}
