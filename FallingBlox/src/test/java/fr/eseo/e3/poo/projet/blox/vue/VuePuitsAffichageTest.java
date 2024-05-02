package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.controleur.Gravite;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;

import javax.swing.*;
import java.awt.*;

public class VuePuitsAffichageTest {

    public VuePuitsAffichageTest() {
        testConstructeurPuits();
        //testConstructeurPuitsTaille();
    }
    private static void testConstructeurPuits(){

        //Créer le JPanel
        JFrame f = new JFrame("Puits");
        Puits puits = new Puits(10, 20, 29, 5);
        VuePuits vuePuits = new VuePuits(puits);

        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_PIECE);

        vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererPiece());
        vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererPiece());

        Gravite gravite = new Gravite(vuePuits);

        PanneauInformation panneauInformation = new PanneauInformation(puits);

        Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int ecranHauteur = (int)tailleEcran.getHeight();
        int ecranLargeur = (int)tailleEcran.getWidth();

        //Ajouter le JPanel au JFrame
        f.add(vuePuits);
        f.add(panneauInformation);
        vuePuits.setBounds(5, 5, vuePuits.getPreferredSize().width, vuePuits.getPreferredSize().height);
        panneauInformation.setBounds(vuePuits.getPreferredSize().width + 5, 5, panneauInformation.getPreferredSize().width, panneauInformation.getPreferredSize().height);

        f.setLayout(null);

        f.setSize(vuePuits.getPreferredSize().width + panneauInformation.getPreferredSize().width + 22, vuePuits.getPreferredSize().height + 45);

        //f.pack();

        f.setLocation((ecranLargeur - f.getWidth())/2,
                (ecranHauteur - f.getHeight())/2);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    private static void testConstructeurPuitsTaille(){

        //Créer le JPanel
        JFrame f = new JFrame("Puits et taille");
        Puits puits = new Puits(10, 20);
        VuePuits P = new VuePuits(puits);
        f.add(P);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }


public static void main (String [] args) {
    SwingUtilities.invokeLater(new Runnable () {
        @Override
        public void run() {
            new VuePuitsAffichageTest();
        }
    });
}
}
