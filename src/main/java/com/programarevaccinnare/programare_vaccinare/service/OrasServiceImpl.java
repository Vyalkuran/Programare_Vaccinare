package com.programarevaccinnare.programare_vaccinare.service;

import com.programarevaccinnare.programare_vaccinare.entity.Oras;
import com.programarevaccinnare.programare_vaccinare.repository.OrasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrasServiceImpl implements OrasService{

    @Autowired
    OrasRepository orasRepository;

    @Override
    public List<Oras> findAll() {
        return orasRepository.findAll();
    }

    @Override
    public List<Oras> findOraseById_judet(int id_judet) {
        return orasRepository.findOraseById_judet(id_judet);
    }
}
