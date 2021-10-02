package com.example.core.Model;

public class Voto {

    private String id;
    private Candidato candidato;

    public Voto(){}

    public Voto(String id, Candidato candidato) {
        this.id = id;
        this.candidato = candidato;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
}
