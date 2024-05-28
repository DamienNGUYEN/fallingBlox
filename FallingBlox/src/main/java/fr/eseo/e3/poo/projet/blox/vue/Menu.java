package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.event.*;
        import java.awt.*;
        import javax.swing.*;

//class Menu extends JFrame {
class Menu extends JFrame implements ItemListener {

    // frame
    static JFrame f;

    // panel
    static JPanel p;

    // label
    static JLabel titre, choix, choixTas;

    // combobox
    static JComboBox mode, tas, elementsTas;

    //bouton
    static JButton lancer;

    // main class
    public static void main(String[] args)
    {
        // create a new frame
        f = new JFrame("Menu : Falling Blox");

        f.setLayout(null);

        // set the size of frame
        f.setSize(300, 350);

        // create a object
        Menu menu = new Menu();

        // array of string containing cities
        String s1[] = { "Aléatoire complet", "Aléatoire pièce", "Cyclique" };
        String s2[] = { "Sans tas", "Avec tas"};
        String s3[] = { "5", "10", "15", "20", "25", "30", "35", "40"};

        // create checkbox
        mode = new JComboBox(s1);
        tas = new JComboBox(s2);
        elementsTas = new JComboBox(s3);

        // add ItemListener
        tas.addItemListener(menu);

        // create labels
        titre = new JLabel("FALLING BLOX");
        choix = new JLabel("Choix du mode :");
        choixTas = new JLabel("Choix du tas :");

        // create button
        lancer = new JButton("Lancer");

        lancer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tas.getSelectedItem() == "Sans tas") {
                    new Game(mode.getSelectedIndex() + 1, 0);
                }
                else {
                    new Game(mode.getSelectedIndex() + 1, Integer.parseInt(elementsTas.getSelectedItem().toString()));
                }
                f.setVisible(false);

            }
        });

        // set color of text
        titre.setForeground(Color.blue);

        // create a new panel
        p = new JPanel();
        p.setLayout(null);

        // add panel to frame
        f.add(p);
        p.setBounds(0, 0, 300, 300);

        p.add(titre);
        p.add(choix);
        p.add(mode);
        p.add(lancer);
        p.add(choixTas);
        p.add(tas);

        titre.setBounds((f.getWidth() - 200)/2 - 7, 30, 200, 20);
        choix.setBounds((f.getWidth() - 200)/2 - 7, 80, 200, 20);
        mode.setBounds((f.getWidth() - 150)/2 - 7, 105, 150, 20);
        choixTas.setBounds((f.getWidth() - 200)/2 - 7, 140, 200, 20);
        tas.setBounds((f.getWidth() - 150)/2 - 7, 165, 150, 20);
        elementsTas.setBounds((f.getWidth() - 75)/2 - 7, 190, 75, 20);
        lancer.setBounds((f.getWidth() - 100)/2 - 7, 210, 100, 30);

        titre.setHorizontalAlignment(SwingConstants.CENTER);
        choix.setHorizontalAlignment(SwingConstants.CENTER);
        choixTas.setHorizontalAlignment(SwingConstants.CENTER);


        f.setResizable(false);

        Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int ecranHauteur = (int)tailleEcran.getHeight();
        int ecranLargeur = (int)tailleEcran.getWidth();

        f.setLocation((ecranLargeur - f.getWidth())/2,
                (ecranHauteur - f.getHeight())/2);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }


    public void itemStateChanged(ItemEvent e)
    {
        // if the state combobox is changed
        if (e.getSource() == tas) {
            if (tas.getSelectedItem() == "Avec tas"){
                p.add(elementsTas);
                lancer.setBounds((f.getWidth() - 100)/2 - 7, 230, 100, 30);
            }
            else{
                p.remove(elementsTas);
                lancer.setBounds((f.getWidth() - 100)/2 - 7, 210, 100, 30);

            }
        }
    }

}
