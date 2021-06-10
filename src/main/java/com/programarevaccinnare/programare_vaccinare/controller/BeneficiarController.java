package com.programarevaccinnare.programare_vaccinare.controller;

import com.programarevaccinnare.programare_vaccinare.entity.*;
import com.programarevaccinnare.programare_vaccinare.facade.AuthenticationFacade;
import com.programarevaccinnare.programare_vaccinare.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class BeneficiarController {

    @Autowired
    BeneficiarService beneficiarService;

    @Autowired
    ProgramareService programareService;

    @Autowired
    AuthenticationFacade authenticationFacade;

    @Autowired
    UtilizatorService utilizatorService;

    @Autowired
    CentruVaccinareService centruVaccinareService;

    @Autowired
    OrasService orasService;

    @GetMapping("/beneficiari")
    public String vizualizareBeneficiari(Model model){
        Authentication authentication = authenticationFacade.getAuthentication();
        Utilizator u = utilizatorService.findUtilizatorByEmail(authentication.getName());
        List<Beneficiar> beneficiari = beneficiarService.findBeneficiariById_utilizator(u.getId());
        List<Programare> programari = new ArrayList<Programare>();
        List<CentruVaccinare> centreVaccinare = centruVaccinareService.findAll();
        List<Oras> orase = orasService.findAll();

        Iterator<Beneficiar> iterator = beneficiari.iterator();
        while(iterator.hasNext()){
            programari.add(programareService.findProgramareById_beneficiar(iterator.next().getId()));
        }

        model.addAttribute("beneficiari", beneficiari);
        model.addAttribute("programari", programari);
        model.addAttribute("centre_vaccinare", centreVaccinare);
        model.addAttribute("orase", orase);
        return "main/vizualizare";
    }
}
