package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VuePiece extends JPanel {
    public static final double MULTIPLIER_TEINTE = 0.5;
    private int taille;
    private final Piece piece;

    public VuePiece(Piece piece, int taille){
        this.piece = piece;
        this.taille = taille;
    }

    public Color teinte(Color couleur){
        double R = couleur.getRed();
        double G = couleur.getGreen();
        double B = couleur.getBlue();

        R = R +(255 - R) * MULTIPLIER_TEINTE;
        G = G +(255 - G) * MULTIPLIER_TEINTE;
        B = B +(255 - B) * MULTIPLIER_TEINTE;

        return new Color((int) R, (int) G, (int) B);
    }

    protected void afficherPiece(Graphics2D g2D){
        ArrayList<Element> elements = piece.getElements();

        g2D.setColor(teinte(elements.get(0).getCouleur().getCouleurPourAffichage()));
        g2D.fill3DRect((elements.get(0).getCoordonnees().getAbscisse()) * taille,
                (elements.get(0).getCoordonnees().getOrdonnee()) * taille,
                taille,
                taille,
                true);

        g2D.setColor(elements.get(1).getCouleur().getCouleurPourAffichage());
        for (int i=1; i < 4; i++) {
            g2D.fill3DRect((elements.get(i).getCoordonnees().getAbscisse()) * taille,
                    (elements.get(i).getCoordonnees().getOrdonnee()) * taille,
                    taille,
                    taille,
                    true);
        }
    }
}
