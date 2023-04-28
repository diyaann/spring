package com.ust.restlearn.controller;


import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.JwtBuilder; 

import io.jsonwebtoken.Jwts; 

import io.jsonwebtoken.SignatureAlgorithm; 

@RestController
public class AuthenticationController {
	
	@GetMapping("/authenticate")
	public Map<String,String> authenticate(@RequestHeader("Authorization") String authHeader){
		
		Map<String,String> map = new HashMap();
		String user = getUser(authHeader);
		String token = generateJwt(user);
		
		map.put("key", token);
		
		return map;
	}
	
	
	private String getUser(String authHeader) {
		  
		  
		  System.out.println("authheader: "+authHeader); 
		  String encodedCredentials =  authHeader.substring(6);
		  
		  System.out.println("encoded: "+encodedCredentials);
		  
		  String decoded = new String(Base64.getDecoder().decode(encodedCredentials));
		  
		  System.out.println("decoded: "+decoded);
		  
		  String user = null;
		  
		  int index =decoded.indexOf(":");
		  
		  user = decoded.substring(0, index);
		  
		  System.out.println("user: "+user);
		  
		  return user;
		  
		  }
	
	private String generateJwt(String user) {
		  
		  JwtBuilder builder = Jwts.builder();
		  
		  builder.setSubject(user);
		  
		  builder.setIssuedAt(new Date());
		  
		  builder.setExpiration(new Date((new Date()).getTime() + 1200000));
		  
		  builder.signWith(SignatureAlgorithm.HS256, "secretkey");
		  
		  String token = builder.compact();
		  
		  return token;
		  
		  
		  
		  }
	

}
