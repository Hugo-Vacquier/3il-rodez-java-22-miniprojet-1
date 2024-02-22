package fr.ecole3il.rodez2023.perlin.terrain.generation;

import fr.ecole3il.rodez2023.perlin.math.BruitPerlin2D;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.math.BruitPerlin2D;

public class GenerateurPerlin extends GenerateurCarte {
    private final BruitPerlin2D bruitPerlinAltitude;
    private final BruitPerlin2D bruitPerlinHydrometrie;
    private final BruitPerlin2D bruitPerlinTemperature;

    public GenerateurPerlin(long graine) {
        super(graine);
        bruitPerlinAltitude = new BruitPerlin2D(graine * 4); // Exemple de multiplication pour varier les graines
        bruitPerlinHydrometrie = new BruitPerlin2D(graine);
        bruitPerlinTemperature = new BruitPerlin2D(graine * 2);
    }

    @Override
    public Terrain genererTerrain(int i, int j, int largeur, int hauteur) {
        double x = (double) i / largeur;
        double y = (double) j / hauteur;

        double altitude = bruitPerlinAltitude.bruit2D(x, y) * 2 - 1; // Normalisation pour obtenir une valeur entre -1 et 1
        double hydrometrie = bruitPerlinHydrometrie.bruit2D(x, y); // Valeur entre 0 et 1
        double temperature = bruitPerlinTemperature.bruit2D(x, y); // Valeur entre 0 et 1

        return new Terrain(altitude, hydrometrie, temperature);
    }
}
