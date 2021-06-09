package com.programarevaccinnare.programare_vaccinare.service;

import com.programarevaccinnare.programare_vaccinare.entity.CentruVaccinare;
import com.programarevaccinnare.programare_vaccinare.repository.CentruVaccinareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentruVaccinareServiceImpl implements CentruVaccinareService{

    @Autowired
    CentruVaccinareRepository centruVaccinareRepository;

    @Override
    public List<CentruVaccinare> findCentruVaccinareById_oras(int id_oras) {
        return centruVaccinareRepository.findCentruVaccinareById_oras(id_oras);
    }
}
