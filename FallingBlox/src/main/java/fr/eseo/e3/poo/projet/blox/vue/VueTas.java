package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Tas;

import java.awt.*;

public class VueTas {
    public double MULTIPLIER_NUANCE = 0.5;
    private VuePuits vuePuits;
    private Tas tas;

    public VueTas(VuePuits vuePuits){
        this.vuePuits = vuePuits;
        tas = vuePuits.getPuits().getTas();
    }

    public VuePuits getVuePuits() {
        return vuePuits;
    }

    public Color nuance(Color couleur){
        double R = couleur.getRed();
        double G = couleur.getGreen();
        double B = couleur.getBlue();

        R = R * (1 - MULTIPLIER_NUANCE);
        G = G * (1 - MULTIPLIER_NUANCE);
        B = B * (1 - MULTIPLIER_NUANCE);

        return new Color((int) R, (int) G, (int) B);
    }

    public void afficher(Graphics2D g2D){
        int taille = vuePuits.getTaille();
        Element[][] elements = tas.getElements();
        for (int y=0; y<vuePuits.getPuits().getProfondeur(); y++){
            for (int x=0; x<vuePuits.getPuits().getLargeur(); x++){
                if(elements[y][x] != null) {
                    g2D.setColor(nuance(elements[y][x].getCouleur().getCouleurPourAffichage()));

                    g2D.fill3DRect((x) * taille,
                            (y) * taille,
                            taille,
                            taille,
                            true);
                }
            }
        }
    }
}
