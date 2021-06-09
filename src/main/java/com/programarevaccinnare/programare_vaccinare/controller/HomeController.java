package com.programarevaccinnare.programare_vaccinare.controller;

import com.programarevaccinnare.programare_vaccinare.entity.Beneficiar;
import com.programarevaccinnare.programare_vaccinare.entity.Utilizator;
import com.programarevaccinnare.programare_vaccinare.facade.AuthenticationFacade;
import com.programarevaccinnare.programare_vaccinare.service.BeneficiarService;
import com.programarevaccinnare.programare_vaccinare.service.UtilizatorService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    AuthenticationFacade authenticationFacade;

    @Autowired
    BeneficiarService beneficiarService;

    @Autowired
    UtilizatorService utilizatorService;

    @GetMapping(value = "/")
    public String index() {
        return homeRedirect();
    }

    @GetMapping("/home")
    public String home(Model model){
        Authentication authentication = authenticationFacade.getAuthentication();
        Utilizator u = utilizatorService.findUtilizatorByEmail(authentication.getName());
        List<Beneficiar> beneficiari = beneficiarService.findBeneficiariById_utilizator(u.getId());
        model.addAttribute("beneficiari", beneficiari);

        return "main/home";
    }

    private static boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || AnonymousAuthenticationToken.class.
                isAssignableFrom(authentication.getClass())) {
            return false;
        }
        return authentication.isAuthenticated();
    }

    @NotNull
    private String homeRedirect() {
        Authentication authentication = authenticationFacade.getAuthentication();
        if (isAuthenticated()){
            if (authentication.getAuthorities().stream().anyMatch( a -> a.getAuthority().equals("PROFIL_CREAT"))){
                return "redirect:/home";
            }
            else if (authentication.getAuthorities().stream().anyMatch( a -> a.getAuthority().equals("UTILIZATOR_CREAT"))){
                return "redirect:/profile";
            }
        }
        return "redirect:/login";
    }
}
