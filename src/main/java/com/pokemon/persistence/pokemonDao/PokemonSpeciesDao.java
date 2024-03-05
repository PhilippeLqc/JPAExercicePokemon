package com.pokemon.persistence.pokemonDao;

import com.pokemon.persistence.PersistenceFactory;
import com.pokemon.persistence.model.PokemonSpecies;
import jakarta.persistence.EntityManager;

public class PokemonSpeciesDao {

    public void savePokemonSpecies(PokemonSpecies pokemonSpecies) {
        // save the pokemon species in the database
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(pokemonSpecies);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public PokemonSpecies update(PokemonSpecies pokemonSpecies) {
        // update the pokemon species in the database
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();

        entityManager.getTransaction().begin();
        PokemonSpecies updatedPokemonSpecies = entityManager.merge(pokemonSpecies);
        entityManager.getTransaction().commit();

        entityManager.close();
        return updatedPokemonSpecies;
    }
}
