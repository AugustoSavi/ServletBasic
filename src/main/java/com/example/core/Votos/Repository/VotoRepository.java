package com.example.core.Votos.Repository;

import com.example.core.Votos.Model.Voto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class VotoRepository {
     EntityManagerFactory entityManagerFactory;
     EntityManager entityManager;

    public VotoRepository() {
        entityManagerFactory = Persistence.createEntityManagerFactory("votacao-jpa");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(Voto voto) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(voto);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void remove(Long id) {
        try {
            Voto voto = findOne(id).orElse(null);
            entityManager.getTransaction().begin();
            entityManager.remove(voto);
            entityManager.getTransaction().commit();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public Optional<Voto> findOne(Long id){
        Voto voto = new Voto();
        try {
            voto = entityManager.find(Voto.class, id);
        }catch (Exception e){
            System.out.println(e);
        }
        return Optional.ofNullable(voto);
    }

    @SuppressWarnings("unchecked")
    public List<Voto> findAll(){
        List<Voto> votos = Collections.emptyList();
        try {
            votos = entityManager.createQuery("select voto from Voto voto").getResultList();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return votos;
    }
}
