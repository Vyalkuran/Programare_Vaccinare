package com.programarevaccinnare.programare_vaccinare.controller;

import com.programarevaccinnare.programare_vaccinare.entity.Autoritate;
import com.programarevaccinnare.programare_vaccinare.entity.Utilizator;
import com.programarevaccinnare.programare_vaccinare.service.AutoritateService;
import com.programarevaccinnare.programare_vaccinare.service.UtilizatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {

    @Autowired
    UtilizatorService utilizatorService;

    @Autowired
    AutoritateService autoritateService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/register")
    public String register(Model model){
        Utilizator utilizator = new Utilizator();
        model.addAttribute("utilizator", utilizator);
        return "security/register";
    }

    @PostMapping("/register/save")
    public String saveUser(Utilizator utilizator) {
        utilizator.setParola(bCryptPasswordEncoder.encode(utilizator.getParola()));
        utilizatorService.save(utilizator);
        Autoritate auth = new Autoritate(utilizator.getId(), "UTILIZATOR_CREAT");
        autoritateService.save(auth);

        return "redirect:/login";
    }
}
