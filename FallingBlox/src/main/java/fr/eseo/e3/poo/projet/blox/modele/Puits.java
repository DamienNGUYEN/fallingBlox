package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.beans.*;

public class Puits {
    public int LARGEUR_PAR_DEFAUT = 10;
    public int PROFONDEUR_PAR_DEFAUT = 20;
    public final String  MODIFICATION_PIECE_ACTUELLE = "pieceActuelle";
    public final String  MODIFICATION_PIECE_SUIVANTE = "pieceSuivante";
    public static final int ORDONNEE_APPARTION_PIECE_ACTUELLE = 2;
    private int largeur;
    private int profondeur;
    private Piece pieceActuelle;
    private Piece pieceSuivante;
    private PropertyChangeSupport pcs;
    private Tas tas;

    public Puits(){
        largeur = LARGEUR_PAR_DEFAUT;
        profondeur = PROFONDEUR_PAR_DEFAUT;
        pcs = new PropertyChangeSupport(this);

        //Definition du tas
        tas = new Tas(this);
    }

    public Puits(int largeur, int profondeur){
        this.largeur = largeur;
        this.profondeur = profondeur;
        pcs = new PropertyChangeSupport(this);

        //Definition du tas
        tas = new Tas(this);
    }

    public Puits(int largeur, int profondeur, int nbElements){
        this.largeur = largeur;
        this.profondeur = profondeur;
        pcs = new PropertyChangeSupport(this);

        //Definition du tas
        tas = new Tas(this, nbElements);
    }

    public Puits(int largeur, int profondeur, int nbElements, int nbLignes){
        this.largeur = largeur;
        this.profondeur = profondeur;
        pcs = new PropertyChangeSupport(this);

        //Definition du tas
        tas = new Tas(this, nbElements, nbLignes);
    }


    //Accesseurs
    public Piece getPieceActuelle() {
        return pieceActuelle;
    }

    public Piece getPieceSuivante() {
        return pieceSuivante;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getProfondeur() {
        return profondeur;
    }

    public Tas getTas() {
        return tas;
    }

    //Mutateurs
    public void setPieceSuivante(Piece pieceSuivante) {
        if (this.pieceSuivante != null){

            if(isLimitReached())
                return;

            Piece pieceTemp = this.pieceActuelle;
            pieceActuelle = this.pieceSuivante;
            pieceActuelle.setPosition(largeur/ 2 - 1, ORDONNEE_APPARTION_PIECE_ACTUELLE);
            pcs.firePropertyChange(MODIFICATION_PIECE_ACTUELLE, pieceTemp, this.pieceActuelle);
        }
        Piece pieceTemp = this.pieceSuivante;
        this.pieceSuivante = pieceSuivante;
        this.pieceSuivante.setPuits(this);
        pcs.firePropertyChange(MODIFICATION_PIECE_SUIVANTE, pieceTemp, pieceSuivante);
    }

    public void setPieceActuelle(Piece pieceActuelle) {
        this.pieceActuelle = pieceActuelle;
    }

    private void gererCollision(){
        tas.ajouterElements(pieceActuelle);
        setPieceSuivante(UsineDePiece.genererPiece());
    }

    public void gravite() {
        try{
            pieceActuelle.deplacerDe(0, 1);
        }
        catch (BloxException exception){
            if (exception.getType() == BloxException.BLOX_COLLISION){
                gererCollision();
            }
        }
    }

    public boolean isLimitReached(){
        Element[] ligneLimite = tas.getElements()[2];

        for(Element element : ligneLimite){
            if(element != null)
                return true;
        }

        return false;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public void setProfondeur(int profondeur) {
        this.profondeur = profondeur;
    }

    @Override
    public String toString(){
        String textPieceActuelle;
        if(this.pieceActuelle == null){
            textPieceActuelle = "<aucune>";}
        else {
            textPieceActuelle = pieceActuelle.toString();
        }

        String textPieceSuivante;
        if(this.pieceSuivante == null){
            textPieceSuivante = "<aucune>";}
        else {
            String classe = String.valueOf(pieceSuivante.getClass());
            int n = String.valueOf(pieceSuivante.getClass()).length();
            textPieceSuivante = classe.substring(n - 6) + " :\n" + pieceSuivante;
        }

        return "Puits : Dimension " + largeur + " x " + profondeur +
            "\nPiece Actuelle : " + textPieceActuelle +
            "\nPiece Suivante : " + textPieceSuivante;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener){
        pcs.removePropertyChangeListener(listener);
    }
}
