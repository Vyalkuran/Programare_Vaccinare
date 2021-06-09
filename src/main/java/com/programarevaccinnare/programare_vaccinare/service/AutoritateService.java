package com.programarevaccinnare.programare_vaccinare.service;

import com.programarevaccinnare.programare_vaccinare.entity.Autoritate;
import com.programarevaccinnare.programare_vaccinare.repository.AutoritateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoritateService {
    @Autowired
    AutoritateRepository autoritateRepository;

    public void save(Autoritate autoritate){
        autoritateRepository.save(autoritate);
    }
}
