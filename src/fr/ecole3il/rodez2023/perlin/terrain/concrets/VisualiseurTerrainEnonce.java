package fr.ecole3il.rodez2023.perlin.terrain.concrets;

import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;
import fr.ecole3il.rodez2023.perlin.terrain.visualisation.DetermineurTerrain;

public class VisualiseurTerrainEnonce implements DetermineurTerrain {

	@Override
	public TypeTerrain determinerTerrain(double altitude, double hydrometrie, double temperature) {
		// Océan
		if (altitude < 0) return TypeTerrain.OCEAN;

		// Plaine
		if (hydrometrie <= 0.25 && altitude <= 0.25) return TypeTerrain.PLAINE;

		// Forêt de feuillus
		if (hydrometrie <= 0.25 && altitude <= 0.7 && temperature > 0.25) return TypeTerrain.FORET_FEUILLUS;

		// Toundra
		if (hydrometrie <= 0.25 && altitude <= 0.25 && temperature > 0.7) return TypeTerrain.TOUNDRA;

		// Forêt de conifères
		if (altitude <= 0.25 && temperature > 0.25 && temperature <= 0.7) return TypeTerrain.FORET_CONIFERES;

		// Montagne
		if (altitude > 0.7) return TypeTerrain.MONTAGNE;

		// Désert
		if (hydrometrie <= 0.25 && altitude > 0.7 && temperature <= 0.25) return TypeTerrain.DESERT;

		// Collines
		if (altitude > 0.25 && altitude <= 0.7) return TypeTerrain.COLLINES;

		// Marais
		if (hydrometrie > 0.25 && altitude <= 0.25) return TypeTerrain.MARAIS;

		// Valeur par défaut si aucune condition n'est remplie
		return TypeTerrain.PLAINE;
	}
}
