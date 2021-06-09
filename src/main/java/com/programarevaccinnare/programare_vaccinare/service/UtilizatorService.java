package com.programarevaccinnare.programare_vaccinare.service;

import com.programarevaccinnare.programare_vaccinare.entity.Utilizator;

import java.util.List;

public interface UtilizatorService {
    public void save(Utilizator user);

    public List<Utilizator> findAll();

    public Utilizator findUtilizatorByEmail(String email);
}
