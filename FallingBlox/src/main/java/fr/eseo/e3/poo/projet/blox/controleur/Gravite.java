package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gravite implements ActionListener {
    private Timer timer;
    private VuePuits vuePuits;
    private Puits puits;

    public Gravite(VuePuits vuePuits){
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
        timer = new Timer(500, this);
        timer.start();
    }

    public int getPeriodicite(){
        return timer.getDelay();
    }

    public void setPeriodicite(int periodicite){
        this.timer.setDelay(periodicite);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        puits.gravite();

        //Peut-être à supprimer
        vuePuits.repaint();
    }
}
