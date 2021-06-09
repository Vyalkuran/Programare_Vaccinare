package com.programarevaccinnare.programare_vaccinare.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "GRUPE_RISC")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class GrupaRisc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="denumire_grupa_risc")
    private String denumire_grupa_risc;

    public GrupaRisc(String denumire_grupa_risc) {
        this.denumire_grupa_risc = denumire_grupa_risc;
    }
}
