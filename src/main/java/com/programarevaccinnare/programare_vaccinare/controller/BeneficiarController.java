package com.programarevaccinnare.programare_vaccinare.controller;

import com.programarevaccinnare.programare_vaccinare.entity.*;
import com.programarevaccinnare.programare_vaccinare.facade.AuthenticationFacade;
import com.programarevaccinnare.programare_vaccinare.repository.GrupaRiscRepository;
import com.programarevaccinnare.programare_vaccinare.repository.JudetRepository;
import com.programarevaccinnare.programare_vaccinare.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    @Autowired
    JudetRepository judetRepository;

    @Autowired
    GrupaRiscRepository grupaRiscRepository;

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

    @GetMapping("/beneficiari/adaugare")
    public String adaugareBeneficiar(Model model){
        List<Judet> judete = judetRepository.findAll();
        List<GrupaRisc> grupeRisc = grupaRiscRepository.findAll();
        Beneficiar beneficiar = new Beneficiar();
        Judet judetSelectat = new Judet();
        model.addAttribute("beneficiar", beneficiar);
        model.addAttribute("judetSelectat", judetSelectat);
        model.addAttribute("judete", judete);
        model.addAttribute("grupeRisc", grupeRisc);

        return "main/adaugare";
    }

    @PostMapping("/beneficiari/adaugare/save")
    public String createNewBeneficiar(Beneficiar beneficiar){
        Authentication authentication = authenticationFacade.getAuthentication();
        Utilizator utilizator = utilizatorService.findUtilizatorByEmail(authentication.getName());
        beneficiar.setId_utilizator(utilizator.getId());
        beneficiarService.save(beneficiar);

        return "redirect:/home";
    }
}
