package com.programarevaccinnare.programare_vaccinare.repository;

import com.programarevaccinnare.programare_vaccinare.entity.CentruVaccinare;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CentruVaccinareRepository extends JpaRepository<CentruVaccinare, Integer> {

    @NotNull
    @Override
    public List<CentruVaccinare> findAll();

    @Query("select cv from CentruVaccinare cv where cv.id_oras = :id_oras")
    public List<CentruVaccinare> findCentruVaccinareById_oras(@Param("id_oras") int id_oras);

    @Query("select cv from CentruVaccinare cv where cv.id = :id")
    public CentruVaccinare findCentruVaccinareById(@Param("id") int id);
}
