package com.pokemon.persistence.pokemonDao;

import com.pokemon.persistence.PersistenceFactory;
import com.pokemon.persistence.model.Attack;
import jakarta.persistence.EntityManager;

public class AttackDao {

    public void save(Attack attack) {
        // save the attack in the database
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(attack);
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}