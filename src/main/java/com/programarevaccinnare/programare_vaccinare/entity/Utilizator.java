package com.programarevaccinnare.programare_vaccinare.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "UTILIZATORI")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Utilizator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="email")
    private String email;

    @Column(name="parola")
    private String parola;

    public Utilizator(String email, String parola){
        this.email = email;
        this.parola = parola;
    }
}
