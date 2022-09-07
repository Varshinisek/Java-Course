package com.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
@SuppressWarnings("deprecation")
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication() 
		.withUser("Varshini").password("Varshini@123").roles("SALESPERSON")
		  .and()
		 .withUser("Kanika").password("Kanika@123").roles("Clerk"); 
	}

	@Bean
	  PasswordEncoder getPasswordEncoder() { 
		  return   NoOpPasswordEncoder.getInstance(); 
	  
	  } 
}
