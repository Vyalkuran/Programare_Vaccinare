package com.programarevaccinnare.programare_vaccinare.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "JUDETE")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Judet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="denumire_judet")
    private String denumire_judet;

    public Judet(String denumire_judet) {
        this.denumire_judet = denumire_judet;
    }
}
