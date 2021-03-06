package com.programarevaccinnare.programare_vaccinare.service;

import com.programarevaccinnare.programare_vaccinare.entity.Programare;
import com.programarevaccinnare.programare_vaccinare.repository.ProgramareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgramareServiceImpl implements ProgramareService{

    @Autowired
    ProgramareRepository programareRepository;

    @Override
    public void save(Programare programare) {
        programareRepository.save(programare);
    }

    @Override
    public Programare findProgramareById_beneficiar(int id_beneficiar) {
        return programareRepository.findProgramareById_beneficiar(id_beneficiar);
    }

    @Override
    public void deleteProgramareById(int id) {
        programareRepository.deleteProgramareById(id);
    }
}
