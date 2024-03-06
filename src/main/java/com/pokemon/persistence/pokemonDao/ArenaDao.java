package com.pokemon.persistence.pokemonDao;

import jakarta.persistence.EntityManager;
import com.pokemon.persistence.PersistenceFactory;
import com.pokemon.persistence.model.Arena;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ArenaDao {

    public static List<Arena> findAllArena() {
        // find all the arenas and their type and print them in the console
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

    public static void saveArena(Arena arena) {
        // save the arena in the database
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(arena);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public static void deleteArena(String name) {
        // delete the arena from the database
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();

        entityManager.getTransaction().begin();
        Arena arena = entityManager.find(Arena.class, name);
        entityManager.remove(arena);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public static Arena findByName(String name) {
        // find the arena by its name
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();

        Arena arena = entityManager.find(Arena.class, name);

        entityManager.close();
        return arena;
    }

}
