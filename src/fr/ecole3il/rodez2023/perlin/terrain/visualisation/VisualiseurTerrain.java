package fr.ecole3il.rodez2023.perlin.terrain.visualisation;

import fr.ecole3il.rodez2023.perlin.terrain.carte.Carte;
import fr.ecole3il.rodez2023.perlin.terrain.elements.*;

public class VisualiseurTerrain {
    private Carte carte;
    private DetermineurTerrain determineurTerrain;

    public VisualiseurTerrain(Carte carte, DetermineurTerrain determineurTerrain) {
        this.carte = carte;
        this.determineurTerrain = determineurTerrain;
    }

    public AltitudeAffichee getAltitudeAffichee(int x, int y) {
        double altitude = carte.getTerrain(x, y).getAltitude();
        if (altitude < 0) return AltitudeAffichee.FONDMARIN;
        if (altitude < 0.33) return AltitudeAffichee.BASSE;
        if (altitude < 0.66) return AltitudeAffichee.MOYENNE;
        return AltitudeAffichee.ELEVEE;
    }

    public HydrometrieAffichee getHydrometrieAffichee(int x, int y) {
        double hydrometrie = carte.getTerrain(x, y).getHydrometrie();
        if (hydrometrie < 0.33) return HydrometrieAffichee.SEC;
        if (hydrometrie < 0.66) return HydrometrieAffichee.MOYEN;
        return HydrometrieAffichee.HUMIDE;
    }

    public TemperatureAffichee getTemperatureAffichee(int x, int y) {
        double temperature = carte.getTerrain(x, y).getTemperature();
        if (temperature < 0.33) return TemperatureAffichee.FROID;
        if (temperature < 0.66) return TemperatureAffichee.TEMPERE;
        return TemperatureAffichee.CHAUD;
    }

    public TypeTerrain getTypeTerrain(int x, int y) {
        Terrain terrain = carte.getTerrain(x, y);
        return determineurTerrain.determinerTerrain(terrain.getAltitude(), terrain.getHydrometrie(), terrain.getTemperature());
    }
}
