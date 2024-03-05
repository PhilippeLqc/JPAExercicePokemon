package com.pokemon.persistence.model;

import com.pokemon.persistence.PersistenceFactory;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class PokemonSpecies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int baseHp;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "attack_id")
    private Attack attack;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseHp() {
        return baseHp;
    }

    public void setBaseHp(int baseHp) {
        this.baseHp = baseHp;
    }

    public Attack getAttack() {
        return attack;
    }

    public void setAttack(Attack attack) {
        this.attack = attack;
    }

}