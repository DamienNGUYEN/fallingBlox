package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuitsTest {
    Puits puits = new Puits();
    Coordonnees coo = new Coordonnees(4, 4);
    IPiece piece1 = new IPiece(coo, Couleur.CYAN);
    Coordonnees coo2 = new Coordonnees(8, 8);
    OPiece piece2 = new OPiece(coo2, Couleur.VIOLET);
    Coordonnees coo3 = new Coordonnees(5, 8);
    IPiece piece3 = new IPiece(coo3, Couleur.JAUNE);

    @Test
    public void setPieceSuivanteTest(){
        puits.setPieceSuivante(piece1);
        assertEquals(piece1, puits.getPieceSuivante());

        puits.setPieceSuivante(piece2);
        assertEquals(piece1, puits.getPieceActuelle());
        assertEquals(piece2, puits.getPieceSuivante());

        puits.setPieceSuivante(piece3);
        assertEquals(piece2, puits.getPieceActuelle());
        assertEquals(piece3, puits.getPieceSuivante());
    }

    @Test
    public void toStringTest(){
        puits.setPieceSuivante(piece1);
        assertEquals(piece1, puits.getPieceSuivante());

        assertEquals("Puits : Dimension 10 x 20" +
                "\nPiece Actuelle : <aucune>" +
                "\nPiece Suivante : IPiece :\n" +
                piece1.toString(), puits.toString());
    }
}
























