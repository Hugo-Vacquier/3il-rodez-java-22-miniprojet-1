package fr.ecole3il.rodez2023.perlin.math;

/**
 * La classe abstraite Bruit2D est une base pour la génération de bruit en 2D.
 * Elle définit des méthodes permettant d'obtenir des valeurs de bruit en deux dimensions
 * basées sur une graine et une résolution spécifiques.
 */
public abstract class Bruit2D {

    /** La graine utilisée pour la génération du bruit. */
    private final long graine;

    /** La résolution utilisée pour la génération du bruit. */
    private double resolution;

    /**
     * Constructeur de la classe Bruit2D.
     *
     * @param graine La graine utilisée pour initialiser le générateur de bruit.
     * @param resolution La résolution utilisée pour la génération du bruit.
     */
    public Bruit2D(long graine, double resolution) {
        this.graine = graine;
        this.resolution = resolution;
    }

    /**
     * Méthode abstraite pour obtenir la valeur de bruit en 2D pour les coordonnées spécifiées.
     *
     * @param x Coordonnée x pour laquelle obtenir le bruit.
     * @param y Coordonnée y pour laquelle obtenir le bruit.
     * @return La valeur de bruit en 2D pour les coordonnées fournies.
     */
    public abstract double bruit2D(double x, double y);

    /**
     * Obtient la graine utilisée pour la génération du bruit.
     *
     * @return La graine utilisée pour la génération du bruit.
     */
    public long getGraine() {
        return graine;
    }

    /**
     * Obtient la résolution actuelle utilisée pour la génération du bruit.
     *
     * @return La résolution actuelle.
     */
    public double getResolution() {
        return resolution;
    }

    /**
     * Définit la résolution utilisée pour la génération du bruit.
     *
     * @param resolution La nouvelle résolution à utiliser.
     */
    public void setResolution(double resolution) {
        this.resolution = resolution;
    }
}
