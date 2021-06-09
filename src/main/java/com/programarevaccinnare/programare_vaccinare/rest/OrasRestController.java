package com.programarevaccinnare.programare_vaccinare.rest;

import com.programarevaccinnare.programare_vaccinare.entity.Oras;
import com.programarevaccinnare.programare_vaccinare.service.OrasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrasRestController {

    @Autowired
    private OrasService orasService;

    @GetMapping("/oraseByJudet/{id_judet}")
    public List<Oras> findOraseById_judet(@PathVariable int id_judet){
        return orasService.findOraseById_judet(id_judet);
    }
}
