package com.pokemon.persistence.pokemonDao;

import com.pokemon.persistence.PersistenceFactory;
import com.pokemon.persistence.model.Attack;
import jakarta.persistence.EntityManager;

public class AttackDao {

    public static void saveAttack(Attack attack) {
        // save the attack in the database
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(attack);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public Attack update(Attack attack) {
        // update the attack in the database
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();

        entityManager.getTransaction().begin();
        Attack updatedAttack = entityManager.merge(attack);
        entityManager.getTransaction().commit();

        entityManager.close();
        return updatedAttack;
    }

    public static void deleteAttack(Attack attack) {
        // delete the attack in the database
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.remove(attack);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public static Attack findByNameAttack(String name) {
        // find the attack by its name
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();

        Attack attack = entityManager.createQuery("SELECT a FROM Attack a WHERE a.name = :name", Attack.class)
                .setParameter("name", name)
                .getSingleResult();

        entityManager.close();

        return attack;
    }
}