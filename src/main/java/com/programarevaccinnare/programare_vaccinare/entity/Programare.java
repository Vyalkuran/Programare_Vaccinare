package com.programarevaccinnare.programare_vaccinare.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Calendar;

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

    @Column(name = "data_programare")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Calendar data_programare;

    @Column(name="id_centru")
    private int id_centru;

    @Column(name="id_beneficiar")
    private int id_beneficiar;

    public Programare(Calendar data_programare, int id_centru, int id_beneficiar) {
        this.data_programare = data_programare;
        this.id_centru = id_centru;
        this.id_beneficiar = id_beneficiar;
    }
}
