package com.programarevaccinnare.programare_vaccinare.service;

import com.programarevaccinnare.programare_vaccinare.entity.Oras;

import java.util.List;

public interface OrasService {
    public List<Oras> findAll();
    public List<Oras> findOraseById_judet(int id_judet);
}
