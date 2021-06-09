package com.programarevaccinnare.programare_vaccinare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProgramareController {

    @GetMapping("/programare")
    public String programare(Model model){
        return null;
    }

    @PostMapping("/programare/save")
    public String createNewProgramare(){
        return null;
    }
}
