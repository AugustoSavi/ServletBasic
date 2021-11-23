package com.example.core.Votos.Model;

import com.example.core.Canditatos.Model.Candidato;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Voto {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "candidato_id")
    private Candidato candidato;
}
