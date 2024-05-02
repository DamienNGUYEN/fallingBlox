package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.*;

import java.util.ArrayList;

public abstract class Piece {
    private final ArrayList<Element> elements;
    private Puits puits;

    public Piece(Coordonnees coordonnees, Couleur couleur){
        this.elements = new ArrayList<>();
        setElements(coordonnees, couleur);
    }

    protected abstract void setElements(Coordonnees coordonnees, Couleur couleur);

    //Accesseurs
    public ArrayList<Element> getElements(){
        return elements;
    }

    public Puits getPuits() {
        return puits;
    }

    //Mutateurs
    public void setPuits(Puits puits) {
        this.puits = puits;
    }

    public void setPosition(int abscisse, int ordonnee){
        Coordonnees coordonnees = new Coordonnees(abscisse, ordonnee);
        Couleur couleur = elements.getFirst().getCouleur();
        elements.clear();

        setElements(coordonnees, couleur);
    }

    public void deplacerDe(int deltaX, int deltaY) throws IllegalArgumentException, BloxException {
        if (deltaX > 1 || deltaX < -1 || deltaY > 1){
            throw new IllegalArgumentException("Le déplacement excède la distance autorisée (1).");
        }
        else if (deltaY < 0){
            throw new IllegalArgumentException("Le déplacement vers le haut n'est pas autorisé.");
        }
        else {
            for (int i = 0; i < 4; i++) {
                if (elements.get(i).getCoordonnees().getAbscisse() + deltaX < 0 ||
                elements.get(i).getCoordonnees().getAbscisse() + deltaX >= puits.getLargeur()){
                    throw new BloxException("La pièce a atteint le bord du puits.", BloxException.BLOX_SORTIE_PUITS);
                }
            }
            for (int i = 0; i < 4; i++){
                int x = elements.get(i).getCoordonnees().getAbscisse();
                int y = elements.get(i).getCoordonnees().getOrdonnee();
                if (y + deltaY >= getPuits().getProfondeur() ||
                        puits.getTas().getElements()[y + deltaY][x + deltaX] != null){
                    throw new BloxException("La pièce est entrée en collision.", BloxException.BLOX_COLLISION);
                }
            }

            for (int i = 0; i < 4; i++) {
                elements.get(i).deplacerDe(deltaX, deltaY);
            }
        }
    }


    public void tourner(boolean sensHoraire) throws BloxException {
        for (int i=0; i<4; i++){
            int x = elements.get(i).getCoordonnees().getAbscisse();
            int y = elements.get(i).getCoordonnees().getOrdonnee();
            x = x - elements.getFirst().getCoordonnees().getAbscisse();
            y = y - elements.getFirst().getCoordonnees().getOrdonnee();

            if (sensHoraire){
                y = -y;
            }
            else {
                x = -x;
            }

            x = x + elements.getFirst().getCoordonnees().getOrdonnee();
            y = y + elements.getFirst().getCoordonnees().getAbscisse();

            if ( y < 0 || y >= puits.getLargeur()){
                throw new BloxException("Si elle tourne, la pièce sortira du puits.", BloxException.BLOX_SORTIE_PUITS);
            }
            if ( x >= puits.getProfondeur() || puits.getTas().getElements()[x][y] != null){
                throw new BloxException("La pièce est entrée en collision.", BloxException.BLOX_COLLISION);
            }
        }

        for (int i=1; i<4; i++){
            elements.get(i).deplacerDe(-elements.getFirst().getCoordonnees().getAbscisse(), -elements.getFirst().getCoordonnees().getOrdonnee());
        }

        for (int i=1; i<4; i++){
            int x = elements.get(i).getCoordonnees().getAbscisse();
            int y = elements.get(i).getCoordonnees().getOrdonnee();

            Coordonnees newCoo = new Coordonnees(y, -x);
            if (sensHoraire){
                newCoo = new Coordonnees(-y, x);
            }
            elements.get(i).setCoordonnees(newCoo);
        }

        for (int i=1; i<4; i++){
            elements.get(i).deplacerDe(elements.getFirst().getCoordonnees().getAbscisse(), elements.getFirst().getCoordonnees().getOrdonnee());
        }

    }

    //Methode
    @Override
    public String toString(){
        return "    " + elements.get(0).toString() +
                "\n    " + elements.get(1).toString() +
                "\n    " + elements.get(2).toString() +
                "\n    " + elements.get(3).toString();
    }
}
