package com.programarevaccinnare.programare_vaccinare.rest;

import com.programarevaccinnare.programare_vaccinare.entity.CentruVaccinare;
import com.programarevaccinnare.programare_vaccinare.service.CentruVaccinareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CentruVaccinareRestController {

    @Autowired
    CentruVaccinareService centruVaccinareService;

    @GetMapping("/api/centruVaccinareByIdOras/{id_oras}")
    public List<CentruVaccinare> findCentruVaccinareById_oras(@PathVariable int id_oras){
        return centruVaccinareService.findCentruVaccinareById_oras(id_oras);
    }
}
