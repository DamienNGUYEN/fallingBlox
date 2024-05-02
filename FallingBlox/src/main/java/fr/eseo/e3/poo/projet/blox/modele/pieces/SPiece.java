package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class SPiece extends Piece{

    public SPiece(Coordonnees coordonnees, Couleur couleur) {
        super(coordonnees, couleur);
    }

    protected void setElements(Coordonnees coordonnees, Couleur couleur) {
        Coordonnees coo1 = new Coordonnees(coordonnees.getAbscisse() - 1, coordonnees.getOrdonnee());
        Coordonnees coo2 = new Coordonnees(coordonnees.getAbscisse(), coordonnees.getOrdonnee() - 1);
        Coordonnees coo3 = new Coordonnees(coordonnees.getAbscisse() + 1, coordonnees.getOrdonnee() - 1);

        Element elmt1 = new Element(coordonnees, couleur);
        Element elmt2 = new Element(coo1, couleur);
        Element elmt3 = new Element(coo2, couleur);
        Element elmt4 = new Element(coo3, couleur);

        this.getElements().add(elmt1);
        this.getElements().add(elmt2);
        this.getElements().add(elmt3);
        this.getElements().add(elmt4);
    }

}
