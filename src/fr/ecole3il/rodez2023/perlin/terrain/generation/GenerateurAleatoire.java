package fr.ecole3il.rodez2023.perlin.terrain.generation;

import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;

import java.util.Random;

public class GenerateurAleatoire extends GenerateurCarte {
    private final Random random;

    public GenerateurAleatoire(long graine) {
        super(graine);
        this.random = new Random(graine);
    }

    @Override
    public Terrain genererTerrain(int i, int j, int largeur, int hauteur) {
        double altitude = random.nextDouble() * 2 - 1; // Normalisation pour obtenir une valeur entre -1 et 1
        double hydrometrie = random.nextDouble(); // Valeur entre 0 et 1
        double temperature = random.nextDouble(); // Valeur entre 0 et 1
        return new Terrain(altitude, hydrometrie, temperature);
    }
}
