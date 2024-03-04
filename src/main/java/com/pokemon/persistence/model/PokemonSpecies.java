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
    @OneToOne
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

    public void setAttack(String attackName) {
        // Recherche de l'attaque dans la base de données par son nom
        EntityManager entityManager = PersistenceFactory.INSTANCE.getEntityManager();
        TypedQuery<Attack> query = entityManager.createQuery("SELECT a FROM Attack a WHERE a.name = :name", Attack.class);
        query.setParameter("name", attackName);
        List<Attack> attacks = query.getResultList();
        if (!attacks.isEmpty()) {
            this.attack = attacks.get(0);
        } else {
            System.out.println("Attack not found");
        }
        entityManager.close();
    }
}
