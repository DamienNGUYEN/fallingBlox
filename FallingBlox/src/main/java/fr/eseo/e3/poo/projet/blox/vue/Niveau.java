package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Niveau extends JLabel implements PropertyChangeListener {
    private Puits puits;

    public Niveau(Puits puits){
        this.puits = puits;
        puits.getTas().addPropertyChangeListener(this);
        this.setText("Niveau : 1");
        this.setPreferredSize(new Dimension(60, 20));
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if (event.getPropertyName().equals(puits.getTas().NOUVEAU_NIVEAU)) {
            this.setText("Niveau : " + String.valueOf(event.getNewValue()));
            this.repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}