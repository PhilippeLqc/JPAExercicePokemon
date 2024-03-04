package com.pokemon.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Singleton de création d'entityManager
 */
public class PersistenceFactory {

	private static final String PERSISTENCE_UNIT_NAME = "com.pokemon.persistence";
	public static PersistenceFactory INSTANCE = new PersistenceFactory();
	private boolean init;
	private EntityManagerFactory emf;

	private PersistenceFactory() {
	}

	/**
	 * Récupère un entityManager.
	 * Crée l'entityManagerFactory au besoin.
	 * @return
	 */
	public synchronized EntityManager getEntityManager() {
		if (!this.init) {
			this.emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			this.init = true;
		}
		return this.emf.createEntityManager();

	}

}
