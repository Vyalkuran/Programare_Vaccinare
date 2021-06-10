package com.programarevaccinnare.programare_vaccinare.repository;

import com.programarevaccinnare.programare_vaccinare.entity.Programare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProgramareRepository extends JpaRepository<Programare, Integer> {

    @Query("select p from Programare p where p.id_beneficiar = :id_beneficiar")
    public Programare findProgramareById_beneficiar(@Param("id_beneficiar") int id_beneficiar);

    @Query("delete from Programare p where p.id = :id")
    public Programare deleteProgramareById(@Param("id") int id);

}
