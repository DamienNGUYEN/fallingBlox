package fr.eseo.e3.poo.projet.blox.modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoordonneesTest {
    Coordonnees cooTest = new Coordonnees(4, 7);

    @Test
    public void getAbscisseTest (){
        assertEquals(4, cooTest.getAbscisse());
    }

    @Test
    public void getOrdonneeTest (){
        assertEquals(7, cooTest.getOrdonnee());
    }

    @Test
    public void setAbscisseTest (){
        cooTest.setAbscisse(3);
        assertEquals(3, cooTest.getAbscisse());
    }

    @Test
    public void setOrdonneeTest (){
        cooTest.setOrdonnee(2);
        assertEquals(2, cooTest.getOrdonnee());
    }

    @Test
    public void toStringTest (){
        assertEquals("(4, 7)", cooTest.toString());
    }

    @Test
    public void equalsTest (){
        Coordonnees cooEquals = new Coordonnees(4, 7);
        assertTrue(cooTest.equals(cooEquals));
        assertTrue(cooTest.equals(cooTest));
    }

    @Test
    public void hashCodeTest (){
        Coordonnees cooEquals = new Coordonnees(4, 7);
        assertEquals(cooEquals.hashCode(), cooTest.hashCode());
    }
}
