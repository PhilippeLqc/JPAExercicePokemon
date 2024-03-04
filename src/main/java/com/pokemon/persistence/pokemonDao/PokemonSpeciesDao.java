package com.pokemon.persistence.pokemonDao;

import com.pokemon.persistence.PersistenceFactory;
import com.pokemon.persistence.model.PokemonSpecies;
import jakarta.persistence.EntityManager;

public class PokemonSpeciesDao {

    public PokemonSpecies findPokemonSpeciesById(Long id) {
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();

        PokemonSpecies pokemonSpecies = entityManager.find(PokemonSpecies.class, id);

        entityManager.close();
        return pokemonSpecies;
    }

    public void savePokemonSpecies(PokemonSpecies pokemonSpecies) {
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(pokemonSpecies);
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
