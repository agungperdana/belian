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

	public static String encode(String jsonUser, long expiredTime) {

		Date exp = new Date(expiredTime);

		Claims claims = Jwts.claims()
				.setSubject(jsonUser)
				.setExpiration(exp)
				.setIssuedAt(new Date())
				.setIssuer("www.kratonsolution.com");

		return Jwts.builder().setClaims(claims).signWith(KEY, SignatureAlgorithm.HS512).compact();
	}

	public static Claims decode(String jwt) {

		return Jwts.parserBuilder()
				.setSigningKey(KEY)
				.build()
				.parseClaimsJws(jwt)
				.getBody();
	}

	public static Optional<String> getUserName(String token) {

		Claims claim = decode(token);
		if(claim != null) {
			return Optional.of(claim.getSubject());
		}

		return Optional.empty();
	}

	public static Boolean isTokenExpired(String token) {
		
		Claims claims = decode(token);
		if(claims != null) {
			
			return claims.getExpiration().compareTo(new Date()) < 0;
		}
		
		return true;
	}
}
