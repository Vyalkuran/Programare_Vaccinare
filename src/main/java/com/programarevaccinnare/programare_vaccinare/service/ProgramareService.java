package com.programarevaccinnare.programare_vaccinare.service;

import com.programarevaccinnare.programare_vaccinare.entity.Programare;

public interface ProgramareService {

    public void save(Programare programare);

    public Programare findProgramareById_beneficiar(int id_beneficiar);

    public void deleteProgramareById(int id);

}
