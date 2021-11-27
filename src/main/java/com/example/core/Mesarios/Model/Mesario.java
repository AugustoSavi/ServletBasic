package com.example.core.Mesarios.Model;

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
public class Mesario {

    @Id
    private String id;
    @Column
    private String nome;
    @Column
    private String cpf;
    @Column
    private String numeroTelefone;
}
