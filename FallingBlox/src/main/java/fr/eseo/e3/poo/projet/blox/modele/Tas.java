package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class Tas {
    public String  NOUVEAU_SCORE = "nouveauScore";
    public String  NOUVEAU_NIVEAU = "nouveauNiveau";
    private Puits puits;
    private Element [][] elements;
    private int score = 0;
    private int ligneSup = 0;
    private int niveau = 1;
    private PropertyChangeSupport pcs;

    public Tas(Puits puits){
        this.puits = puits;
        elements = new Element[puits.getProfondeur()][puits.getLargeur()];
        this.pcs = new PropertyChangeSupport(this);
    }

    public Tas(Puits puits, int nbElements){
        this.puits = puits;
        construireTas(nbElements, nbElements/getPuits().getLargeur()+1, new Random());
        this.pcs = new PropertyChangeSupport(this);
    }

    public Tas(Puits puits, int nbElements, int nbLignes){
        this.puits = puits;
        construireTas(nbElements, nbLignes, new Random());
        this.pcs = new PropertyChangeSupport(this);
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

        //Supprime et compte les lignes
        int combo = 0;
        for (int y=elements.length - 1; y>=0; y--) {
            boolean full = true;
            for (int x = 0; x < elements[y].length; x++) {
                if (elements[y][x] == null) {
                    full = false;
                    break;
                }
            }
            if (full) {
                for (int i = y; i > 0; i--) {
                    elements[i] = elements[i - 1];
                }
                elements[0] = new Element[elements[0].length];
                y += 1;
                combo += 1;

            }
        }

        //Change le score en fonction du combo
        switch (combo){
            case 1:
                pcs.firePropertyChange(NOUVEAU_SCORE, score, score + 100 * niveau);
                score = score  + 100 * niveau;
                System.out.println(score);
            case 2:
                pcs.firePropertyChange(NOUVEAU_SCORE, score, score + 300 * niveau);
                score += 300 * niveau;
            case 3:
                pcs.firePropertyChange(NOUVEAU_SCORE, score, score + 500 * niveau);
                score += 500 * niveau;
            case 4:
                pcs.firePropertyChange(NOUVEAU_SCORE, score, score + 800 * niveau);
                score += 800 * niveau;
            }

        //Met à jour le nombre de ligne supprimées ainsi que le niveau
        ligneSup += combo;

        int oldNiv = niveau;
        niveau = ligneSup/10 + 1;

        if (oldNiv != niveau)
            pcs.firePropertyChange(NOUVEAU_NIVEAU, oldNiv, niveau);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener){
        pcs.removePropertyChangeListener(listener);
    }
}
