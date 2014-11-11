/**
 * 
 */
package com.kratonsolution.belian.security.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
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
	@Autowired
	private AuthenticationService userService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
			.antMatchers("/resources/**").permitAll()
			.antMatchers("/css/**").permitAll()
			.antMatchers("/js/**").permitAll()
			.anyRequest().authenticated();

		http.formLogin().failureUrl("/failur").loginPage("/login").permitAll()
			.and()
        	.logout().logoutUrl("/logout").permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception
	{
//		 Uncommend this for development only,its create static user/password for login into application
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USERS");
//		auth.authenticationProvider(authProvider());
	}
	
	@Bean
	public DaoAuthenticationProvider authProvider()
	{
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(new PasswordEncoderImpl());
		provider.setUserDetailsService(userService);
		
		return provider;
	}
}
