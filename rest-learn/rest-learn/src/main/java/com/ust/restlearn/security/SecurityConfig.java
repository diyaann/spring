package com.ust.restlearn.security;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;


@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
		auth.inMemoryAuthentication() 
		.withUser("admin").password(passwordEncoder().encode("pwd")).roles("ADMIN") 
		.and() 
		.withUser("Ram").password(passwordEncoder().encode("pwd")).roles("USER"); 
		} 
		
		 @Bean 
		 public PasswordEncoder passwordEncoder() { 
		
		return new BCryptPasswordEncoder(); 
		} 
		 
		
	protected void configure(HttpSecurity httpSecurity) throws Exception { 
		httpSecurity.csrf().disable().httpBasic().and() 
		.authorizeRequests()
		//.antMatchers("/employees/dummy").hasRole("USER")
		.antMatchers("/authenticate").hasAnyRole("USER", "ADMIN")
		.anyRequest().authenticated() 

		.and() 

		.addFilter(new JwtAuthorizationFilter(authenticationManager()));
		} 


}
