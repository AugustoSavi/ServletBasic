package com.example.core.Canditatos.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Candidato {

    @Id
    private String id;
    @Column
    private String nome;
    @Column
    private Integer numeroCandidato;
}
