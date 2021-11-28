package com.example.core.Mesarios.Repository;

import com.example.core.Mesarios.Model.Mesario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class MesarioRepository {
     EntityManagerFactory entityManagerFactory;
     EntityManager entityManager;

    public MesarioRepository() {
        entityManagerFactory = Persistence.createEntityManagerFactory("votacao-jpa");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(Mesario mesario) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(mesario);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void remove(String id) {
        try {
            Mesario mesario = findOne(id).orElse(null);
            entityManager.getTransaction().begin();
            entityManager.remove(mesario);
            entityManager.getTransaction().commit();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public Optional<Mesario> findOne(String id){
        Mesario mesario = new Mesario();
        try {
            mesario = entityManager.find(Mesario.class, id);
        }catch (Exception e){
            System.out.println(e);
        }
        return Optional.ofNullable(mesario);
    }

    @SuppressWarnings("unchecked")
    public List<Mesario> findAll(){
        List<Mesario> mesarios = Collections.emptyList();
        try {
            mesarios = entityManager.createQuery("select mesario from Mesario mesario").getResultList();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return mesarios;
    }
}
