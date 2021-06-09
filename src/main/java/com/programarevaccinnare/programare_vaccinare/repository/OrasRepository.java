package com.programarevaccinnare.programare_vaccinare.repository;

import com.programarevaccinnare.programare_vaccinare.entity.Oras;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrasRepository extends JpaRepository<Oras, Integer> {

    @NotNull
    @Override
    public List<Oras> findAll();

    @Query(value = "select o from Oras o where o.id_judet = :id_judet")
    public List<Oras> findOraseById_judet(@Param("id_judet") int id_judet);
}
