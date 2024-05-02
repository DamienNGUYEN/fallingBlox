package fr.eseo.e3.poo.projet.blox.modele;

public class BloxException extends Exception {
    public static int BLOX_COLLISION;
    public static int BLOX_SORTIE_PUITS;
    private int type;

    public BloxException(String message, int type){
        super(message);
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
