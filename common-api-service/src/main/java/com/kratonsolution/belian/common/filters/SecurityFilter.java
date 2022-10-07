package com.kratonsolution.belian.common.filters;

import com.google.common.base.Strings;
import com.google.common.net.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

public class SecurityFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

//        String authorization = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
//        if(Strings.isNullOrEmpty(authorization)) {
//            ServerHttpResponse res = exchange.getResponse();
//            res.setStatusCode(HttpStatus.FORBIDDEN);
//            return res.setComplete();
//        }

        return chain.filter(exchange);
    }
}
