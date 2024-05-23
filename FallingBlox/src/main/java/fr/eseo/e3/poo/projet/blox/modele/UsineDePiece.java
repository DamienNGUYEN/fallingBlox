package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.*;

import java.util.Random;

public class UsineDePiece {
    public static final int ALEATOIRE_COMPLET = 1;
    public static final int ALEATOIRE_PIECE = 2;
    public static final int CYCLIC = 3;

    private static int mode = 2;
    private static int numeroDeCycle = 1;

    private UsineDePiece(){}

    public static void setMode(int mode){
        UsineDePiece.mode = mode;
    }

    public static Piece genererPiece(){
        Coordonnees coo = new Coordonnees(2, 3);
        Random rand = new Random();

        int randType = rand.nextInt(1,8);
        int randCouleur = rand.nextInt(0, Couleur.values().length);

        switch (UsineDePiece.mode){
            //Aléatoire complet
            case 1 :
                switch (randType){
                    case 1 :
                        return new OPiece(coo, Couleur.values()[randCouleur]);
                    case 2 :
                        return new IPiece(coo, Couleur.values()[randCouleur]);
                    case 3 :
                        return new TPiece(coo, Couleur.values()[randCouleur]);
                    case 4 :
                        return new LPiece(coo, Couleur.values()[randCouleur]);
                    case 5 :
                        return new JPiece(coo, Couleur.values()[randCouleur]);
                    case 6 :
                        return new ZPiece(coo, Couleur.values()[randCouleur]);
                    case 7 :
                        return new SPiece(coo, Couleur.values()[randCouleur]);
                }

            //Aléatoire pièce
            case 2 :
                switch (randType){
                    case 1 :
                        return new OPiece(coo, Couleur.values()[0]);
                    case 2 :
                        return new IPiece(coo, Couleur.values()[1]);
                    case 3 :
                        return new TPiece(coo, Couleur.values()[2]);
                    case 4 :
                        return new LPiece(coo, Couleur.values()[3]);
                    case 5 :
                        return new JPiece(coo, Couleur.values()[4]);
                    case 6 :
                        return new ZPiece(coo, Couleur.values()[5]);
                    case 7 :
                        return new SPiece(coo, Couleur.values()[6]);
                }

            //Cyclique
            case 3 :
                switch (numeroDeCycle){
                    case 1 :
                        numeroDeCycle += 1;
                        return new OPiece(coo, Couleur.values()[numeroDeCycle - 2]);
                    case 2 :
                        numeroDeCycle += 1;
                        return new IPiece(coo, Couleur.values()[numeroDeCycle - 2]);
                    case 3 :
                        numeroDeCycle += 1;
                        return new TPiece(coo, Couleur.values()[numeroDeCycle - 2]);
                    case 4 :
                        numeroDeCycle += 1;
                        return new LPiece(coo, Couleur.values()[numeroDeCycle - 2]);
                    case 5 :
                        numeroDeCycle += 1;
                        return new JPiece(coo, Couleur.values()[numeroDeCycle - 2]);
                    case 6 :
                        numeroDeCycle += 1;
                        return new ZPiece(coo, Couleur.values()[numeroDeCycle - 2]);
                    case 7 :
                        numeroDeCycle = 1;
                        return  new SPiece(coo, Couleur.values()[6]);
                }

            default:
                return null;
        }
    }
}
