package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.*;
import java.awt.event.*;

public class PieceDeplacement extends MouseAdapter {
    private final VuePuits vuePuits;
    private final Puits puits;
    private int derniereColonne = -1;

    public PieceDeplacement(VuePuits vuePuits){
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
    }

    @Override
    public void mouseMoved(MouseEvent event) {
        if (puits.getPieceActuelle() != null){
            int x = event.getX()/vuePuits.getTaille();
            if (derniereColonne  < 0){
                derniereColonne = x;
            }
            else if (derniereColonne != x){
                int deltaX = 1;
                if (x < derniereColonne){deltaX = -1;}

                for (int i = 0; i < Math.abs(x - derniereColonne); i++) {
                    try {
                        puits.getPieceActuelle().deplacerDe(deltaX, 0);
                    } catch (BloxException ignored) {}
                    derniereColonne = x;

                    //Peut-être à supprimer
                    vuePuits.repaint();
                }
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent event){
        derniereColonne = event.getX()/vuePuits.getTaille();
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent event){
        if (puits.getPieceActuelle() != null){
            if (event.getWheelRotation() > 0){
                try {
                    puits.getPieceActuelle().deplacerDe(0, 1);
                } catch (BloxException ignored) {}

                //Peut-être à supprimer
                vuePuits.repaint();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        if (SwingUtilities.isMiddleMouseButton(evt)) {
            while(true){
                try{
                    puits.getPieceActuelle().deplacerDe(0,1);
                }catch(BloxException e){
                    return;
                }
            }
        }
    }
}
