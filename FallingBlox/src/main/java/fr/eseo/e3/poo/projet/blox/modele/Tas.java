package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.util.Random;

public class Tas {
    private Puits puits;
    private Element [][] elements;

    public Tas(Puits puits){
        this.puits = puits;
        elements = new Element[puits.getProfondeur()][puits.getLargeur()];
    }

    public Tas(Puits puits, int nbElements){
        this.puits = puits;
        construireTas(nbElements, nbElements/getPuits().getLargeur()+1, new Random());
    }

    public Tas(Puits puits, int nbElements, int nbLignes){
        this.puits = puits;
        construireTas(nbElements, nbLignes, new Random());
    }

    public Puits getPuits() {
        return puits;
    }

    public Element[][] getElements() {
        return elements;
    }

    private void construireTas (int nbElements, int nbLignes, Random rand) throws IllegalArgumentException{
        elements = new Element[puits.getProfondeur()][puits.getLargeur()];
        if (nbElements <= 0 || nbElements >= puits.getLargeur()*nbLignes){
            throw new IllegalArgumentException();
        }

        for (int i=0; i<nbElements;) {
            int abscisse = rand.nextInt(0, puits.getLargeur());
            int ordonnee = puits.getProfondeur() - rand.nextInt(1, nbLignes + 1);

            if (elements[ordonnee][abscisse] == null) {
                int indiceCouleur = rand.nextInt(Couleur.values().length);
                elements[ordonnee][abscisse] = new Element(abscisse, ordonnee, Couleur.values()[indiceCouleur]);
                i++;
            }
        }
    }

    public void ajouterElements(Piece piece){
        for (int i=0; i<4; i++){
            Element element = (Element) piece.getElements().get(i);
            elements[element.getCoordonnees().getOrdonnee()][element.getCoordonnees().getAbscisse()] = element;
        }
        supprimerLigne();
    }

    /**
     * Supprimer les lignes complètes
     */
    public void supprimerLigne(){

        for (int y=elements.length - 1; y>=0; y--){

            boolean full = true;
            for (int x=0; x<elements[y].length; x++){
                if (elements[y][x] == null){
                    full = false;
                    break;
                }
            }
            if(full){
                for (int i=y; i>0; i--){
                    elements[i] = elements[i - 1];
                }
                elements[0] = new Element[elements[0].length];
                y += 1;
            }
        }
    }
}
