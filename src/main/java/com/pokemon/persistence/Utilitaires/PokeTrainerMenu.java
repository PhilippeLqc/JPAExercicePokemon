package com.pokemon.persistence.Utilitaires;

import com.pokemon.persistence.model.PokeTrainer;
import com.pokemon.persistence.model.Pokemon;
import com.pokemon.persistence.model.Sexe;
import com.pokemon.persistence.pokemonDao.PokeTrainerDao;
import com.pokemon.persistence.pokemonDao.PokemonDao;

import java.util.Scanner;

public class PokeTrainerMenu {
    public static void pokeTrainerMenu() {
        System.out.println("Choisissez une option : ");
        System.out.println("1 - Ajouter un dresseur");
        System.out.println("2 - Ajouter un pokémon à un dresseur");
        System.out.println("3 - Supprimer un dresseur");
        System.out.println("0 - Quitter");
    }

    public static void handlePokeTrainerManagement(Scanner sc) {
        boolean isRunningPokeTrainer = true;
        while (isRunningPokeTrainer) {
            pokeTrainerMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    createPokeTrainer(sc);
                    break;
                case 2:
                    addPokemonToPokeTrainer(sc);
                    break;
                case 3:
                    deletePokeTrainer(sc);
                    break;
                case 0:
                    isRunningPokeTrainer = false;
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        }
    }

    public static void createPokeTrainer(Scanner sc) {
        PokeTrainer trainer = new PokeTrainer();
        System.out.println("Entrez le nom du dresseur : ");
        String name = sc.next();
        trainer.setName(name);
        System.out.println("Entrez l'âge du dresseur : ");
        int age = sc.nextInt();
        trainer.setAge(age);
        System.out.println("Entrez le sexe du dresseur (MAN ou WOMAN) : ");
        String sexe = sc.next();
        trainer.setSexe(Sexe.valueOf(sexe));
        System.out.println("Entrez l'argent du dresseur : ");
        int money = sc.nextInt();
        trainer.setMoney(money);
        PokeTrainerDao.savePokeTrainer(trainer);
    }

    public static void addPokemonToPokeTrainer(Scanner sc) {
        System.out.println("Entrez le nom du dresseur : ");
        String name = sc.next();
        PokeTrainer trainer = PokeTrainerDao.findPokeTrainerByName(name);
        System.out.println("Entrez le nom du pokémon à rattacher : ");
        String pokemonName = sc.next();
        Pokemon pokemon = PokemonDao.findByPokemonName(pokemonName);
        pokemon.setTrainer(trainer);
        PokemonDao.PokemonUpdate(pokemon);
    }

    public static void deletePokeTrainer(Scanner sc) {
        System.out.println("Entrez l'id du dresseur à supprimer : ");
        Long id = sc.nextLong();
        PokeTrainerDao.deletePokeTrainer(id);
    }
}
