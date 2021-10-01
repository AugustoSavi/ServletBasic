package com.example.core.Model;

public class Candidato {
    private String id;
    private String nome;
    private Integer numeroCandidato;

    public Candidato(){}

    public Candidato(String id, String nome, Integer numeroCandidato) {
        this.id = id;
        this.nome = nome;
        this.numeroCandidato = numeroCandidato;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumeroCandidato() {
        return numeroCandidato;
    }

    public void setNumeroCandidato(Integer numeroCandidato) {
        this.numeroCandidato = numeroCandidato;
    }
}
