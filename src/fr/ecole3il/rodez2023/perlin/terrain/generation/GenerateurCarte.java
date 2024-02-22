package fr.ecole3il.rodez2023.perlin.terrain.generation;

import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;

/**
 * Cette classe abstraite représente un générateur de carte utilisant la méthode Perlin
 * pour générer un tableau de terrains en fonction d'une graine.
 * @author proussille
 */
public abstract class GenerateurCarte {

    private final long graine;

    /**
     * Constructeur du générateur de carte.
     *
     * @param graine La graine utilisée pour la génération de la carte.
     */
    public GenerateurCarte(long graine) {
        this.graine = graine;
    }

    /**
     * Génère une carte représentée par un tableau de terrains en utilisant la méthode Perlin.
     *
     * @param largeur La largeur de la carte.
     * @param hauteur La hauteur de la carte.
     * @return Un tableau bidimensionnel de terrains représentant la carte générée.
     */
    public Terrain[][] genererCarte(int largeur, int hauteur) {
        Terrain[][] terrains = new Terrain[largeur][hauteur];
        for (int i = 0; i < largeur; i++) {
            for (int j = 0; j < hauteur; j++) {
                terrains[i][j] = genererTerrain(i, j, largeur, hauteur);
            }
        }
        return terrains;
    }

    /**
     * Méthode abstraite à implémenter pour générer un terrain spécifique à une position donnée.
     *
     * @param i        La position verticale dans la carte.
     * @param j        La position horizontale dans la carte.
     * @param largeur  La largeur totale de la carte.
     * @param hauteur  La hauteur totale de la carte.
     * @return Le terrain généré pour la position spécifiée.
     */
    public abstract Terrain genererTerrain(int x, int y, int largeur, int hauteur);

    /**
     * Obtient la graine utilisée pour la génération de la carte.
     *
     * @return La graine utilisée pour la génération.
     */
    public long getGraine() {
        return graine;
    }
}
