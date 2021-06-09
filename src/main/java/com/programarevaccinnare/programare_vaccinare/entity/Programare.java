package com.programarevaccinnare.programare_vaccinare.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "PROGRAMARI")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Programare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="ziua")
    private String ziua;

    @Column(name="data_zi")
    private int data_zi;

    @Column(name="data_luna")
    private int data_luna;

    @Column(name="data_an")
    private int data_an;

    @Column(name="id_centru")
    private int id_centru;

    @Column(name="id_beneficiar")
    private int id_beneficiar;

    public Programare(String ziua, int data_zi, int data_luna, int data_an, int id_centru, int id_beneficiar) {
        this.ziua = ziua;
        this.data_zi = data_zi;
        this.data_luna = data_luna;
        this.data_an = data_an;
        this.id_centru = id_centru;
        this.id_beneficiar = id_beneficiar;
    }
}
