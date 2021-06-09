package com.programarevaccinnare.programare_vaccinare.repository;

import com.programarevaccinnare.programare_vaccinare.entity.Vaccin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinRepository extends JpaRepository<Vaccin, Integer> {
}
