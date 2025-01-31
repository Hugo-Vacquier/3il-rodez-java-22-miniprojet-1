package fr.ecole3il.rodez2023.perlin.gui;

import fr.ecole3il.rodez2023.perlin.terrain.carte.Carte;
import fr.ecole3il.rodez2023.perlin.terrain.carte.ManipulateurCarte;
import fr.ecole3il.rodez2023.perlin.terrain.concrets.VisualiseurTerrainEnonce;
import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.generation.GenerateurAleatoire;
import fr.ecole3il.rodez2023.perlin.terrain.generation.GenerateurPerlin;
import fr.ecole3il.rodez2023.perlin.terrain.visualisation.DetermineurTerrain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * 
 * @author proussille
 * La classe VisualiseurCarteTerrain représente un visualiseur de carte de terrain
 * qui permet de charger, enregistrer et générer des cartes, ainsi que d'afficher leur représentation graphique.
 */
public class VisualiseurCarteTerrain extends JFrame {
	private DetermineurTerrain determineurTerrain;
	private Carte carte;
	private JPanel cartePanel;
	private JLabel terrainLabel;

    private static final long serialVersionUID = -4664266628089280746L;
    private VisualiseurTerrainEnonce vte;

    /**
     * Dessine la carte sur le panneau graphique.
     * @param carte La carte à dessiner.
     * @param g L'objet Graphics pour dessiner.
     * @param panelWidth La largeur du panneau.
     * @param panelHeight La hauteur du panneau.
     */
	public void drawCarte(Carte carte, Graphics g, int panelWidth, int panelHeight) {
		DetermineurTerrain dt = carte.getDetermineurTerrain(); // Récupérez-le depuis la Carte
		int largeur = carte.getLargeur();
		int hauteur = carte.getHauteur();
		int tuileWidth = panelWidth / largeur;
		int tuileHeight = panelHeight / hauteur;

		for (int y = 0; y < hauteur; y++) {
			for (int x = 0; x < largeur; x++) {
				Terrain terrain = carte.getTerrain(x, y);
				TypeTerrain type = terrain.getTypeTerrain(dt); // Utilisez le DetermineurTerrain ici
				BufferedImage image = type.getImage(); // Assurez-vous que cette méthode existe et retourne l'image correcte
				g.drawImage(image, x * tuileWidth, y * tuileHeight, tuileWidth, tuileHeight, null);
			}
		}
	}
	public VisualiseurCarteTerrain(DetermineurTerrain dt) {
		this.determineurTerrain = dt;
		VisualiseurCarteTerrain monObjet = this;
		setTitle("Visualiseur de Carte");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Panel pour afficher la carte
		cartePanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (carte != null) {
					monObjet.drawCarte(carte, g, getWidth(), getHeight());
				}
			}
		};
		cartePanel.setOpaque(true);

		cartePanel.addMouseMotionListener(new MouseAdapter() {
		    @Override
		    public void mouseMoved(MouseEvent e) {
		        int tuileWidth = cartePanel.getWidth() / carte.getLargeur();
		        int tuileHeight = cartePanel.getHeight() / carte.getHauteur();

		        int x = e.getX() / tuileWidth;
		        int y = e.getY() / tuileHeight;

		        System.out.println("Coordonnées de la souris - X: " + x + ", Y: " + y);

				if (x >= 0 && x < carte.getLargeur() && y >= 0 && y < carte.getHauteur()) {
					Terrain terrain = carte.getTerrain(x, y); // Obtenez l'objet Terrain pour la position (x, y)
					TypeTerrain type = determineurTerrain.determinerTerrain(terrain.getAltitude(), terrain.getHydrometrie(), terrain.getTemperature()); // Utilisez DetermineurTerrain pour obtenir le TypeTerrain
					terrainLabel.setText("Terrain: " + type.toString()); // Mettez à jour le label avec le nom du TypeTerrain
				}

			}

		    @Override
		    public void mouseExited(MouseEvent e) {
		        terrainLabel.setText("Terrain: "); // Efface le texte quand la souris quitte la zone de la carte
		    }
		});
		
		cartePanel.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        int tuileWidth = cartePanel.getWidth() / carte.getLargeur();
		        int tuileHeight = cartePanel.getHeight() / carte.getHauteur();

		        int x = e.getX() / tuileWidth;
		        int y = e.getY() / tuileHeight;

				if (x >= 0 && x < carte.getLargeur() && y >= 0 && y < carte.getHauteur()) {
					Terrain terrain = carte.getTerrain(x, y); // Récupérer le Terrain à la position (x, y)
					// Formater le contenu avec les informations du Terrain
					String contenu = "Altitude: " + terrain.getAltitude() +
							"\nHydrométrie: " + terrain.getHydrometrie() +
							"\nTempérature: " + terrain.getTemperature();
					// Afficher la fenêtre modale
					JOptionPane.showMessageDialog(cartePanel, contenu, "Informations de la tuile", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		add(cartePanel, BorderLayout.CENTER);

		// Barre de menu avec les options
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Carte");

		JMenuItem chargerItem = new JMenuItem("Charger une carte");
		chargerItem.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        JFileChooser fileChooser = new JFileChooser();
		        int choix = fileChooser.showOpenDialog(VisualiseurCarteTerrain.this);

		        if (choix == JFileChooser.APPROVE_OPTION) {
		            File fichierSelectionne = fileChooser.getSelectedFile();
		            String cheminFichier = fichierSelectionne.getAbsolutePath();

		            // Charger la carte à partir du fichier sélectionné
		            carte = ManipulateurCarte.chargerCarte(cheminFichier);

		            // Repaint ou rafraîchir l'affichage
		            repaint();
		        }
		    }
		});
		
		JMenuItem enregistrerItem = new JMenuItem("Enregistrer la carte");
		enregistrerItem.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        JFileChooser fileChooser = new JFileChooser();
		        int choix = fileChooser.showSaveDialog(VisualiseurCarteTerrain.this);

		        if (choix == JFileChooser.APPROVE_OPTION) {
		            File fichierSelectionne = fileChooser.getSelectedFile();
		            String cheminFichier = fichierSelectionne.getAbsolutePath();

		            // Enregistrer la carte dans le fichier sélectionné
		            ManipulateurCarte.enregistrerCarte(carte, cheminFichier);
		        }
		    }
		});


		JMenuItem genererItem = new JMenuItem("Générer une carte");
		genererItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				genererCarteDialogue();
			}
		});

		menu.add(chargerItem);
		menu.add(enregistrerItem);
		menu.add(genererItem);
		menuBar.add(menu);
		setJMenuBar(menuBar);
		// Création du label pour afficher le type de terrain
        terrainLabel = new JLabel("Terrain: ");
        add(terrainLabel, BorderLayout.SOUTH); // Ajout du label en bas de la fenêtre
	}

	private void genererCarteDialogue() {
		JTextField largeurField = new JTextField(5);
		JTextField hauteurField = new JTextField(5);
		JTextField graineAlea = new JTextField(5);

		JPanel choixPanel = new JPanel();
		choixPanel.add(new JLabel("Largeur:"));
		choixPanel.add(largeurField);
		choixPanel.add(new JLabel("Hauteur:"));
		choixPanel.add(hauteurField);
		choixPanel.add(new JLabel("Graine aléatoire:"));
		choixPanel.add(graineAlea);
		graineAlea.setText(Long.toString(System.currentTimeMillis()));

		String[] generateurOptions = { "GenerateurPerlin", "GenerateurAleatoire" };
		JComboBox<String> generateurBox = new JComboBox<>(generateurOptions);

		JOptionPane.showMessageDialog(null, choixPanel, "Paramètres de génération", JOptionPane.QUESTION_MESSAGE);
		int result = JOptionPane.showConfirmDialog(null, generateurBox, "Choix du générateur",
				JOptionPane.OK_CANCEL_OPTION);

		if (result == JOptionPane.OK_OPTION) {
			int largeur = Integer.parseInt(largeurField.getText());
			int hauteur = Integer.parseInt(hauteurField.getText());
			long graine = Long.parseLong(graineAlea.getText());
			String generateurSelectionne = (String) generateurBox.getSelectedItem();

			// Code pour générer la carte en fonction des paramètres choisis
			if (generateurSelectionne.equals("GenerateurPerlin")) {
				carte = new Carte("Nouvelle carte", largeur, hauteur, new GenerateurPerlin(graine));
			} else {
				carte = new Carte("Nouvelle carte", largeur, hauteur,
						new GenerateurAleatoire(graine));
			}

			repaint();
		}
	}



	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			VisualiseurCarteTerrain visualiseur = new VisualiseurCarteTerrain();
			visualiseur.setVisible(true);
		});
	}
}
