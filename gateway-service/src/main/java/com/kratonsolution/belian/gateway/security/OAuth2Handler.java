package com.kratonsolution.belian.gateway.security;

import com.google.gson.Gson;
import com.kratonsolution.belian.gateway.rest.UserRestResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@AllArgsConstructor
public class OAuth2Handler {

    public Mono<ServerHttpRequest> handle(OAuth2AuthenticationToken token, ServerWebExchange exchange) {

        Mono<UserRestResponse> result = WebClient.create()
                .get()
                .uri(URI.create("http://localhost:8582/api/v2/user/detail/"+token.getPrincipal().getAttributes().get("email").toString()))
                .header(HttpHeaders.AUTHORIZATION, token.toString())
                .retrieve()
                .bodyToMono(UserRestResponse.class).defaultIfEmpty(new UserRestResponse())
                .flatMap(json->{

                    if(!json.isSuccess()) {

                        log.info("User with email {} not found, register new user", token.getPrincipal().getAttributes().get("email"));

                        Map<String, Object> user = new HashMap<>();
                        user.put("name", token.getPrincipal().getAttributes().get("name"));
                        user.put("email", token.getPrincipal().getAttributes().get("email"));
                        user.put("source", "google");
                        user.put("enabled", true);

                        return WebClient.create()
                                .post()
                                .uri(URI.create("http://localhost:8582/api/v2/users"))
                                .header(HttpHeaders.AUTHORIZATION, token.toString())
                                .header(HttpHeaders.CONTENT_TYPE, "application/json")
                                .bodyValue(new Gson().toJson(user))
                                .retrieve()
                                .bodyToMono(UserRestResponse.class).defaultIfEmpty(new UserRestResponse());
                    }

                    return Mono.just(json);
                });

        result.subscribe(x->log.info("Result {}", new Gson().toJson(x.getUser())));

        return result.map(map->exchange.getRequest().mutate().header(HttpHeaders.AUTHORIZATION, JWTTokenUtil.encode(new Gson().toJson(map.getUser()), 1000)).build());
    }
}
