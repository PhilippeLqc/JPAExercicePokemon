package com.pokemon.persistence.Utilitaires;

import com.pokemon.persistence.model.Pokemon;
import com.pokemon.persistence.pokemonDao.PokemonDao;
import com.pokemon.persistence.pokemonDao.PokemonSpeciesDao;

import java.util.Scanner;

public class PokemonMenu {

    public static void PokemonMenu() {
        System.out.println("Choisissez une option : ");
        System.out.println("1 - Ajouter un pokémon");
        System.out.println("2 - Modifier un pokémon");
        System.out.println("3 - Supprimer un pokémon");
        System.out.println("0 - Quitter");
    }

    public static void handlePokemonManagement(Scanner sc) {
        boolean isRunningPokemon = true;
        while (isRunningPokemon) {
            PokemonMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    createPokemon(sc);
                    break;
                case 2:
                    updatePokemon(sc);
                    break;
                case 3:
                    deletePokemon(sc);
                    break;
                case 0:
                    isRunningPokemon = false;
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        }
    }

    public static void createPokemon(Scanner sc) {
        Pokemon pokemon = new Pokemon();
        System.out.println("Entrez le nom du pokémon : ");
        String name = sc.next();
        pokemon.setName(name);
        System.out.println("Entrez l'espèce du pokemon : ");
        String species = sc.next();
        pokemon.setSpecies(PokemonSpeciesDao.findByName(species));
        System.out.println("Entrez le niveau du pokémon : ");
        int level = sc.nextInt();
        pokemon.setLevel(level);
        System.out.println("Entrez les points de vie actuels du pokémon : ");
        int actualHp = sc.nextInt();
        pokemon.setActualHp(actualHp);
        System.out.println("Entrez l'expérience actuelle du pokémon : ");
        int actualXp = sc.nextInt();
        pokemon.setActualXp(actualXp);
        PokemonDao.savePokemon(pokemon);
    }

    private static void updatePokemonMenu() {
        System.out.println("Choisissez une option : ");
        System.out.println("1 - Modifier le nom du pokémon");
        System.out.println("2 - Modifier l'espèce du pokémon");
        System.out.println("3 - Modifier le niveau du pokémon");
        System.out.println("4 - Modifier les points de vie actuels du pokémon");
        System.out.println("5 - Modifier l'expérience actuelle du pokémon");
        System.out.println("0 - Quitter");
    }

    public static void updatePokemon(Scanner sc) {
        Pokemon updatedPokemon = new Pokemon();
        boolean isRunningUpdatePokemon = true;
        while (isRunningUpdatePokemon) {
            updatePokemonMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Entrez le nom du pokémon à modifier : ");
                    String name = sc.next();
                    Pokemon pokemonToFind = PokemonDao.findByPokemonName(name);
                    System.out.println("Entrez le nouveau nom du pokémon : ");
                    String newName = sc.next();
                    pokemonToFind.setName(newName);
                    PokemonDao.PokemonUpdate(updatedPokemon);
                    break;
                case 2:
                    System.out.println("Entrez le nom du pokémon à modifier : ");
                    String nameSpecies = sc.next();
                    Pokemon pokemonToFindSpecies = PokemonDao.findByPokemonName(nameSpecies);
                    System.out.println("Entrez la nouvelle espèce du pokémon : ");
                    String newSpecies = sc.next();
                    pokemonToFindSpecies.setSpecies(PokemonSpeciesDao.findByName(newSpecies));
                    PokemonDao.PokemonUpdate(updatedPokemon);
                    break;
                case 3:
                    System.out.println("Entrez le nom du pokémon à modifier : ");
                    String nameLevel = sc.next();
                    Pokemon pokemonToFindLevel = PokemonDao.findByPokemonName(nameLevel);
                    System.out.println("Entrez le nouveau niveau du pokémon : ");
                    int newLevel = sc.nextInt();
                    pokemonToFindLevel.setLevel(newLevel);
                    PokemonDao.PokemonUpdate(updatedPokemon);
                    break;
                case 4:
                    System.out.println("Entrez le nom du pokémon à modifier : ");
                    String nameActualHp = sc.next();
                    Pokemon pokemonToFindActualHp = PokemonDao.findByPokemonName(nameActualHp);
                    System.out.println("Entrez les nouveaux points de vie actuels du pokémon : ");
                    int newActualHp = sc.nextInt();
                    pokemonToFindActualHp.setActualHp(newActualHp);
                    PokemonDao.PokemonUpdate(updatedPokemon);
                    break;
                case 5:
                    System.out.println("Entrez le nom du pokémon à modifier : ");
                    String nameActualXp = sc.next();
                    Pokemon pokemonToFindActualXp = PokemonDao.findByPokemonName(nameActualXp);
                    System.out.println("Entrez la nouvelle expérience actuelle du pokémon : ");
                    int newActualXp = sc.nextInt();
                    pokemonToFindActualXp.setActualXp(newActualXp);
                    PokemonDao.PokemonUpdate(updatedPokemon);
                    break;
                case 0:
                    isRunningUpdatePokemon = false;
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        }
    }

    public static void deletePokemon(Scanner sc) {
        System.out.println("Entrez le nom du pokémon à supprimer : ");
        String name = sc.next();
        Pokemon pokemon = PokemonDao.findByPokemonName(name);
        PokemonDao.deletePokemon(pokemon);
    }

}
