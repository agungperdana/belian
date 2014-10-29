/**
 * 
 */
package com.kratonsolution.belian.global;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

/**
 * @author agungdodiperdana
 *
 */
@Configuration
@EnableWebMvcSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests().anyRequest().authenticated();
		http.formLogin().failureUrl("/failur").loginPage("/login").permitAll()
			.and()
        	.logout().logoutUrl("/logout").permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception
	{
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USERS");
	}
}
