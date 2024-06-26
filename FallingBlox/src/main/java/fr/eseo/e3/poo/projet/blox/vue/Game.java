package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.controleur.Gravite;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;

import javax.swing.*;
import java.awt.*;

public class Game {

    public Game(int mode, int nbElements) {
        //Créer le JPanel
        JFrame f = new JFrame("Falling Blox");
        Puits puits;
        if (nbElements == 0){
            puits = new Puits(10, 20);
        }
        else {
            puits = new Puits(10, 20, nbElements);
        }
        VuePuits vuePuits = new VuePuits(puits);

        UsineDePiece.setMode(mode);

        vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererPiece());
        vuePuits.getPuits().setPieceSuivante(UsineDePiece.genererPiece());

        Gravite gravite = new Gravite(vuePuits);

        PanneauInformation panneauInformation = new PanneauInformation(puits);
        Score score = new Score(puits);
        Niveau niveau = new Niveau(puits);

        Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int ecranHauteur = (int)tailleEcran.getHeight();
        int ecranLargeur = (int)tailleEcran.getWidth();

        JLabel labelScore = new JLabel("Score :");

        //Ajouter le JPanel au JFrame
        f.add(vuePuits);
        f.add(panneauInformation);
        f.add(score);
        f.add(labelScore);
        f.add(niveau);
        vuePuits.setBounds(5, 5, vuePuits.getPreferredSize().width, vuePuits.getPreferredSize().height);
        panneauInformation.setBounds(vuePuits.getPreferredSize().width + 5, 5, panneauInformation.getPreferredSize().width, panneauInformation.getPreferredSize().height);
        score.setBounds(vuePuits.getPreferredSize().width + 10, panneauInformation.getPreferredSize().height + 30, score.getPreferredSize().width, score.getPreferredSize().height);
        labelScore.setBounds(vuePuits.getPreferredSize().width + 10, panneauInformation.getPreferredSize().height + 10, score.getPreferredSize().width, score.getPreferredSize().height);
        niveau.setBounds(vuePuits.getPreferredSize().width + 10, panneauInformation.getPreferredSize().height + 50, niveau.getPreferredSize().width, niveau.getPreferredSize().height);


        f.setLayout(null);

        f.setSize(vuePuits.getPreferredSize().width + panneauInformation.getPreferredSize().width + 22, vuePuits.getPreferredSize().height + 45);

        f.setResizable(false);

        f.setLocation((ecranLargeur - f.getWidth())/2,
                (ecranHauteur - f.getHeight())/2);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
