package com.programarevaccinnare.programare_vaccinare.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "AUTORITATI")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Autoritate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name  = "utilizator_id")
    private int utilizator_id;

    @Column(name = "autoritate")
    private String autoritate;

    public Autoritate(int utilizator_id, String autoritate) {
        this.utilizator_id = utilizator_id;
        this.autoritate = autoritate;
    }
}
