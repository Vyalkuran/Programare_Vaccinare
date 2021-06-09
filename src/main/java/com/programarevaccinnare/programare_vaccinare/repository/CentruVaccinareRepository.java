package com.programarevaccinnare.programare_vaccinare.repository;

import com.programarevaccinnare.programare_vaccinare.entity.CentruVaccinare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CentruVaccinareRepository extends JpaRepository<CentruVaccinare, Integer> {

    @Query("select cv from CentruVaccinare cv where cv.id_oras = :id_oras")
    public List<CentruVaccinare> findCentruVaccinareById_oras(@Param("id_oras") int id_oras);
}
