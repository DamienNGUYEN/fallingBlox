package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.controleur.Gravite;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;

import javax.swing.*;
import java.awt.*;

public class Game {

    public Game(int mode) {
        //Créer le JPanel
        JFrame f = new JFrame("Falling Blox");
        Puits puits = new Puits(10, 20, 29, 5);
        VuePuits vuePuits = new VuePuits(puits);

        UsineDePiece.setMode(mode);

        vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererPiece());
        vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererPiece());

        Gravite gravite = new Gravite(vuePuits);

        PanneauInformation panneauInformation = new PanneauInformation(puits);
        Score score = new Score(puits);

        Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int ecranHauteur = (int)tailleEcran.getHeight();
        int ecranLargeur = (int)tailleEcran.getWidth();

        //Ajouter le JPanel au JFrame
        f.add(vuePuits);
        f.add(panneauInformation);
        f.add(score);
        vuePuits.setBounds(5, 5, vuePuits.getPreferredSize().width, vuePuits.getPreferredSize().height);
        panneauInformation.setBounds(vuePuits.getPreferredSize().width + 5, 5, panneauInformation.getPreferredSize().width, panneauInformation.getPreferredSize().height);
        score.setBounds(vuePuits.getPreferredSize().width + 10, panneauInformation.getPreferredSize().height + 10, score.getPreferredSize().width, score.getPreferredSize().height);

        f.setLayout(null);

        f.setSize(vuePuits.getPreferredSize().width + panneauInformation.getPreferredSize().width + 22, vuePuits.getPreferredSize().height + 45);

        f.setResizable(false);

        f.setLocation((ecranLargeur - f.getWidth())/2,
                (ecranHauteur - f.getHeight())/2);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
