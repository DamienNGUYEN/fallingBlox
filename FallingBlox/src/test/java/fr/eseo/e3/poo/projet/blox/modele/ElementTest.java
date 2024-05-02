package fr.eseo.e3.poo.projet.blox.modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ElementTest {

    Element elmt = new Element(5, 7, Couleur.VIOLET);

    @Test
    public void getCoordonneesTest(){
        Coordonnees coo = new Coordonnees(5, 7);
        assertEquals(coo, elmt.getCoordonnees());
    }

    @Test
    public void getColorTest(){
        assertEquals(Couleur.VIOLET, elmt.getCouleur());
    }

    @Test
    public void setCoordonneesTest(){
        Coordonnees coo = new Coordonnees(5, 7);
        elmt.setCoordonnees(coo);
        assertEquals(coo, elmt.getCoordonnees());
    }

    @Test
    public void setCouleurTest(){
        elmt.setCouleur(Couleur.VERT);
        assertEquals(Couleur.VERT, elmt.getCouleur());
    }

    @Test
    public void toStringTest(){
        assertEquals("(5, 7) - VIOLET", elmt.toString());
    }

    @Test
    public void equalsTest (){
        Element elmtTest = new Element(5, 7, Couleur.VIOLET);
        assertTrue(elmt.equals(elmtTest));
        assertTrue(elmt.equals(elmt));
    }

    @Test
    public void hashCodeTest (){
        Element elmtTest = new Element(5, 7, Couleur.VIOLET);
        assertEquals(elmtTest.hashCode(), elmtTest.hashCode());
    }


}
