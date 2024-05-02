package fr.eseo.e3.poo.projet.blox.modele;

import javafx.geometry.Orientation;

import java.util.Objects;

public class Coordonnees {
    private int abscisse;
    private int ordonnee;

    public Coordonnees (int abscisse, int ordonnee){
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
    }

    //Accesseurs et mutateurs
    public int getAbscisse(){
        return abscisse;
    }

    public int getOrdonnee(){
        return ordonnee;
    }

    public void setAbscisse(int abscisse){
        this.abscisse = abscisse;
    }

    public void setOrdonnee(int ordonnee){
        this.ordonnee = ordonnee;
    }

    //Methodes

    @Override
    public String toString(){
        return "(" + String.valueOf(abscisse) + ", " + String.valueOf(ordonnee) + ")";
    }

    @Override
    public boolean equals (Object obj){
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;
        //else
        Coordonnees objCoo = (Coordonnees) obj;
        return this.abscisse == objCoo.abscisse && this.ordonnee == objCoo.ordonnee;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(abscisse, ordonnee);
    }
}




















