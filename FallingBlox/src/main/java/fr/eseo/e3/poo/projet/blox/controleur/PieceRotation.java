package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePiece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.*;
import  java.awt.event.*;

public class PieceRotation extends MouseAdapter {
    private VuePuits vuePuits;
    private Puits puits;

    public PieceRotation(VuePuits vuePuits){
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        if ( SwingUtilities.isRightMouseButton(event)){
            try {
                puits.getPieceActuelle().tourner(true);
            } catch (BloxException e) {
                throw new RuntimeException(e);
            }
        }
        else if ( SwingUtilities.isLeftMouseButton(event)){
            try {
                puits.getPieceActuelle().tourner(false);
            } catch (BloxException e) {
                throw new RuntimeException(e);
            }
        }

        //Peut-être à supprimer
        vuePuits.repaint();
    }
}
