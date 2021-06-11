package com.programarevaccinnare.programare_vaccinare.controller;

import com.programarevaccinnare.programare_vaccinare.entity.Beneficiar;
import com.programarevaccinnare.programare_vaccinare.entity.Oras;
import com.programarevaccinnare.programare_vaccinare.entity.Programare;
import com.programarevaccinnare.programare_vaccinare.entity.Utilizator;
import com.programarevaccinnare.programare_vaccinare.facade.AuthenticationFacade;
import com.programarevaccinnare.programare_vaccinare.repository.CentruVaccinareRepository;
import com.programarevaccinnare.programare_vaccinare.service.BeneficiarService;
import com.programarevaccinnare.programare_vaccinare.service.OrasService;
import com.programarevaccinnare.programare_vaccinare.service.ProgramareService;
import com.programarevaccinnare.programare_vaccinare.service.UtilizatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProgramareController {

    @Autowired
    CentruVaccinareRepository centruVaccinareRepository;

    @Autowired
    OrasService orasService;

    @Autowired
    BeneficiarService beneficiarService;

    @Autowired
    AuthenticationFacade authenticationFacade;

    @Autowired
    UtilizatorService utilizatorService;

    @Autowired
    ProgramareService programareService;

    @GetMapping("/programare")
    public String programare(Model model){
        Programare programare = new Programare();
        Authentication authentication = authenticationFacade.getAuthentication();
        Utilizator u = utilizatorService.findUtilizatorByEmail(authentication.getName());
        List<Beneficiar> beneficiari = beneficiarService.findBeneficiariById_utilizator(u.getId());
        List<Oras> orase = orasService.findAll();
        model.addAttribute("beneficiari", beneficiari);
        model.addAttribute("orase", orase);
        model.addAttribute("programare", programare);
        return "main/programare";
    }

    @PostMapping("/programare/save")
    public String createNewProgramare(Programare programare){
        programareService.save(programare);
        return "redirect:/home";
    }

    @RequestMapping(value="/programare/anulare/{id}", method=RequestMethod.POST)
    public String deleteProgramare(@PathVariable("id") int id){
        programareService.deleteProgramareById(id);
        return "redirect:/beneficiari";
    }
}
