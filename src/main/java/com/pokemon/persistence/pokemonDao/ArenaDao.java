package com.pokemon.persistence.pokemonDao;

import jakarta.persistence.EntityManager;
import com.pokemon.persistence.PersistenceFactory;
import com.pokemon.persistence.model.Arena;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ArenaDao {

    public List<Arena> findAllArena() {
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();

        TypedQuery<Arena> query = entityManager.createQuery("SELECT a FROM Arena a", Arena.class);
        List<Arena> arenaList = query.getResultList();

            System.out.println("LISTE DES ARENES ET LEUR TYPE");
        for (Arena arena : arenaList) {
            System.out.println("NOM DE L'ARENE : " + arena.getName() + ", " + "TYPE DE L'ARENE : " + arena.getType());
            System.out.println("-------------------");
        }

        entityManager.close();
        return arenaList;
    }

    public void saveArena(Arena arena) {
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(arena);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

}
