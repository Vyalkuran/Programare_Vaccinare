package com.programarevaccinnare.programare_vaccinare.service;

import com.programarevaccinnare.programare_vaccinare.entity.Utilizator;
import com.programarevaccinnare.programare_vaccinare.repository.UtilizatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilizatorServiceImpl implements UtilizatorService{

    @Autowired
    UtilizatorRepository utilizatorRepository;

    @Override
    public void save(Utilizator utilizator) {
        utilizatorRepository.save(utilizator);
    }

    @Override
    public List<Utilizator> findAll() {
        return utilizatorRepository.findAll();
    }

    @Override
    public Utilizator findUtilizatorByEmail(String email) {
        return utilizatorRepository.findUtilizatorByEmail(email);
    }
}
