package com.example.core.Canditatos.Repository;

import com.example.core.Canditatos.Model.Candidato;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CandidatoRepository {
     EntityManagerFactory entityManagerFactory;
     EntityManager entityManager;

    public CandidatoRepository() {
        entityManagerFactory = Persistence.createEntityManagerFactory("votacao-jpa");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(Candidato candidato) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(candidato);
            entityManager.getTransaction().commit();
            entityManager.getTransaction();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void remove(String id) {
        try {
            Candidato candidato = findOne(id).orElse(null);
            entityManager.getTransaction().begin();
            entityManager.remove(candidato);
            entityManager.getTransaction().commit();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public Optional<Candidato> findOne(String id){
        Candidato candidato = new Candidato();
        try {
            candidato = entityManager.find(Candidato.class, id);
        }catch (Exception e){
            System.out.println(e);
        }
        return Optional.ofNullable(candidato);
    }

    @SuppressWarnings("unchecked")
    public List<Candidato> findAll(){
        List<Candidato> candidatos = Collections.emptyList();
        try {
            candidatos = entityManager.createQuery("select candidato from Candidato candidato").getResultList();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return candidatos;
    }
}
