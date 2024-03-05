package com.pokemon.persistence.model;

import jakarta.persistence.*;

@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "species_id")
    private PokemonSpecies species;
    private int level;
    private int actualHp;
    private int actualXp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trainer_id")
    private PokeTrainer trainer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PokemonSpecies getSpecies() {
        return species;
    }

    public void setSpecies(PokemonSpecies species) {
        this.species = species;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getActualHp() {
        return actualHp;
    }

    public void setActualHp(int actualHp) {
        this.actualHp = actualHp;
    }

    public int getActualXp() {
        return actualXp;
    }

    public void setActualXp(int actualXp) {
        this.actualXp = actualXp;
    }

    public PokeTrainer getTrainer() {
        return trainer;
    }

    public void setTrainer(PokeTrainer trainer) {
        this.trainer = trainer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
