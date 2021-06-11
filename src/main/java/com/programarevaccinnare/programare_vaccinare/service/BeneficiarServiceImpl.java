package com.programarevaccinnare.programare_vaccinare.service;

import com.programarevaccinnare.programare_vaccinare.entity.Beneficiar;
import com.programarevaccinnare.programare_vaccinare.repository.BeneficiarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiarServiceImpl implements BeneficiarService{

    @Autowired
    BeneficiarRepository beneficiarRepository;

    @Override
    public void save(Beneficiar beneficiar) {
        beneficiarRepository.save(beneficiar);
    }

    @Override
    public List<Beneficiar> findAll() {
        return beneficiarRepository.findAll();
    }

    @Override
    public List<Beneficiar> findBeneficiariById_utilizator(int id_utilizator) {
        return beneficiarRepository.findBeneficiariById_utilizator(id_utilizator);
    }

    @Override
    public Beneficiar findBeneficiarById(int id) {
        return beneficiarRepository.findBeneficiarById(id);
    }
}
