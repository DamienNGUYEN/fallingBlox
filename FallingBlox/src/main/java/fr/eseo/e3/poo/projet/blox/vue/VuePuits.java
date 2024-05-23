package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.controleur.PieceDeplacement;
import fr.eseo.e3.poo.projet.blox.controleur.PieceDeplacementClavier;
import fr.eseo.e3.poo.projet.blox.controleur.PieceRotation;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

import javax.swing.*;
import java.awt.*;
import java.beans.*;

public class VuePuits extends JPanel implements PropertyChangeListener {
    public int TAILLE_PAR_DEFAUT = 20;
    private Puits puits;
    private int taille;
    private VuePiece vuePiece;
    public VueTas vueTas;

    public VuePuits(Puits puits){
        this.puits = puits;
        this.taille = TAILLE_PAR_DEFAUT;
        this.setPreferredSize(new Dimension(TAILLE_PAR_DEFAUT * puits.getLargeur() +2, TAILLE_PAR_DEFAUT * puits.getProfondeur() +2));
        vueTas = new VueTas(this);

        //Cette ligne permet de faire fonctionner le clavier
        //Vouez-lui un culte s'il-vous-plaît, son existance m'est salvatrice
        setFocusable(true);

        //Listeners
        puits.addPropertyChangeListener(this);
        PieceDeplacement pieceDeplacement = new PieceDeplacement(this);
        PieceDeplacementClavier pieceDeplacementClavier = new PieceDeplacementClavier(this);
        this.addMouseMotionListener(pieceDeplacement);
        this.addMouseListener(pieceDeplacement);
        this.addMouseWheelListener(pieceDeplacement);

        this.addKeyListener(pieceDeplacementClavier);

        this.addMouseListener(new PieceRotation(this));
    }

    public VuePuits(Puits puits, int taille){
        this.puits = puits;
        this.taille = taille;
        this.setPreferredSize(new Dimension(taille * puits.getLargeur() +2, taille * puits.getProfondeur() +2));

        //Listeners
        puits.addPropertyChangeListener(this);
        this.addMouseMotionListener(new PieceDeplacement(this));
        this.addKeyListener(new PieceDeplacementClavier(this));
    }

    //Accesseurs
    public Puits getPuits() {
        return puits;
    }

    public int getTaille() {
        return this.taille;
    }

    public VuePiece getVuePiece() {
        return vuePiece;
    }

    public VueTas getVueTas() {
        return vueTas;
    }

    //Mutateur
    public void setPuits(Puits puits) {
        this.puits = puits;
    }

    public void setTaille(int taille) {
        this.setPreferredSize(new Dimension(taille * puits.getLargeur() +2, taille * puits.getProfondeur() +2));
        this.taille = taille;
    }

    private void setVuePiece(VuePiece vuePiece) {
        this.vuePiece = vuePiece;
    }

    //Methodes

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        /*Le paramètre g est copie en utilisant la méthode copie()
         * puis converti en instance de Graphics2D grâce à
         * un transtypage (cast) explicite.
         */
        Graphics2D g2D = (Graphics2D)g.create();
        /* Nous utiliserons l'instance de Graphics2D*/

        //Affichage de la grille
        g.setColor(java.awt.Color.LIGHT_GRAY);

        for (int y = 0; y <puits.getProfondeur(); y++) {
            for (int x = 0; x <puits.getLargeur(); x++) {
                g.drawRect(x * taille, y * this.taille, this.taille, this.taille);
            }
        }

        //Affichage du tas
        vueTas.afficher(g2D);

        //Affichage de la piece Actuelle
        if (vuePiece != null) {
            vuePiece.afficherPiece(g2D);
        }

        /*Puis nous liberons la memoire*/
        g2D.dispose();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName() != null && evt.getPropertyName().equals(getPuits().MODIFICATION_PIECE_ACTUELLE)){
            setVuePiece(new VuePiece(puits.getPieceActuelle(), taille));
        }
    }
}
