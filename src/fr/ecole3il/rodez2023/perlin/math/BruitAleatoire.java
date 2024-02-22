package fr.ecole3il.rodez2023.perlin.math;

import java.util.Random;

/**
 * La classe BruitAleatoire étend la classe Bruit2D et génère du bruit aléatoire en deux dimensions.
 * Elle utilise la classe Random de Java pour générer des valeurs aléatoires, basées sur une graine et une résolution.
 */
public class BruitAleatoire extends Bruit2D {

    private Random random; // Générateur de nombres aléatoires

    /**
     * Constructeur de la classe BruitAleatoire.
     * Initialise le générateur de bruit avec une graine et une résolution spécifiques.
     *
     * @param graine La graine utilisée pour initialiser le générateur de nombres aléatoires.
     * @param resolution La résolution du bruit aléatoire généré.
     */
    public BruitAleatoire(long graine, double resolution) {
        super(graine, resolution);
        this.random = new Random(graine); // Initialise le générateur de nombres aléatoires avec la graine
    }

    /**
     * Génère une valeur de bruit aléatoire pour les coordonnées spécifiées.
     * Cette implémentation ignore les coordonnées et retourne une valeur aléatoire uniforme.
     *
     * @param x Coordonnée x pour laquelle obtenir le bruit.
     * @param y Coordonnée y pour laquelle obtenir le bruit.
     * @return Une valeur aléatoire uniforme entre 0 et 1.
     */
    @Override
    public double bruit2D(double x, double y) {
        // Utilise la graine et la résolution pour modifier le flux de nombres aléatoires
        // de manière à ce que chaque position (x, y) donne une valeur aléatoire, mais
        // consistante pour des appels répétés.
        random.setSeed((long) (x * getResolution() + y * getResolution() + getGraine()));
        return random.nextDouble();
    }
}

