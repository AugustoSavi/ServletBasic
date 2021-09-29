package com.example.core.Model;

public class Voto {

    private Integer id;
    private Candidato candidato;
    private String nome_autor_voto;

    public Voto(){}

    public Voto(Integer id, Candidato candidato, String nome_autor_voto) {
        this.id = id;
        this.candidato = candidato;
        this.nome_autor_voto = nome_autor_voto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public String getNome_autor_voto() {
        return nome_autor_voto;
    }

    public void setNome_autor_voto(String nome_autor_voto) {
        this.nome_autor_voto = nome_autor_voto;
    }
}
