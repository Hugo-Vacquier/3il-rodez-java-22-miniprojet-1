package fr.ecole3il.rodez2023.perlin.terrain.elements;

import fr.ecole3il.rodez2023.perlin.exceptions.MauvaiseValeurException;
import fr.ecole3il.rodez2023.perlin.terrain.visualisation.DetermineurTerrain;

public class Terrain {
    private double altitude;
    private double hydrometrie;
    private double temperature;

    public Terrain(double altitude, double hydrometrie, double temperature) {
        setAltitude(altitude);
        setHydrometrie(hydrometrie);
        setTemperature(temperature);
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        if (altitude < -1 || altitude > 1) {
            throw new MauvaiseValeurException("L'altitude doit être comprise entre -1 et 1.");
        }
        this.altitude = altitude;
    }

    public double getHydrometrie() {
        return hydrometrie;
    }

    public void setHydrometrie(double hydrometrie) {
        if (hydrometrie < 0 || hydrometrie > 1) {
            throw new MauvaiseValeurException("L'hydrométrie doit être comprise entre 0 et 1.");
        }
        this.hydrometrie = hydrometrie;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        if (temperature < 0 || temperature > 1) {
            throw new MauvaiseValeurException("La température doit être comprise entre 0 et 1.");
        }
        this.temperature = temperature;
    }

    /**
     * Utilise un DetermineurTerrain pour déterminer le TypeTerrain de ce terrain.
     * @param dt L'instance de DetermineurTerrain à utiliser.
     * @return Le TypeTerrain correspondant à ce terrain.
     */
    public TypeTerrain getTypeTerrain(DetermineurTerrain dt) {
        return dt.determinerTerrain(this.altitude, this.hydrometrie, this.temperature);
    }
}
