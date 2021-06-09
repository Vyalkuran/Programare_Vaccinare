package com.programarevaccinnare.programare_vaccinare.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "BENEFICIARI")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Beneficiar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="nume")
    private String nume;

    @Column(name="prenume")
    private String prenume;

    @Column(name="cnp")
    private String cnp;

    @Column(name="serie")
    private String serie;

    @Column(name="numar_serie")
    private String numar_serie;

    @Column(name="id_oras")
    private int id_oras;

    @Column(name="email")
    private String email;

    @Column(name="telefon")
    private String numar_telefon;

    @Column(name="id_grupa_risc")
    private int id_grupa_risc;

    @Column(name="id_utilizator")
    private int id_utilizator;

    public Beneficiar(String nume, String prenume, String cnp, String serie, String numar_serie, int id_oras, String email, String numar_telefon, int id_grupa_risc, int id_utilizator) {
        this.nume = nume;
        this.prenume = prenume;
        this.cnp = cnp;
        this.serie = serie;
        this.numar_serie = numar_serie;
        this.id_oras = id_oras;
        this.email = email;
        this.numar_telefon = numar_telefon;
        this.id_grupa_risc = id_grupa_risc;
        this.id_utilizator = id_utilizator;
    }
}
