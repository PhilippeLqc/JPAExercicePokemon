package com.pokemon.persistence.pokemonDao;

import com.pokemon.persistence.PersistenceFactory;
import jakarta.persistence.EntityManager;
import com.pokemon.persistence.model.Pokemon;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PokemonDao {


    public List<Pokemon> findAll() {
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();

        TypedQuery<Pokemon> query = entityManager.createQuery("SELECT p FROM Pokemon p", Pokemon.class);
        List<Pokemon> pokemonList = query.getResultList();

        //get name of the species and id of the pokemon
        for (Pokemon pokemon : pokemonList) {
            System.out.println("LISTE DES POKEMONS");
            System.out.println("NOM : " + pokemon.getSpecies().getName());
            System.out.println("ID : " + pokemon.getId());
            System.out.println("-------------------");
        }
        entityManager.close();
        return pokemonList;
    }


    public Pokemon findById(Long id) {
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();

        Pokemon pokemon = entityManager.find(Pokemon.class, id);

        System.out.println("POKEMON PAR ID");
        System.out.println("NOM : " + pokemon.getSpecies().getName());
        System.out.println("ATTAQUE : " + pokemon.getSpecies().getAttack().getName());
        System.out.println("TYPE : " + pokemon.getSpecies().getAttack().getType());
        System.out.println("DEGAT ATTAQUE : " + pokemon.getSpecies().getAttack().getPower());
        System.out.println("LEVEL : " +pokemon.getLevel());
        System.out.println("POINT DE VIE ACTUEL : " + pokemon.getActualHp());
        System.out.println("XP ACTUEL : " + pokemon.getActualXp());
        System.out.println("POINT DE VIE DE BASE : " + pokemon.getSpecies().getBaseHp());
        System.out.println("-------------------");
        entityManager.close();

        return pokemon;
    }

    public void save(Pokemon pokemon) {
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(pokemon);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public void update(Pokemon pokemon) {
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(pokemon);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public void delete(Pokemon pokemon) {
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();

        entityManager.getTransaction().begin();
        entityManager.remove(pokemon);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public List<Pokemon> findAllOrderByLevelAndActualXp() {
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();

        TypedQuery<Pokemon> query = entityManager.createQuery("SELECT p FROM Pokemon p ORDER BY p.level DESC, p.actualXp DESC", Pokemon.class);
        List<Pokemon> pokemonList = query.getResultList();

        for (Pokemon pokemon : pokemonList) {
            System.out.println("POKEMON PAR ORDRE DECROISSANT DE LEVEL ET XP");
            System.out.println("ID: " + pokemon.getId());
            System.out.println("Species: " + pokemon.getSpecies().getName());
            System.out.println("Level: " + pokemon.getLevel());
            System.out.println("Actual XP: " + pokemon.getActualXp());
            System.out.println("-----------------------------------");
        }

        entityManager.close();
        return pokemonList;
    }

}
