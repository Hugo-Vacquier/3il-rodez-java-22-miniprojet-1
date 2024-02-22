package fr.ecole3il.rodez2023.perlin.math;

/**
 * La classe BruitPerlin2D étend Bruit2D pour implémenter l'algorithme de bruit de Perlin en deux dimensions.
 * Elle utilise une table de permutation et des vecteurs de gradient pour générer des valeurs cohérentes et continues de bruit.
 */
public class BruitPerlin2D extends Bruit2D {

	// Vecteurs de gradient pour le bruit de Perlin
	private static final float[][] GRADIENT_2D = { { 1, 1 }, { -1, 1 }, { 1, -1 }, { -1, -1 }, { 1, 0 }, { -1, 0 },
			{ 0, 1 }, { 0, -1 } };

	// Tableau de permutations pour le bruit de Perlin
	private static final int[] PERMUTATION;

	static {
		// Initialisation de la table de permutation avec des valeurs de 0 à 255
		PERMUTATION = new int[256];
		for (int i = 0; i < 256; i++) {
			PERMUTATION[i] = i;
		}
		// Mélange de la table de permutation en utilisant la graine
		// (Vous pouvez utiliser un algorithme de mélange comme le Fisher-Yates shuffle)
	}

	/**
	 * Constructeur de la classe BruitPerlin2D.
	 *
	 * @param graine La graine utilisée pour initialiser le générateur de nombres aléatoires.
	 * @param resolution La résolution du bruit de Perlin.
	 */
	public BruitPerlin2D(long graine, double resolution) {
		super(graine, resolution);
		// Mélange de la table de permutation basée sur la graine
		// (Vous pouvez réutiliser le même générateur de nombres aléatoires que celui utilisé pour le mélange)
	}

	@Override
	public double bruit2D(double x, double y) {
		// Utilisation de getResolution() pour accéder à la valeur de résolution héritée
		x /= getResolution();
		y /= getResolution();

		// Ici, vous implémentez l'algorithme de bruit de Perlin en utilisant les variables x et y ajustées
		// ...

		// Retourne la valeur finale du bruit de Perlin pour (x, y)
		// (Le code détaillé pour le calcul du bruit de Perlin doit être ajouté ici)
		return 0; // Retourne une valeur temporaire; remplacez par votre calcul réel
	}
}
