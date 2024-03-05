package com.pokemon.persistence;


import com.pokemon.persistence.model.Arena;
import com.pokemon.persistence.model.Pokemon;
import com.pokemon.persistence.model.PokemonSpecies;
import com.pokemon.persistence.model.Attack;
import com.pokemon.persistence.pokemonDao.ArenaDao;
import com.pokemon.persistence.pokemonDao.AttackDao;
import com.pokemon.persistence.pokemonDao.PokemonDao;
import com.pokemon.persistence.pokemonDao.PokemonSpeciesDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;

public class pokemonMain {
    public static void main(String[] args) {

        // CREATE ATTACK, POKEMON SPECIES, POKEMON, ARENA

        // CREATE ATTACKS
        AttackDao attackDao = new AttackDao();
        Attack thunderbolt = new Attack();
        thunderbolt.setName("Thunderbolt");
        thunderbolt.setType("Electric");
        thunderbolt.setPower(90);
        attackDao.save(thunderbolt);

        Attack fireBlast = new Attack();
        fireBlast.setName("Fire Blast");
        fireBlast.setType("Fire");
        fireBlast.setPower(110);
        attackDao.save(fireBlast);

        Attack waterGun = new Attack();
        waterGun.setName("Water Gun");
        waterGun.setType("Water");
        waterGun.setPower(40);
        attackDao.save(waterGun);
        //--------------------------------------------------------------------------------

        // CREATE POKEMON SPECIES
        PokemonSpeciesDao pokemonSpeciesDao = new PokemonSpeciesDao();
        PokemonSpecies pikachu = new PokemonSpecies();
        pikachu.setName("Pikachu");
        pikachu.setAttack("Thunderbolt");
        pikachu.setBaseHp(40);
        pokemonSpeciesDao.savePokemonSpecies(pikachu);

        PokemonSpecies charizard = new PokemonSpecies();
        charizard.setName("Charizard");
        charizard.setAttack("Fire Blast");
        charizard.setBaseHp(78);
        pokemonSpeciesDao.savePokemonSpecies(charizard);

        PokemonSpecies blastoise = new PokemonSpecies();
        blastoise.setName("Blastoise");
        blastoise.setAttack("Water Gun");
        blastoise.setBaseHp(79);
        pokemonSpeciesDao.savePokemonSpecies(blastoise);
        //--------------------------------------------------------------------------------

        // CREATE POKEMON
        PokemonDao pokemonDao = new PokemonDao();
        Pokemon pikachu1 = new Pokemon();
        pikachu1.setSpecies(pikachu);
        pikachu1.setLevel(5);
        pikachu1.setActualHp(40);
        pikachu1.setActualXp(131);
        pokemonDao.save(pikachu1);

        Pokemon charizard1 = new Pokemon();
        charizard1.setSpecies(charizard);
        charizard1.setLevel(10);
        charizard1.setActualHp(78);
        charizard1.setActualXp(325);
        pokemonDao.save(charizard1);

        Pokemon blastoise1 = new Pokemon();
        blastoise1.setSpecies(blastoise);
        blastoise1.setLevel(15);
        blastoise1.setActualHp(79);
        blastoise1.setActualXp(500);
        pokemonDao.save(blastoise1);
        //--------------------------------------------------------------------------------

        // CREATE ARENA
        ArenaDao ArenaDao = new ArenaDao();
        Arena arena1 = new Arena();
        arena1.setName("Pallet Town");
        arena1.setType("Grass");
        ArenaDao.saveArena(arena1);

        Arena arena2 = new Arena();
        arena2.setName("Cerulean City");
        arena2.setType("Water");
        ArenaDao.saveArena(arena2);

        Arena arena3 = new Arena();
        arena3.setName("Vermilion City");
        arena3.setType("Electric");
        ArenaDao.saveArena(arena3);
        //--------------------------------------------------------------------------------


        //thanks to the relationship between Pokemon, PokemonSpecies and Attack, we can access all the details of the pokemon using pokemonDao
        Pokemon pokemonById = pokemonDao.findById(1L);
        System.out.println(pokemonById);

        // show all the pokemons in the database. Only shows the pokemon id and name of the species.
        List<Pokemon> pokemon = pokemonDao.findAll();
        System.out.println(pokemon);

        // show all pokemon based in ascending order of their actualXp and level.
        List<Pokemon> pokemonByOrder = pokemonDao.findAllOrderByLevelAndActualXp();
        System.out.println(pokemonByOrder);

        // show all the arenas in the database
        List<Arena> arena = ArenaDao.findAllArena();
        System.out.println(arena);

    }

}

