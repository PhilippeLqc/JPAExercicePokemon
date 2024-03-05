package com.pokemon.persistence.Utilitaires;

import java.util.Scanner;

import com.pokemon.persistence.model.Attack;
import com.pokemon.persistence.model.PokemonSpecies;
import com.pokemon.persistence.pokemonDao.PokemonSpeciesDao;
import com.pokemon.persistence.pokemonDao.AttackDao;

public class PokemonSpeciesMenu {

    public static void pokemonSpeciesMenu() {
        System.out.println("Choisissez une option : ");
        System.out.println("1 - Ajouter une espèce de pokémon");
        System.out.println("2 - Rattacher une attaque à une espèce de pokémon");
        System.out.println("0 - Quitter");
    }

    public static void handlePokemonSpeciesManagement(Scanner sc) {
        boolean isRunningPokemonSpecies = true;
        while (isRunningPokemonSpecies) {
            pokemonSpeciesMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    createPokemonSpecies(sc);
                    break;
                case 2:
                    updatePokemonSpecies(sc);
                    break;
                case 0:
                    isRunningPokemonSpecies = false;
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        }
    }
    // create a new pokemon species
    public static void createPokemonSpecies(Scanner sc) {
        PokemonSpecies pokemon = new PokemonSpecies();
        System.out.println("Entrez le nom de l'espèce : ");
        String name = sc.next();
        pokemon.setName(name);
        System.out.println("Entrez le nombre de points de vie de base : ");
        int baseHp = sc.nextInt();
        pokemon.setBaseHp(baseHp);
        PokemonSpeciesDao.savePokemonSpecies(pokemon);
    }

    public static void updatePokemonSpecies(Scanner sc) {
        PokemonSpecies pokemon = new PokemonSpecies();
        System.out.println("Entrez le nom de l'espèce à modifier : ");
        String name = sc.next();
        PokemonSpecies pokemonToFind = PokemonSpeciesDao.findByName(name);
        System.out.println("Entrez le nom de l'attaque à rattacher : ");
        String attackName = sc.next();
        Attack attack = AttackDao.findByNameAttack(attackName);
        pokemonToFind.setAttack(attack);
        PokemonSpeciesDao.update(pokemon);
    }
}
