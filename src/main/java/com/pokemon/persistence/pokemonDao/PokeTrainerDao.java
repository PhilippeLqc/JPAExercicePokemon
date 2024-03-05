package com.pokemon.persistence.pokemonDao;

import com.pokemon.persistence.PersistenceFactory;
import com.pokemon.persistence.model.PokeTrainer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PokeTrainerDao {

    public void savePokeTrainer(PokeTrainer pokeTrainer) {
        // save the poke trainer in the database
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(pokeTrainer);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public void update(PokeTrainer pokeTrainer) {
        // update the poke trainer in the database
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(pokeTrainer);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public List<PokeTrainer> findAllPokeTrainerByName() {
        // find all the poke trainer in the database and print their name in the console
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();
        TypedQuery<PokeTrainer> query = entityManager.createQuery("SELECT p FROM PokeTrainer p", PokeTrainer.class);
        List<PokeTrainer> pokeTrainerList = query.getResultList();
        if (pokeTrainerList.isEmpty()) {
            throw new IllegalArgumentException("PokeTrainer not found");
        }
        System.out.println("LISTE DES POKE TRAINERS");
        for (PokeTrainer pokeTrainer : pokeTrainerList) {
            System.out.println("NOM : " + pokeTrainer.getName());
            System.out.println("-------------------");
        }
        entityManager.close();
        return pokeTrainerList;
    }

public void deletePokeTrainer(Long id) {
        // delete the poke trainer in the database
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();
        PokeTrainer pokeTrainer = entityManager.find(PokeTrainer.class, id);
        if (pokeTrainer == null) {
            throw new IllegalArgumentException("PokeTrainer not found");
        }
        entityManager.getTransaction().begin();
        entityManager.remove(pokeTrainer);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public PokeTrainer findPokeTrainerByName(String name) {
        // find the poke trainer by its name and print its name, id, and age in the console
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();
        TypedQuery<PokeTrainer> query = entityManager.createQuery("SELECT p FROM PokeTrainer p WHERE p.name = :name", PokeTrainer.class);
        query.setParameter("name", name);
        PokeTrainer pokeTrainer = query.getSingleResult();
        if (pokeTrainer == null) {
            throw new IllegalArgumentException("PokeTrainer not found");
        }
        System.out.println("POKE TRAINER PAR NOM");
        System.out.println("NOM : " + pokeTrainer.getName());
        System.out.println("ID : " + pokeTrainer.getId());
        System.out.println("AGE : " + pokeTrainer.getAge());
        System.out.println("-------------------");
        entityManager.close();
        return pokeTrainer;
    }

    public PokeTrainer findPokeTrainerByNameLike(String name) {
        // find the poke trainer by a portion of its name and print its name
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();
        TypedQuery<PokeTrainer> query = entityManager.createQuery("SELECT p FROM PokeTrainer p WHERE p.name LIKE :name", PokeTrainer.class);
        query.setParameter("name", "%" + name + "%");
        List<PokeTrainer> pokeTrainerList = query.getResultList();
        if (pokeTrainerList.isEmpty()) {
            throw new IllegalArgumentException("PokeTrainer not found");
        }
        System.out.println("POKE TRAINER PAR PORTION DE NOM");
        for (PokeTrainer pokeTrainer : pokeTrainerList) {
            System.out.println("NOM : " + pokeTrainer.getName());
            System.out.println("-------------------");
        }
        entityManager.close();
        return null;
    }
}
