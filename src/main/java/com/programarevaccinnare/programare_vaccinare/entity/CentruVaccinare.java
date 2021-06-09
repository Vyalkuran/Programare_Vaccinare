package com.programarevaccinnare.programare_vaccinare.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CENTRE_VACCINARE")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CentruVaccinare {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "denumire_centru_vaccinare")
    private String denumire_centru_vaccinare;

    @Column(name = "id_vaccin")
    private int id_vaccin;

    @Column(name = "id_oras")
    private int id_oras;

    public CentruVaccinare(String denumire_centru_vaccinare, int id_vaccin, int id_oras) {
        this.denumire_centru_vaccinare = denumire_centru_vaccinare;
        this.id_vaccin = id_vaccin;
        this.id_oras = id_oras;
    }
}
