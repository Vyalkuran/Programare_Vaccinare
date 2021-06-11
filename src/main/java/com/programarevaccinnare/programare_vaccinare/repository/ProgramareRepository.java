package com.programarevaccinnare.programare_vaccinare.repository;

import com.programarevaccinnare.programare_vaccinare.entity.Programare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProgramareRepository extends JpaRepository<Programare, Integer> {

    @Query("select p from Programare p where p.id_beneficiar = :id_beneficiar")
    public Programare findProgramareById_beneficiar(@Param("id_beneficiar") int id_beneficiar);

    @Transactional
    @Modifying
    @Query("delete from Programare p where p.id = :id")
    public void deleteProgramareById(@Param("id") int id);

}
