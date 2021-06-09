package com.programarevaccinnare.programare_vaccinare.controller;

import com.programarevaccinnare.programare_vaccinare.entity.*;
import com.programarevaccinnare.programare_vaccinare.facade.AuthenticationFacade;
import com.programarevaccinnare.programare_vaccinare.repository.GrupaRiscRepository;
import com.programarevaccinnare.programare_vaccinare.repository.JudetRepository;
import com.programarevaccinnare.programare_vaccinare.service.AutoritateService;
import com.programarevaccinnare.programare_vaccinare.service.BeneficiarService;
import com.programarevaccinnare.programare_vaccinare.service.UtilizatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    AutoritateService autoritateService;

    @Autowired
    UtilizatorService utilizatorService;

    @Autowired
    BeneficiarService beneficiarService;

    @Autowired
    JudetRepository judetRepository;

    @Autowired
    GrupaRiscRepository grupaRiscRepository;

    @Autowired
    AuthenticationFacade authenticationFacade;

    @GetMapping("/profile")
    public String profile(Model model) {
        List<Judet> judete = judetRepository.findAll();
        List<GrupaRisc> grupeRisc = grupaRiscRepository.findAll();
        Beneficiar beneficiar = new Beneficiar();
        Judet judetSelectat = new Judet();
        model.addAttribute("beneficiar", beneficiar);
        model.addAttribute("judetSelectat", judetSelectat);
        model.addAttribute("judete", judete);
        model.addAttribute("grupeRisc", grupeRisc);

        return "main/profile";
    }

    @Transactional
    @PostMapping ("/profile/save")
    public String createNewProfile(Beneficiar beneficiar){
        Authentication authentication = authenticationFacade.getAuthentication();
        Utilizator u = utilizatorService.findUtilizatorByEmail(authentication.getName());
        beneficiar.setId_utilizator(u.getId());
        beneficiarService.save(beneficiar);
        Autoritate autoritate = new Autoritate(u.getId(), "PROFIL_CREAT");
        autoritateService.save(autoritate);
        List<GrantedAuthority> updatedAuthorities = new ArrayList<>(authentication.getAuthorities());
        updatedAuthorities.add(new SimpleGrantedAuthority(autoritate.getAutoritate()));

        Authentication newAuthentication = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), updatedAuthorities);
        SecurityContextHolder.getContext().setAuthentication(newAuthentication);

        return "redirect:/home";
    }
}
