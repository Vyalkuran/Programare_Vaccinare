package com.programarevaccinnare.programare_vaccinare.repository;

import com.programarevaccinnare.programare_vaccinare.entity.Utilizator;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UtilizatorRepository extends JpaRepository<Utilizator, Integer> {

    @NotNull
    @Override
    public List<Utilizator> findAll();

    @Query("select u from Utilizator u where u.email = :email")
    public Utilizator findUtilizatorByEmail(@Param("email") String email);

}
