package com.kratonsolution.belian.security.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.PathPatternRequestMatcher;

import lombok.AllArgsConstructor;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 */
@AllArgsConstructor
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled=true, proxyTargetClass=true)
public class SecurityConfiguration
{
	private AuthenticationService userService;

	private SuccessHandler successHandler;

	@Bean
	protected SecurityFilterChain configure(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests(req -> req.requestMatchers(PathPatternRequestMatcher.withDefaults().matcher("/resources/**")).permitAll()
						.requestMatchers(PathPatternRequestMatcher.withDefaults().matcher("/fonts/**")).permitAll()
						.requestMatchers(PathPatternRequestMatcher.withDefaults().matcher("/css/**")).permitAll()
						.requestMatchers(PathPatternRequestMatcher.withDefaults().matcher("/js/**")).permitAll()
						.anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/login").permitAll().successHandler(successHandler))
				.logout(log->log.logoutUrl("/logout").permitAll())
				.csrf(csrf->csrf.disable())
				.headers(headers->headers.frameOptions(frame->frame.sameOrigin()));

		return http.build();
	}

	@Bean
	public DaoAuthenticationProvider authProvider()
	{
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userService);
		provider.setPasswordEncoder(new PasswordEncoderImpl());

		return provider;
	}
}
