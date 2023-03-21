package com.kratonsolution.belian.security.impl.app;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 */
@AllArgsConstructor
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true,proxyTargetClass=true)
public class SecurityConfiguration
{
	private AuthenticationService userService;

	private SuccessHandler successHandler;

	@Bean
	protected SecurityFilterChain configure(HttpSecurity http) throws Exception
	{
		http.csrf().disable().authorizeRequests()
				.requestMatchers("/resources/**","/fonts/**","/css/**","/js/**").permitAll()
				.anyRequest().authenticated();

		http.formLogin().failureUrl("/login").loginPage("/login").permitAll()
			.successHandler(successHandler)
			.and()
        	.logout().logoutUrl("/logout").permitAll();
		
		http.csrf().disable();
		http.headers().frameOptions().sameOrigin();

		return http.build();
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
