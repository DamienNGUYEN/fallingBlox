package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.event.*;
        import java.awt.*;
        import javax.swing.*;

class Menu extends JFrame {
//class Menu extends JFrame implements ItemListener {

    // frame
    static JFrame f;

    // label
    static JLabel titre, choix;

    // combobox
    static JComboBox mode;

    //bouton
    static JButton lancer;

    // main class
    public static void main(String[] args)
    {
        // create a new frame
        f = new JFrame("Menu : Falling Blox");

        f.setLayout(null);

        // set the size of frame
        f.setSize(300, 300);

        // create a object
        Menu menu = new Menu();

        // array of string containing cities
        String s1[] = { "Aléatoire complet", "Aléatoire pièce", "Cyclique" };

        // create checkbox
        mode = new JComboBox(s1);

        // add ItemListener
        //lancer.addItemListener(menu);

        // create labels
        titre = new JLabel("FALLING BLOX");
        choix = new JLabel("Choix du mode :");

        // create button
        lancer = new JButton("Lancer");

        lancer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Game(mode.getSelectedIndex() + 1);
                f.setVisible(false);
            }
        });

        // set color of text
        titre.setForeground(Color.blue);

        // create a new panel
        JPanel p = new JPanel();
        p.setLayout(null);

        // add panel to frame
        f.add(p);
        p.setBounds(0, 0, 300, 300);

        p.add(titre);
        p.add(choix);
        p.add(mode);
        p.add(lancer);

        titre.setBounds((f.getWidth() - 200)/2 - 7, 30, 200, 20);
        choix.setBounds((f.getWidth() - 200)/2 - 7, 80, 200, 20);
        mode.setBounds((f.getWidth() - 150)/2 - 7, 105, 150, 20);
        lancer.setBounds((f.getWidth() - 100)/2 - 7, 170, 100, 30);

        titre.setHorizontalAlignment(SwingConstants.CENTER);
        choix.setHorizontalAlignment(SwingConstants.CENTER);


        f.setResizable(false);

        Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int ecranHauteur = (int)tailleEcran.getHeight();
        int ecranLargeur = (int)tailleEcran.getWidth();

        f.setLocation((ecranLargeur - f.getWidth())/2,
                (ecranHauteur - f.getHeight())/2);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    /*
    public void itemStateChanged(ItemEvent e)
    {
        // if the state combobox is changed
        if (e.getSource() == lancer) {
            //choix.setText(mode.getSelectedItem() + " selected");
        }
    }
    */
}
