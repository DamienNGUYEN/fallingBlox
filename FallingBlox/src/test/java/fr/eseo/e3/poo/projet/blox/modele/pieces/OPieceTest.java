package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OPieceTest {

    Coordonnees coo = new Coordonnees(4, 7);
    OPiece Op = new OPiece(coo, Couleur.CYAN);


    @Test
    public void getElementTest(){
        Coordonnees coo = new Coordonnees(4, 7);
        Coordonnees coo1 = new Coordonnees(5, 7);
        Coordonnees coo2 = new Coordonnees(4, 6);
        Coordonnees coo3 = new Coordonnees(5, 6);

        Element elmt = new Element(coo, Couleur.CYAN);
        Element elmt1 = new Element(coo1, Couleur.CYAN);
        Element elmt2 = new Element(coo2, Couleur.CYAN);
        Element elmt3 = new Element(coo3, Couleur.CYAN);

        ArrayList test = new ArrayList<Element>();

        test.add(elmt);
        test.add(elmt1);
        test.add(elmt2);
        test.add(elmt3);

        assertEquals(test, Op.getElements());
    }

    @Test
    public void toStringTest(){
        assertEquals("    (4, 7) - CYAN\n    (5, 7) - CYAN\n    (4, 6) - CYAN\n    (5, 6) - CYAN", Op.toString());
    }

    @Test
    public void setPosition(){
        Op.setPosition(2, 6);
        assertEquals("    (2, 6) - CYAN\n    (3, 6) - CYAN\n    (2, 5) - CYAN\n    (3, 5) - CYAN", Op.toString());
    }

    @Test
    public void deplacerDeTestValide1() throws BloxException {
        Op.deplacerDe(1, 1);
        assertEquals("    (5, 8) - CYAN\n    (6, 8) - CYAN\n    (5, 7) - CYAN\n    (6, 7) - CYAN", Op.toString());
    }

    @Test
    public void deplacerDeTestValide2() throws BloxException {
        Op.deplacerDe(-1, 1);
        assertEquals("    (3, 8) - CYAN\n    (4, 8) - CYAN\n    (3, 7) - CYAN\n    (4, 7) - CYAN", Op.toString());
    }

    @Test
    public void deplacerDeTestInvalide1(){
        assertThrows(IllegalArgumentException.class,
                ()->{
                    Op.deplacerDe(-1, -1);
                }
        );
    }

    @Test
    public void deplacerDeTestInvalide2(){
        assertThrows(IllegalArgumentException.class,
                ()->{
                    Op.deplacerDe(-3, 0);
                }
        );

    }

    @Test
    public void tournerTest(){
        Op.tourner(true);
        assertEquals("    (4, 7) - CYAN\n    (5, 7) - CYAN\n    (4, 6) - CYAN\n    (5, 6) - CYAN", Op.toString());
    }
}
