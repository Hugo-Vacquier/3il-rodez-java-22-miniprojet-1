package fr.ecole3il.rodez2023.perlin.terrain.visualisation;

import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;

public interface DetermineurTerrain {

	public TypeTerrain determinerTerrain(double altitude, double hydrometrie, double temperature);


}

