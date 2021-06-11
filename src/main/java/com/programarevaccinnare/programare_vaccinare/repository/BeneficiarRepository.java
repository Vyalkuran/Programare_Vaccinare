package com.programarevaccinnare.programare_vaccinare.repository;

import com.programarevaccinnare.programare_vaccinare.entity.Beneficiar;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BeneficiarRepository extends JpaRepository<Beneficiar, Integer> {

    @NotNull
    @Override
    public List<Beneficiar> findAll();

    @Query("select b from Beneficiar b where b.id_utilizator = :id_utilizator")
    public List<Beneficiar> findBeneficiariById_utilizator(@Param("id_utilizator") int id_utilizator);

    @Query("select b from Beneficiar b where b.id = :id")
    public Beneficiar findBeneficiarById(@Param("id") int id);
}
