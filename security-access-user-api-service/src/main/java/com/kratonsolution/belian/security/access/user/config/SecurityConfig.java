package com.kratonsolution.belian.security.access.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverter;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securingResource(ServerHttpSecurity http) {

        ReactiveJwtAuthenticationConverter converter = new ReactiveJwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(new BelianReactiveGrantedAuthoritiesConverter());

        http.authorizeExchange()
                .pathMatchers("/auth/**").permitAll()
                .pathMatchers("/**").authenticated()
                .pathMatchers("/**").hasAnyRole("USER_READ", "USER_ADD", "USER_EDIT", "USER_DELETE", "USER_PRINT")
                .and()
                .oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(converter);

        return http.build();
    }
}
