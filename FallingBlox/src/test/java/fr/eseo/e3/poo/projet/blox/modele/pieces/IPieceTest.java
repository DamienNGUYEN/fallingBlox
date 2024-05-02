package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IPieceTest {
    Coordonnees coo = new Coordonnees(4, 7);
    IPiece Ip = new IPiece(coo, Couleur.CYAN);


    @Test
    public void getElementTest(){
        Coordonnees coo = new Coordonnees(4, 7);
        Coordonnees coo1 = new Coordonnees(4, 5);
        Coordonnees coo2 = new Coordonnees(4, 6);
        Coordonnees coo3 = new Coordonnees(4, 8);

        Element elmt = new Element(coo, Couleur.CYAN);
        Element elmt1 = new Element(coo1, Couleur.CYAN);
        Element elmt2 = new Element(coo2, Couleur.CYAN);
        Element elmt3 = new Element(coo3, Couleur.CYAN);

        ArrayList test = new ArrayList<Element>();

        test.add(elmt);
        test.add(elmt1);
        test.add(elmt2);
        test.add(elmt3);

        assertEquals(test, Ip.getElements());
    }

    @Test
    public void toStringTest(){
        assertEquals("    (4, 7) - CYAN\n    (4, 5) - CYAN\n    (4, 6) - CYAN\n    (4, 8) - CYAN", Ip.toString());
    }

    @Test
    public void setPosition(){
        Ip.setPosition(2, 6);
        assertEquals("    (2, 6) - CYAN\n    (2, 4) - CYAN\n    (2, 5) - CYAN\n    (2, 7) - CYAN", Ip.toString());
    }

    @Test
    public void tournerTest90() throws BloxException {
        Ip.tourner(true);
        assertEquals("    (4, 7) - CYAN\n    (6, 7) - CYAN\n    (5, 7) - CYAN\n    (3, 7) - CYAN", Ip.toString());
    }

    @Test
    public void tournerTest180() throws BloxException {
        Ip.tourner(true);
        Ip.tourner(true);
        assertEquals("    (4, 7) - CYAN\n    (4, 9) - CYAN\n    (4, 8) - CYAN\n    (4, 6) - CYAN", Ip.toString());
    }

    @Test
    public void tournerTestMoins90() throws BloxException {
        Ip.tourner(false);
        assertEquals("    (4, 7) - CYAN\n    (2, 7) - CYAN\n    (3, 7) - CYAN\n    (5, 7) - CYAN", Ip.toString());
    }
}
