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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
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

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
    Calendar dataProgramare;

    @GetMapping("/programare")
    public String programare(Model model){
        dataProgramare = new GregorianCalendar();
        Programare programare = new Programare();
        Authentication authentication = authenticationFacade.getAuthentication();
        Utilizator u = utilizatorService.findUtilizatorByEmail(authentication.getName());
        List<Beneficiar> beneficiari = beneficiarService.findBeneficiariById_utilizator(u.getId());
        List<Oras> orase = orasService.findAll();
        model.addAttribute("beneficiari", beneficiari);
        model.addAttribute("orase", orase);
        model.addAttribute("programare", programare);
        model.addAttribute("dataProgramare", dataProgramare);
        return "main/programare";
    }

    @PostMapping("/programare/save")
    public String createNewProgramare(Programare programare, Model model){
        dataProgramare = (Calendar) model.getAttribute("dataProgramare");
        assert dataProgramare != null;
        programare.setData_an(dataProgramare.get(Calendar.YEAR));
        programare.setData_luna(dataProgramare.get(Calendar.MONTH));
        programare.setData_zi(dataProgramare.get(Calendar.DAY_OF_MONTH));
        String ziuaText = new SimpleDateFormat("EEEE").format(dataProgramare);
        programare.setZiua(ziuaText);
        programareService.save(programare);
        return "redirect:/home";
    }
}
