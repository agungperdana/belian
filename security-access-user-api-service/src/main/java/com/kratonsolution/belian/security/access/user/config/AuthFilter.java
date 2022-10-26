package com.kratonsolution.belian.security.access.user.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class AuthFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        exchange.getPrincipal().subscribe(p->log.info("Principal {}", p));
        log.info("Bearer {}", exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION));
        log.info("Bearer {}", exchange.getRequest().getHeaders().get(HttpHeaders.PROXY_AUTHORIZATION));

        return chain.filter(exchange);
    }
}
