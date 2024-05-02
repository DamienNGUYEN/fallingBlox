package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import java.util.Random;

public class UsineDePiece {
    public static final int ALEATOIRE_COMPLET = 1;
    public static final int ALEATOIRE_PIECE = 2;
    public static final int CYCLIC = 3;

    private static int mode = 2;
    private static int cyclique = 1;

    private UsineDePiece(){}

    public static void setMode(int mode){
        UsineDePiece.mode = mode;
    }

    public static Piece genererPiece(){
        Coordonnees coo = new Coordonnees(2, 3);
        Random rand = new Random();

        int randType = rand.nextInt(1,3);
        int randCouleur = rand.nextInt(0, Couleur.values().length);

        switch (UsineDePiece.mode){
            case 1 :
                switch (randType){
                    case 1 :
                        return new OPiece(coo, Couleur.values()[randCouleur]);
                    case 2 :
                        return new IPiece(coo, Couleur.values()[randCouleur]);
                }

            case 2 :
                switch (randType){
                    case 1 :
                        return new OPiece(coo, Couleur.values()[randType]);
                    case 2 :
                        return new IPiece(coo, Couleur.values()[randType]);
                }

            case 3 :
                switch (cyclique){
                    case 1 :
                        cyclique = 2;
                        return new OPiece(coo, Couleur.values()[cyclique]);
                    case 2 :
                        cyclique = 1;
                        return new IPiece(coo, Couleur.values()[cyclique]);
                }

            default:
                return null;
        }
    }
}
