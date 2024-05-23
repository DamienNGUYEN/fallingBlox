package fr.eseo.e3.poo.projet.blox.vue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class VueGameOver extends JPanel{

    public VueGameOver(){}

    public void afficherGameOver(Graphics2D g2D){
        BufferedImage image;
        try {
            image = ImageIO.read(new File("C:\\Users\\tharr\\OneDrive\\Desktop\\Cours\\E3\\Java\\fallingBlox-main\\fallingBloxCleo\\FallingBlox\\src\\main\\resources\\gameOver.jpg"));
        }catch (IOException ex) {
            throw new RuntimeException(ex.getMessage());
        }

        //setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));

        g2D.drawImage(image, 20, 100, this);

    }
}
