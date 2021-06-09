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
@Table(name = "VACCINURI")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Vaccin {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "denumire_vaccin")
    private String denumire_vaccin;

    @Column(name = "perioada_rapel")
    private int perioada_rapel;

    public Vaccin(String denumire_vaccin, int perioada_rapel) {
        this.denumire_vaccin = denumire_vaccin;
        this.perioada_rapel = perioada_rapel;
    }
}
