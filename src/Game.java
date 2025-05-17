import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {

    JFrame window;
    Container primo;
    JPanel TitreJeu, BtnStart, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel TitreJeuText, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    Font FontTitre = new Font("Times New Roman", Font.PLAIN, 82);
    Font FontTitre1 = new Font("Times New Roman", Font.PLAIN, 27);
    JButton BtnStart1, choix1, choix2, choix3, choix4;
    JTextArea mainTextArea;
    int playerHP, monsterHP, silverRing;
    String weapon, position;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    public static void main(String[] args) {

        new Game();

    }

    public Game() {

        window = new JFrame();
        window.setSize(1400, 800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        primo = window.getContentPane();

        TitreJeu = new JPanel();
        TitreJeu.setBounds(400, 100, 600, 100);
        TitreJeu.setBackground(Color.black);
        TitreJeuText = new JLabel("GetinTheTown");
        TitreJeuText.setForeground(Color.white);
        TitreJeuText.setFont(FontTitre);

        BtnStart = new JPanel();
        BtnStart.setBounds(550, 400, 300, 150);
        BtnStart.setBackground(Color.black);

        BtnStart1 = new JButton("Cliquez pour commencer");
        BtnStart1.setBackground(Color.black);
        BtnStart1.setForeground(Color.white);
        BtnStart1.setFont(FontTitre1);
        BtnStart1.setBorderPainted(false);
        BtnStart1.setFocusPainted(false);
        BtnStart1.addActionListener(tsHandler);

        TitreJeu.add(TitreJeuText);
        BtnStart.add(BtnStart1);
        primo.add(TitreJeu);
        primo.add(BtnStart);
        window.setVisible(true);
    }

    public void createGameScreen() {
        TitreJeu.setVisible(false);
        BtnStart.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(400, 250, 600, 250);
        mainTextPanel.setBackground(Color.black);
        primo.add(mainTextPanel);

        mainTextArea = new JTextArea("");
        mainTextArea.setBounds(450, 250, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(FontTitre1);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        // Création du panneau pour les boutons de choix
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(350, 550, 700, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        primo.add(choiceButtonPanel);

        choix1 = new JButton("Choix 1");
        choix1.setBackground(Color.black);
        choix1.setForeground(Color.white);
        choix1.setFont(FontTitre1);
        choiceButtonPanel.add(choix1);
        choix1.setFocusPainted(false);
        choix1.addActionListener(choiceHandler);
        choix1.setActionCommand("c1");
        choix2 = new JButton("Choix 2");
        choix2.setBackground(Color.black);
        choix2.setForeground(Color.white);
        choix2.setFont(FontTitre1);
        choiceButtonPanel.add(choix2);
        choix2.setFocusPainted(false);
        choix2.addActionListener(choiceHandler);
        choix2.setActionCommand("c2");
        choix3 = new JButton("Choix 3");
        choix3.setBackground(Color.black);
        choix3.setForeground(Color.white);
        choix3.setFont(FontTitre1);
        choiceButtonPanel.add(choix3);
        choix3.setFocusPainted(false);
        choix3.addActionListener(choiceHandler);
        choix3.setActionCommand("c3");
        choix4 = new JButton("Choix 4");
        choix4.setBackground(Color.black);
        choix4.setForeground(Color.white);
        choix4.setFont(FontTitre1);
        choiceButtonPanel.add(choix4);
        choix4.setFocusPainted(false);
        choix4.addActionListener(choiceHandler);
        choix4.setActionCommand("c4");

        playerPanel = new JPanel();
        playerPanel.setBounds(375, 15, 660, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 4));
        primo.add(playerPanel);
        hpLabel = new JLabel("HP :");
        hpLabel.setFont(FontTitre1);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(FontTitre1);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);
        weaponLabel = new JLabel("Arme :");
        weaponLabel.setFont(FontTitre1);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);
        weaponLabelName = new JLabel();
        weaponLabelName.setFont(FontTitre1);
        weaponLabelName.setForeground(Color.white);
        playerPanel.add(weaponLabelName);

        playerSetup();

        // Forcer la mise à jour de l'interface
        window.revalidate();
        window.repaint();
    }

    public void playerSetup() {
        playerHP = 30;
        monsterHP = 20;
        weapon = "Poignard";
        weaponLabelName.setText(weapon);
        hpLabelNumber.setText("" + playerHP);

        townGate();
    }

    public void townGate() {
        position = "townGate";
        mainTextArea.setText(
                "Tu te réveilles au abords d'une ville. Tu te rapproches mais tu es stoppé par un chat qui porte un badge de     garde. Tu peux y lire Messire Pudding marqué dessus.\n\nQue souhaites-tu faire?");

        choix1.setText("Parler a Pudding");
        choix2.setText("Attaquer Pudding");
        choix3.setText("S'en aller");
        choix4.setText("");
    }

    public void parlerGarde() {
        position = "parlerGarde";
        mainTextArea.setText(
                "Pudding : Oh Halte la, ca vient d'ou le sang? Moi  \nPuddingston je stopperai quiconque veut passer la \nporte.");
        choix1.setText("Revenir en arrière");
        choix2.setText("On est la chacal laisse-moi me faufiler");
        choix3.setText("");
        choix4.setText("");
    }

    public void parlerGarde2() {
        position = "parlerGarde2";
        mainTextArea.setText(
                "Pudding : Non frérot c'est mort.\n*Le garde s'arrête et réfléchit deux secondes.*\nPeut-être que si tu pars monter en l'air le gobelin a \nl'Ouest, je pourrais te laisser passer. \nIl nous fait que des problèmes cet enflure.");
        choix1.setText("Vasy-Carré");
        choix2.setText("");
    }

    public void attaquerGarde() {
        position = "attaquerGarde";
        mainTextArea.setText(
                "Puddingston : Ohoh! Tu veux qu'on se la donne?\n\n Pudding dégaine son TomaHawk et vous attaque!! \n\n (Vous perdez 3 HP)");
        playerHP = playerHP - 3;
        hpLabelNumber.setText("" + playerHP);
        choix1.setText("Revenir en arrière");
        choix2.setText("");
        choix3.setText("");
        choix4.setText("");
    }

    public void crossRoad() {
        position = "crossRoad";
        mainTextArea.setText("Tu es repartie vers les plaines\nSi tu pars au sud, tu retourneras au village.");
        choix1.setText("Aller au nord près de la rivière");
        choix2.setText("Aller à l'est");
        choix3.setText("Aller au sud");
        choix4.setText("Aller vers la grotte");
    }

    public void nord() {
        position = "nord";
        mainTextArea.setText(
                "Vous vous approchez de la rivière et vous vous rafraîchissez,\nCela vous fait le plus grand bien et gagnez 4HP");
        playerHP = playerHP + 4;
        hpLabelNumber.setText("" + playerHP);
        choix1.setText("Retourner vers les plaines");
        choix2.setText("Aller à l'est");
        choix3.setText("Retourner au sud vers le chateau");
        choix4.setText("Aller vers la grotte");
    }

    public void est() {
        position = "est";
        mainTextArea.setText(
                "Vous marchez le long de la forêt et trouvez une épée   planté dans le sol, celle-ci semble en bon état. \nVous décidez de la prendre pour vous...\nOn ne sait jamais.\n(Acquis: Epée longue)");
        weapon = "Epée Longue";
        weaponLabelName.setText(weapon);
        choix1.setText("Revenir en arrière");
        choix2.setText("");
        choix3.setText("");
        choix4.setText("");
    }

    public void ouest() {
        position = "ouest";
        mainTextArea.setText(
                "Vous rentrez dans la grotte.\nPas plus de 2 minutes plus tard, vous tombez nez à nez avec un gobelin... Celui-ci semble agité.");
        choix1.setText("Se battre tel un bg");
        choix2.setText("Fuir comme une larve");
        choix3.setText("");
        choix4.setText("");
    }

    public void fight() {
        position = "fight";
        mainTextArea.setText("HP du gobelin :" + monsterHP + "\n\nQue souhaites-tu faire?");
        choix1.setText("Attaquer");
        choix2.setText("Fuir");
        choix3.setText("");
        choix4.setText("");
    }

    public void attack() {
        position = "attack";

        int playerDamage = 0;

        if (weapon.equals("Poignard")) {
            playerDamage = new java.util.Random().nextInt(3);
        } else if (weapon.equals("Epée Longue")) {
            playerDamage = new java.util.Random().nextInt(8);
        }

        mainTextArea
                .setText("Tu attaques le Gobelin avec ton " + weapon + " \net inflige " + playerDamage + " dégats!");
        monsterHP = monsterHP - playerDamage;
        choix1.setText("Attaquer");
        choix2.setText("Fuir");
        choix3.setText("");
        choix4.setText("");

    }

    public void attackMonstre() {
        position = "attackMonstre";

        int monsterDamage = 0;

        monsterDamage = new java.util.Random().nextInt(5);

        mainTextArea.setText("Hp du gobelin malicieux: " + monsterHP
                + "\n\nLe gobelin vous attaque également,\nIl vous inflige " + monsterDamage + " dégats!");
        playerHP = playerHP - monsterDamage;
        hpLabelNumber.setText("" + playerHP);

        choix1.setText("Attaquer");
        choix2.setText("Fuir");
        choix3.setText("");
        choix4.setText("");
    }

    public void win() {
        position = "win";
        mainTextArea.setText("Vous avez ravagé le gobelin!\n\nVous récuperez un anneau d'argent sur sa dépouille.");

        silverRing = 1;
        choix1.setText("Vous savourez votre victoire et retournez en arrière");
        choix2.setText("");
        choix3.setText("");
        choix4.setText("");

    }

    public void loose() {
        position = "loose";
        mainTextArea.setText("Tu es MORT.\n\n\n<GAME OVER>");
        choix1.setText("Recommencer?");
        choix2.setText("");
        choix3.setText("");
        choix4.setText("");
        choix2.setVisible(false);
        choix3.setVisible(false);
        choix4.setVisible(false);
    }

    public void ending() {
        position = "ending";
        mainTextArea.setText(
                "Puddingston : Je vous ai vu occire ce gobelin malicieux.\nMerci au nom du village t'es ce bogoss que tu penses être. \n\n<FIN>");

        choix1.setText("Recommencer?");
        choix2.setText("");
        choix3.setText("");
        choix4.setText("");
        choix2.setVisible(false);
        choix3.setVisible(false);
        choix4.setVisible(false);

    }

    public class TitleScreenHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            createGameScreen();
        }
    }

    public class ChoiceHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();

            switch (position) {
                case "townGate":
                    switch (yourChoice) {
                        case "c1":
                            if (silverRing == 1) {
                                ending();
                            } else {
                                parlerGarde();
                            }
                            break;
                        case "c2":
                            attaquerGarde();
                            break;
                        case "c3":
                            crossRoad();
                            break;
                    }
                    break;
                case "parlerGarde":
                    switch (yourChoice) {
                        case "c1":
                            townGate();
                            break;
                        case "c2":
                            parlerGarde2();
                            break;
                    }
                    break;
                case "attaquerGarde":
                    switch (yourChoice) {
                        case "c1":
                            townGate();
                            break;
                    }
                    break;
                case "crossRoad":
                    switch (yourChoice) {
                        case "c1":
                            nord();
                            break;
                        case "c2":
                            est();
                            break;
                        case "c3":
                            townGate();
                            break;
                        case "c4":
                            ouest();
                            break;
                    }
                    break;
                case "nord":
                    switch (yourChoice) {
                        case "c1":
                            crossRoad();
                            break;
                        case "c2":
                            est();
                            break;
                        case "c3":
                            townGate();
                            break;
                        case "c4":
                            ouest();
                            break;
                    }
                    break;
                case "est":
                    switch (yourChoice) {
                        case "c1":
                            crossRoad();
                            break;
                        case "c2":
                            break;
                        case "c3":
                            break;
                        case "c4":
                            break;
                    }
                    break;
                case "ouest":
                    switch (yourChoice) {
                        case "c1":
                            fight();
                            break;
                        case "c2":
                            crossRoad();
                            break;
                    }
                    break;
                case "parlerGarde2":
                    switch (yourChoice) {
                        case "c1":
                            crossRoad();
                            break;
                    }
                    break;
                case "fight":
                    switch (yourChoice) {
                        case "c1":
                            attack();

                            break;

                        case "c2":
                            crossRoad();
                            break;
                    }
                    break;
                case "attack":
                    switch (yourChoice) {
                        case "c1":
                            if (monsterHP < 1) {
                                win();
                            } else {
                                attackMonstre();
                            }
                            break;

                        case "c2":
                            crossRoad();
                            break;
                    }
                    break;
                case "attackMonstre":
                    switch (yourChoice) {
                        case "c1":
                            if (playerHP < 1) {
                                loose();
                            } else {
                                attack();
                            }

                            break;

                        case "c2":
                            crossRoad();
                            break;
                    }
                    break;
                case "win":
                    switch (yourChoice) {
                        case "c1":
                            crossRoad();

                            break;
                    }
                    break;
                case "loose":
                    switch (yourChoice) {
                        case "c1":
                            townGate();

                            break;

                    }
                    break;

                case "ending":
                    switch (yourChoice) {
                        case "c1":
                            townGate();

                            break;
                    }
            }
        }
    }
}