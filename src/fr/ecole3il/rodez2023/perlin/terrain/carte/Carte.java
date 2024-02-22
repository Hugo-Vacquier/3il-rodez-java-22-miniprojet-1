package fr.ecole3il.rodez2023.perlin.terrain.carte;

import fr.ecole3il.rodez2023.perlin.exception.TerrainInexistant;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.generation.GenerateurCarte;

import java.util.Scanner;

public class Carte {
    private String nom;
    private int largeur;
    private int hauteur;
    private Terrain[][] terrains;

    // Le premier constructeur reste inchangé

    // Second constructeur qui lit les données depuis une chaîne de caractères
    public Carte(String donneesCarte) {
        try (Scanner scanner = new Scanner(donneesCarte)) {
            // Lecture du nom de la carte
            this.nom = scanner.nextLine();

            // Lecture de la largeur et de la hauteur de la carte
            this.largeur = scanner.nextInt();
            this.hauteur = scanner.nextInt();

            // Initialisation du tableau de terrains
            this.terrains = new Terrain[largeur][hauteur];

            // Saut de la ligne après les dimensions
            scanner.nextLine();

            // Lecture des données de chaque terrain
            for (int y = 0; y < hauteur; y++) {
                for (int x = 0; x < largeur; x++) {
                    if (scanner.hasNextDouble()) {
                        double altitude = scanner.nextDouble();
                        double hydrometrie = scanner.nextDouble();
                        double temperature = scanner.nextDouble();
                        this.terrains[x][y] = new Terrain(altitude, hydrometrie, temperature);
                    }
                }
                // Saut de ligne en fin de chaque ligne de terrains si nécessaire
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }
        } // Le scanner est automatiquement fermé grâce au try-with-resources
    }

    public String getNom() {
        return nom;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public Terrain getTerrain(int x, int y) {
        if (x < 0 || x >= largeur || y < 0 || y >= hauteur) {
            throw new TerrainInexistant("La position (" + x + ", " + y + ") est hors des limites de la carte.");
        }
        return terrains[x][y];
    }
}
