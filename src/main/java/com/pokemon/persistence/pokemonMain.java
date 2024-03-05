package com.pokemon.persistence;


import com.pokemon.persistence.Utilitaires.*;

import java.util.Scanner;

public class pokemonMain {
    public static void main(String[] args) {
        pokemonMain main = new pokemonMain();
        main.start();
    }

    private void start() {
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            UtilitairesBase.displayMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    PokemonSpeciesMenu.handlePokemonSpeciesManagement(sc);
                    break;
                case 2:
                    PokemonMenu.handlePokemonManagement(sc);
                    break;
                case 3:
                    PokeTrainerMenu.handlePokeTrainerManagement(sc);
                    break;
                case 4:
                    ArenaMenu.handleArenaManagement(sc);
                    break;
                case 5:
                    AttackMenu.handleAttackManagement(sc);
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        }
    }
}

