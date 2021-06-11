package com.programarevaccinnare.programare_vaccinare.service;

import com.programarevaccinnare.programare_vaccinare.entity.CentruVaccinare;

import java.util.List;

public interface CentruVaccinareService {
    public List<CentruVaccinare> findAll();
    public List<CentruVaccinare> findCentruVaccinareById_oras(int id_oras);
    public CentruVaccinare findCentruVaccinareById(int id);
}
