package com.programarevaccinnare.programare_vaccinare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    private final static String ERROR_PATH = "/error";

    @GetMapping(ERROR_PATH)
    public String error(){
        return "redirect:/";
    }
}
