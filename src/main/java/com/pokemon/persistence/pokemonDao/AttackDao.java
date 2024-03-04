package com.pokemon.persistence.pokemonDao;

import com.pokemon.persistence.PersistenceFactory;
import com.pokemon.persistence.model.Attack;
import jakarta.persistence.EntityManager;

public class AttackDao {

    public Attack findAttackById(Long id) {
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();

        Attack attack = entityManager.find(Attack.class, id);

        entityManager.close();
        return attack;
    }

    public void save(Attack attack) {
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(attack);
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}