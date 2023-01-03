package com.kratonsolution.belian.security.access.user.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public class BelianReactiveGrantedAuthoritiesConverter implements Converter<Jwt, Flux<GrantedAuthority>> {

    @Override
    public Flux<GrantedAuthority> convert(Jwt jwt) {

        List<String> roles = (List<String>) jwt.getClaims().get("roles");

        if (roles == null || roles.isEmpty()) {
            return Flux.empty();
        }

        return Flux.fromIterable(roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
    }
}
