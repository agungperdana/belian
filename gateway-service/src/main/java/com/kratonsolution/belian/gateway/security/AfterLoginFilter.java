package com.kratonsolution.belian.gateway.security;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@AllArgsConstructor
public class AfterLoginFilter implements GlobalFilter {

    private OAuth2Handler oAuth2Handler;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        return exchange.getPrincipal().flatMap(principal -> {

            if(principal instanceof OAuth2AuthenticationToken) {

                OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) principal;
                String email = token.getPrincipal().getAttributes().get("email").toString();

                log.info("Logged In user email {}", email);

                return oAuth2Handler.handle(token, exchange)
                                    .flatMap(request->chain.filter(exchange.mutate().request(request).build()));
            }

            return chain.filter(exchange);
        });
    }
}
