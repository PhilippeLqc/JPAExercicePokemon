package com.pokemon.persistence.Utilitaires;

import com.pokemon.persistence.model.Arena;
import com.pokemon.persistence.pokemonDao.ArenaDao;

import java.util.Scanner;

public class ArenaMenu {
    public static void ArenaMenu(Scanner sc) {
        System.out.println("Choisissez une option : ");
        System.out.println("1 - Ajouter une arène");
        System.out.println("2 - Supprimer une arène");
        System.out.println("3 - Afficher la liste des arènes");
        System.out.println("0 - Quitter");
    }

    public static void handleArenaManagement(Scanner sc) {
        boolean isRunningArena = true;
        while (isRunningArena) {
            ArenaMenu(sc);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    createArena(sc);
                    break;
                case 2:
                    deleteArena(sc);
                    break;
                case 3:
                    ArenaDao.findAllArena();
                    break;
                case 0:
                    isRunningArena = false;
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        }
    }

    public static void createArena(Scanner sc) {
        Arena arena = new Arena();
        System.out.println("Entrez le nom de l'arène : ");
        String name = sc.next();
        arena.setName(name);
        System.out.println("Entrez le type de l'arène : ");
        String type = sc.next();
        arena.setType(type);
        ArenaDao.saveArena(arena);
    }

    public static void deleteArena(Scanner sc) {
        System.out.println("Entrez le nom de l'arène à supprimer : ");
        String name = sc.next();
        ArenaDao.deleteArena(name);
    }
}
