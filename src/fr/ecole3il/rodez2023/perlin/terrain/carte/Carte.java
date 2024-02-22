package fr.ecole3il.rodez2023.perlin.terrain.carte;

import fr.ecole3il.rodez2023.perlin.exception.TerrainInexistant;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.generation.GenerateurCarte;

public class Carte {
    private String nom;
    private int largeur;
    private int hauteur;
    private Terrain[][] terrains;

    public Carte(String nom, int largeur, int hauteur, GenerateurCarte generateurCarte) {
        this.nom = nom;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.terrains = new Terrain[largeur][hauteur];

        for (int x = 0; x < largeur; x++) {
            for (int y = 0; y < hauteur; y++) {
                this.terrains[x][y] = generateurCarte.genererTerrain(x, y, largeur, hauteur);
            }
        }
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
