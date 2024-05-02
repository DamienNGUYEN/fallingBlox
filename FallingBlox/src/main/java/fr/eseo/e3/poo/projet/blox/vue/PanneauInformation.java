package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PanneauInformation extends JPanel implements PropertyChangeListener {
    private Puits puits;
    private VuePiece vuePiece;

    public PanneauInformation(Puits puits){
        this.puits = puits;
        puits.addPropertyChangeListener(this);
        this.setPreferredSize(new Dimension(60, 60));
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if (event.getPropertyName().equals(puits.MODIFICATION_PIECE_SUIVANTE)){
            this.vuePiece = new VuePiece((Piece) event.getNewValue(), 10);
            this.repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
            super.paintComponent(g);

            this.setBackground(Color.lightGray);
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));

            if (vuePiece != null){
                /*Le paramètre g est copie en utilisant la méthode copie()
                 * puis converti en instance de Graphics2D grâce à
                 * un transtypage (cast) explicite.
                 */
                Graphics2D g2D = (Graphics2D)g.create();
                /* Nous utiliserons l'instance de Graphics2D*/

                vuePiece.afficherPiece(g2D);

                /*Puis nous liberons la memoire*/
                g2D.dispose();
            }
    }
}
