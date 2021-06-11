package com.programarevaccinnare.programare_vaccinare.service;

import com.programarevaccinnare.programare_vaccinare.entity.Beneficiar;

import java.util.List;

public interface BeneficiarService {
    public void save(Beneficiar beneficiar);

    public List<Beneficiar> findAll();

    public List<Beneficiar> findBeneficiariById_utilizator(int id_utilizator);

    public Beneficiar findBeneficiarById(int id);
}
