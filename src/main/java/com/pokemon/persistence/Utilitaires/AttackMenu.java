package com.pokemon.persistence.Utilitaires;

import java.util.Scanner;
import com.pokemon.persistence.model.Attack;
import com.pokemon.persistence.model.PokemonSpecies;
import com.pokemon.persistence.pokemonDao.AttackDao;
import com.pokemon.persistence.pokemonDao.PokemonSpeciesDao;


public class AttackMenu {
    public static void AttackMenu() {
        System.out.println("Choisissez une option : ");
        System.out.println("1 - Ajouter une attaque");
        System.out.println("2 - Supprimer une attaque");
        System.out.println("3 - Ajouter une attaque à une espèce de pokémon");
        System.out.println("0 - Quitter");
    }

    public static void handleAttackManagement(Scanner sc) {
        boolean isRunningAttack = true;
        while (isRunningAttack) {
            AttackMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    createAttack(sc);
                    break;
                case 2:
                    deleteAttack(sc);
                    break;
                case 3:
                    addAttackToPokemonSpecies(sc);
                    break;
                case 0:
                    isRunningAttack = false;
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        }
    }

    public static void createAttack(Scanner sc) {
        Attack attack = new Attack();
        System.out.println("Entrez le nom de l'attaque : ");
        String name = sc.next();
        attack.setName(name);
        System.out.println("Entrez le type de l'attaque : ");
        String type = sc.next();
        attack.setType(type);
        System.out.println("Entrez la puissance de l'attaque : ");
        int power = sc.nextInt();
        attack.setPower(power);
        AttackDao.saveAttack(attack);
    }

    public static void deleteAttack(Scanner sc) {
        System.out.println("Entrez le nom de l'attaque à supprimer : ");
        String name = sc.next();
        if (AttackDao.findByNameAttack(name) != null) {
            AttackDao.deleteAttack(AttackDao.findByNameAttack(name));
        } else {
            System.out.println("Cette attaque n'existe pas");
        }
    }

    public static void addAttackToPokemonSpecies(Scanner sc) {
        PokemonSpecies pokemon = new PokemonSpecies();
        System.out.println("Entrez le nom de l'espèce de pokémon : ");
        String species = sc.next();
        if (PokemonSpeciesDao.findByName(species) != null) {
            pokemon = PokemonSpeciesDao.findByName(species);
            System.out.println("Entrez le nom de l'attaque : ");
            String attack = sc.next();
            if (AttackDao.findByNameAttack(attack) != null) {
                pokemon.setAttack(AttackDao.findByNameAttack(attack));
                PokemonSpeciesDao.update(pokemon);
            } else {
                System.out.println("Cette attaque n'existe pas");
            }
        } else {
            System.out.println("Cette espèce n'existe pas");
        }
    }
}
