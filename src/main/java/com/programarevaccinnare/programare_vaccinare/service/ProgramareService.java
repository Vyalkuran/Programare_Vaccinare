package com.programarevaccinnare.programare_vaccinare.service;

import com.programarevaccinnare.programare_vaccinare.entity.Programare;
import org.springframework.data.repository.query.Param;

public interface ProgramareService {

    public void save(Programare programare);

    public Programare findProgramareById_beneficiar(int id_beneficiar);

    public Programare deleteProgramareById(int id);

}
