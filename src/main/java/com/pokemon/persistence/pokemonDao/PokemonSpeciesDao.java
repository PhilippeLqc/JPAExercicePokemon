package com.pokemon.persistence.pokemonDao;

import com.pokemon.persistence.PersistenceFactory;
import com.pokemon.persistence.model.PokemonSpecies;
import jakarta.persistence.EntityManager;

public class PokemonSpeciesDao {

    public static void savePokemonSpecies(PokemonSpecies pokemonSpecies) {
        // save the pokemon species in the database
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(pokemonSpecies);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public static PokemonSpecies update(PokemonSpecies pokemonSpecies) {
        // update the pokemon species in the database
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();

        entityManager.getTransaction().begin();
        PokemonSpecies updatedPokemonSpecies = entityManager.merge(pokemonSpecies);
        entityManager.getTransaction().commit();

        entityManager.close();
        return updatedPokemonSpecies;
    }

    public void delete(PokemonSpecies pokemonSpecies) {
        // delete the pokemon species in the database
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.remove(pokemonSpecies);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public static PokemonSpecies findByName(String name) {
        // find the pokemon species by its name
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();

        PokemonSpecies pokemonSpecies = entityManager.createQuery("SELECT p FROM PokemonSpecies p WHERE p.name = :name", PokemonSpecies.class)
                .setParameter("name", name)
                .getSingleResult();

        entityManager.close();

        return pokemonSpecies;
    }
}
