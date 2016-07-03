/**
 * 
 */
package com.kratonsolution.belian.security.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true,proxyTargetClass=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
	@Autowired
	private AuthenticationService userService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
			.antMatchers("/resources/**").permitAll()
			.antMatchers("/fonts/**").permitAll()
			.antMatchers("/css/**").permitAll()
			.antMatchers("/images/**").permitAll()
			.antMatchers("/js/**").permitAll()
			.anyRequest().authenticated();

		http.formLogin().failureUrl("/login").loginPage("/login").permitAll()
			.and()
        	.logout().logoutUrl("/logout").permitAll();
		
		http.csrf().disable();
		http.headers().frameOptions().sameOrigin();
//		http.headers().addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsMode.SAMEORIGIN));
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception
	{
//		 Uncommend this for development only,its create static user/password for login into application
//		auth.inMemoryAuthentication()
//			.withUser("user")
//			.password("password")
//			.roles("RLE_READ","RLE_CREATE","RLE_UPDATE","RLE_DELETE",
//					"MODULE_READ","MODULE_CREATE","MODULE_UPDATE","MODULE_DELETE",
//					"USER_READ","USER_CREATE","USER_UPDATE","USER_CREATE","USER_DELETE");
		auth.authenticationProvider(authProvider());
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
