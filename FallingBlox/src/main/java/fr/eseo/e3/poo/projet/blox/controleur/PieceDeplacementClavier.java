package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PieceDeplacementClavier extends KeyAdapter {

    private final VuePuits vuePuits;
    private final Puits puits;

    public PieceDeplacementClavier(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(puits.getPieceActuelle() == null)
            return;

        //Déplacer la pièce
        if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_Q){
            try{
                puits.getPieceActuelle().deplacerDe(-1, 0);
            }catch(BloxException ignored){}
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D){
            try{
                puits.getPieceActuelle().deplacerDe(1,0);
            }catch(BloxException ignored){}
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S){
            try{
                puits.getPieceActuelle().deplacerDe(0,1);
            }catch(BloxException ignored){}
        }

        //Tourner la pièce
        else if(e.getKeyCode() == KeyEvent.VK_A){
            try{
                puits.getPieceActuelle().tourner(false);
            }catch(BloxException ignored){}
        }
        else if(e.getKeyCode() == KeyEvent.VK_E){
            try{
                puits.getPieceActuelle().tourner(true);
            }catch(BloxException ignored){}
        }

        //Descente directe, équivalent du clic molette
        else if(e.getKeyCode() == KeyEvent.VK_SPACE){
            while(true){
                try{
                    puits.getPieceActuelle().deplacerDe(0,1);
                }catch(BloxException exception){
                    return;
                }
            }
        }

        vuePuits.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        super.keyTyped(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
    }
}
