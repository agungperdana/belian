package com.kratonsolution.belian.gateway.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class HomeController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping
    public Map<String, Object> ok(OAuth2AuthenticationToken token) {
        return token.getPrincipal().getAttributes();
    }

    @RequestMapping("redirect/{registrationId}")
    public String redirect(@PathVariable String registrationId) {
        log.info("Registration {}", registrationId);
        return registrationId;
    }
}
