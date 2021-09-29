package com.example.core.Model;

public class Candidato {
    private String id;
    private String Nome;
    private Integer NumeroCandidato;

    public Candidato(){}

    public Candidato(String id, String nome, Integer numeroCandidato) {
        this.id = id;
        Nome = nome;
        NumeroCandidato = numeroCandidato;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Integer getNumeroCandidato() {
        return NumeroCandidato;
    }

    public void setNumeroCandidato(Integer numeroCandidato) {
        NumeroCandidato = numeroCandidato;
    }
}
