package fr.eseo.e3.poo.projet.blox.modele;

//import java.lang.classfile.attribute.CompilationIDAttribute;
import java.util.Objects;

public class Element {
    private Coordonnees coordonnees;
    private Couleur couleur;

    public Element(Coordonnees coordonnees){
        this.coordonnees = coordonnees;
        this.couleur = Couleur.ROUGE;
    }

    public Element(int abscisse, int ordonnee){
        Coordonnees coo = new Coordonnees(abscisse, ordonnee);
        this.coordonnees = coo;
        this.couleur = Couleur.ROUGE;
    }

    public Element(Coordonnees coordonnees, Couleur couleur){
        this.coordonnees = coordonnees;
        this.couleur = couleur;
    }

    public Element(int abscisse, int ordonnee, Couleur couleur){
        Coordonnees coo = new Coordonnees(abscisse, ordonnee);
        this.coordonnees = coo;
        this.couleur = couleur;
    }

    //Acceseurs et mutateurs

    public Coordonnees getCoordonnees() {
        return coordonnees;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCoordonnees(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    //Methodes
    public void deplacerDe(int deltaX, int deltaY){
        coordonnees.setAbscisse(coordonnees.getAbscisse() + deltaX);
        coordonnees.setOrdonnee(coordonnees.getOrdonnee() + deltaY);
    }


    @Override
    public String toString() {
        return coordonnees.toString() + " - " + couleur;
    }

    @Override
    public boolean equals (Object obj){
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;
        //else
        Element objCoo = (Element) obj;
        return this.coordonnees.equals(objCoo.coordonnees) && this.couleur == objCoo.couleur;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(coordonnees, coordonnees);
    }
}


























