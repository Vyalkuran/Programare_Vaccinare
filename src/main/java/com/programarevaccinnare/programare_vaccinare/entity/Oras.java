package com.programarevaccinnare.programare_vaccinare.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "ORASE")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Oras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="denumire_oras")
    private String denumire_oras;

    @Column(name="id_judet")
    private int id_judet;

    public Oras(String denumire_oras, int id_judet) {
        this.denumire_oras = denumire_oras;
        this.id_judet = id_judet;
    }
}
