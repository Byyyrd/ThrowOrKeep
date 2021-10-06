package view;

import control.MainController;
import javafx.scene.text.Text;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InteractionPanelHandler {

    private MainController controller;

    private JPanel mainPanel;
    private JButton zeigeNächsteKarteButton;
    private JButton behalteButton;
    private JButton wegwerfenButton;
    private JTextArea textArea1;
    private JTextPane textPane;

    public InteractionPanelHandler(MainController controller){
        this.controller = controller;
        createButtons();
        //update();
    }

    public void createButtons(){
        zeigeNächsteKarteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int next=controller.showNextCard();
                if(next!=-1){
                    addToSysoutput(""+next);
                }else{
                    addToSysoutput("Keine Karten mehr");
                    endGame();
                }
            }
        });
        behalteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controller.keep()) {
                    addToSysoutput("Karte behalten");
                    if(controller.cardStackEmpty()){
                        endGame();
                    }
                } else {
                    addToSysoutput("Keine Karte mehr vorhanden. Beende Spiel");
                    endGame();
                }
            }
        });
        wegwerfenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controller.throwCard()) {
                    addToSysoutput("Karte weggeworfen");
                    if(controller.cardStackEmpty()){
                        endGame();
                    }
                } else {
                    addToSysoutput("Keine Karte mehr vorhanden");
                }
            }
        });
    }

    public void endGame(){
        int count=controller.inspect();
        if(count>=0){
            addToSysoutput2("Du hast insgesamt "+count+" Karten behalten.");
        } else{
            addToSysoutput2("Du hast keinen gültigen Stapel gebaut.");
        }
    }

    public JPanel getPanel() {
        return mainPanel;
    }

    private void addToSysoutput(String text){
        textArea1.setText(text);
    }

    private void addToSysoutput2(String text){
        textPane.setText(text);
    }
}
