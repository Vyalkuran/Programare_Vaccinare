package com.programarevaccinnare.programare_vaccinare.controller;

import com.programarevaccinnare.programare_vaccinare.email.Email;
import com.programarevaccinnare.programare_vaccinare.email.MailSender;
import com.programarevaccinnare.programare_vaccinare.email.SMTPEmailProvider;
import com.programarevaccinnare.programare_vaccinare.entity.*;
import com.programarevaccinnare.programare_vaccinare.facade.AuthenticationFacade;
import com.programarevaccinnare.programare_vaccinare.repository.CentruVaccinareRepository;
import com.programarevaccinnare.programare_vaccinare.service.*;
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

    @Autowired
    CentruVaccinareService centruVaccinareService;

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

        sendEmailProgramare(programare);
        programareService.save(programare);
        return "redirect:/home";
    }

    @RequestMapping(value="/programare/anulare/{id}", method=RequestMethod.POST)
    public String deleteProgramare(@PathVariable("id") int id){
        programareService.deleteProgramareById(id);
        return "redirect:/beneficiari";
    }

    private void sendEmailProgramare(Programare programare) {
        Beneficiar beneficiar = beneficiarService.findBeneficiarById(programare.getId_beneficiar());
        CentruVaccinare centruVaccinare = centruVaccinareService.findCentruVaccinareById(programare.getId_centru());
        MailSender sender = new MailSender(new SMTPEmailProvider());
        Email email = Email.getInstance();
        email.setTo(beneficiar.getEmail());
        email.setSubject("Inregistrare programare");
        email.setBody("La data " + programare.getData_programare().getTime() + " beneficiarul " + beneficiar.getNume() + " " + beneficiar.getPrenume() + " s-a programat la vaccinare "
                + " la centrul de vaccinare " + centruVaccinare.getDenumire_centru_vaccinare());
        email.setCc("");
        sender.sendEmail(email);
    }
}
