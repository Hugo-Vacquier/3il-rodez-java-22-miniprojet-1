package fr.ecole3il.rodez2023.perlin;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * 
 * @author proussille
 * La classe Utils fournit des méthodes utilitaires pour diverses opérations génériques.
 * Elle offre des fonctionnalités telles que le chargement d'images, le mélange de tableaux, etc.
 */
public class Utils {

    /** Le répertoire de stockage des tuiles */
    public static final String REPERTOIRE_TUILES = "data/tiles/";

    /**
     * Charge une image à partir d'un fichier spécifié.
     * @param nomFichier Le nom du fichier image à charger.
     * @return Une instance de BufferedImage représentant l'image chargée.
     */
    public static BufferedImage chargerTuile(String nomFichier) {
        try {
            String imagePath = REPERTOIRE_TUILES + nomFichier;
            BufferedImage image = ImageIO.read(new File(imagePath));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        // Ce code ne sera en pratique jamais exécuté.
        return null;
    }

    /**
     * Mélange les éléments d'un tableau d'entiers en utilisant une graine spécifiée,
     * avec l'algorithme Fisher-Yates (ou Knuth Shuffle).
     * @param tab Le tableau à mélanger.
     * @param seed La graine utilisée pour le mélange.
     * @return Un nouveau tableau contenant les éléments mélangés.
     * 
     * @author philibert roquart, fainéant
     */
    /**
     * Mélange le tableau donné de manière déterministe en utilisant la graine spécifiée.
     *
     * @param array Le tableau à mélanger.
     * @param seed La graine à utiliser pour le mélange.
     */
    public static void melanger(int[] array, long seed) {
        Random rnd = new Random(seed);
        for (int i = array.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple échange d'éléments
            int a = array[index];
            array[index] = array[i];
            array[i] = a;
        }
    }

    /**
     * Retourne la plus petite des deux valeurs passées en paramètres.
     *
     * @param width La première valeur à comparer.
     * @param height La seconde valeur à comparer.
     * @return La valeur minimale entre 'width' et 'height'.
     */
    public static double min(int width, int height) {
        return Math.min(width, height);
    }

    /**
     * Lit le contenu d'un fichier texte et le retourne sous forme de chaîne de caractères.
     * @param cheminFichier Le chemin vers le fichier à lire.
     * @return Le contenu du fichier lu sous forme de chaîne de caractères.
     * 
     * Cette fonction n'est pas commentée, on la verra en Java Avancé.
     */
    public static String lireContenuFichier(String cheminFichier) {
        StringBuilder contenu = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                contenu.append(ligne).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contenu.toString();
    }    
}

