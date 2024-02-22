package fr.ecole3il.rodez2023.perlin.terrain.elements;

/**
 * La classe Terrain représente un élément de terrain avec ses caractéristiques principales :
 * altitude, hydrométrie, et température.
 */
public class Terrain {
    private double altitude;
    private double hydrometrie;
    private double temperature;

    /**
     * Constructeur de la classe Terrain.
     *
     * @param altitude La valeur de l'altitude du terrain.
     * @param hydrometrie La valeur de l'hydrométrie du terrain.
     * @param temperature La valeur de la température du terrain.
     */
    public Terrain(double altitude, double hydrometrie, double temperature) {
        this.altitude = altitude;
        this.hydrometrie = hydrometrie;
        this.temperature = temperature;
    }

    /**
     * Retourne l'altitude du terrain.
     *
     * @return L'altitude du terrain.
     */
    public double getAltitude() {
        return altitude;
    }

    /**
     * Définit l'altitude du terrain.
     *
     * @param altitude La nouvelle valeur de l'altitude.
     */
    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    /**
     * Retourne l'hydrométrie du terrain.
     *
     * @return L'hydrométrie du terrain.
     */
    public double getHydrometrie() {
        return hydrometrie;
    }

    /**
     * Définit l'hydrométrie du terrain.
     *
     * @param hydrometrie La nouvelle valeur de l'hydrométrie.
     */
    public void setHydrometrie(double hydrometrie) {
        this.hydrometrie = hydrometrie;
    }

    /**
     * Retourne la température du terrain.
     *
     * @return La température du terrain.
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Définit la température du terrain.
     *
     * @param temperature La nouvelle valeur de la température.
     */
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    /**
     * Représentation sous forme de chaîne de caractères de l'objet Terrain.
     *
     * @return Une chaîne de caractères décrivant le terrain.
     */
    @Override
    public String toString() {
        return String.format("Terrain{altitude=%.2f, hydrometrie=%.2f, temperature=%.2f}",
                altitude, hydrometrie, temperature);
    }
}
