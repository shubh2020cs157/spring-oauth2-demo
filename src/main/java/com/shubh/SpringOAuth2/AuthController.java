package com.shubh.SpringOAuth2;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            
            if (principal instanceof OAuth2User oauth2User) {
                // Handle OAuth2 login
                model.addAttribute("name", oauth2User.getAttribute("name"));
                model.addAttribute("email", oauth2User.getAttribute("email"));
                model.addAttribute("login", oauth2User.getAttribute("login")); // For GitHub
                model.addAttribute("given_name", oauth2User.getAttribute("given_name")); // For Google/Microsoft
                model.addAttribute("family_name", oauth2User.getAttribute("family_name")); // For Google/Microsoft
                model.addAttribute("principal", oauth2User);
                model.addAttribute("attributes", oauth2User.getAttributes());
            } else if (principal instanceof UserDetails userDetails) {
                // Handle form login with default Spring Security user
                model.addAttribute("name", userDetails.getUsername());
                model.addAttribute("login", userDetails.getUsername());
                model.addAttribute("principal", userDetails);
                // For form login, attributes will be null, so we handle this in the template
            } else if (principal instanceof String) {
                // Handle the case where principal is a String (usually "anonymousUser")
                model.addAttribute("name", principal.toString());
                model.addAttribute("login", principal.toString());
                model.addAttribute("principal", principal);
            }
            
            // Add authentication information regardless of principal type
            model.addAttribute("isAuthenticated", authentication.isAuthenticated());
            model.addAttribute("authorities", authentication.getAuthorities());
        }
        
        return "home";
    }
}
