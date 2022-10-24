package com.kratonsolution.belian.gateway.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin({"http://localhost:8580", "http://localhost:8581"})
@RestController
@RequestMapping("/")
public class HomeController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping
    public String ok(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient client) {

        log.info("client boy" + client);
        return "ok coy";
    }
}
