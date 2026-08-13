package com.kratonsolution.belian.dashboard.identity;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class LandingPageController {

    private static final Map<String, ProviderPage> PROVIDERS = Map.of(
            "google", new ProviderPage(
                    "google",
                    "Google",
                    "Google Workspace",
                    "Use the company Google account connected to your organization."
            ),
            "facebook", new ProviderPage(
                    "facebook",
                    "Facebook",
                    "Facebook",
                    "Use the Facebook identity linked to your organization."
            ),
            "instagram", new ProviderPage(
                    "instagram",
                    "Instagram",
                    "Instagram Business",
                    "Use the professional Instagram account linked to your organization."
            )
    );

    @GetMapping("/")
    public String landingPage() {
        return "index";
    }

    @GetMapping("/login/work")
    public String workAccountLogin() {
        return "work-login";
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

    @GetMapping("/login/{provider:google|facebook|instagram}")
    public String providerLogin(@PathVariable String provider, Model model) {
        ProviderPage providerPage = PROVIDERS.get(provider);
        if (providerPage == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        model.addAttribute("provider", providerPage);
        return "provider-login";
    }

    public record ProviderPage(String id, String name, String title, String description) {
    }
}
