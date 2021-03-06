package com.bank.management.internaldetails.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.bank.management.internaldetails.model.request.InternalDetailsRequest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenUtilJwt {
	public static final long JWT_TOKEN_VALIDITY = 1 * 3 * 100;
	private String secret="customer";
	
	public String generateToken(String username) 
	{
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, username);
	}

	private String doGenerateToken(Map<String, Object> claims, String subject)
	{
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	/*public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
		
		}
	
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
		}
	
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		}
	
	public Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
		}
	
	public Boolean validateToken(String token, InternalDetailsRequest userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUser_name()) && !isTokenExpired(token));
		}
	
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
		}*/
}
