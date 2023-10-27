package view;

import control.MainController;

import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InteractionPanelHandler {

    private MainController controller;

    private JPanel mainPanel;
    private JButton nextCardButton;
    private JButton keepButton;
    private JButton throwButton;
    private JTextArea textArea1;
    private JTextPane textPane;
    private JTextField lastCard;
    private JButton showErgebnisButton;

    public InteractionPanelHandler(MainController controller){
        this.controller = controller;
        createButtons();
    }
    public void updateDisplay(){
            lastCard.setText(Integer.toString(controller.getTopKeep()));
            addToSysOutput2("Remaining Cards: " + controller.remainingCards);
    }
    public void createButtons(){
        nextCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int next=controller.showNextCard();
                if(next!=-1){
                    addToSysOutput(""+next);
                }else{
                    addToSysOutput("Keine Karten mehr");
                    endGame();
                }
            }
        });
        keepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controller.keep()) {
                    addToSysOutput("Karte behalten");
                    if(controller.cardStackEmpty()){
                        endGame();
                    }
                } else {
                    addToSysOutput("Keine Karte mehr vorhanden. Beende Spiel");
                    endGame();
                }
            }
        });
        throwButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controller.throwCard()) {
                    addToSysOutput("Karte weggeworfen");
                    if(controller.cardStackEmpty()){
                        endGame();
                    }
                } else {
                    addToSysOutput("Keine Karte mehr vorhanden");
                }
            }
        });
        showErgebnisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   endGame();
            }
        });
    }

    public void endGame(){
        int count=controller.inspect();
        if(count>=0){
            addToSysOutput2("Du hast insgesamt "+count+" Karten behalten.");
        } else{
            addToSysOutput2("Du hast keinen gültigen Stapel gebaut.");
        }
        controller.startProgram();
        lastCard.setText("-1");
        controller.remainingCards = MainController.STACK_SIZE;
    }
    public JPanel getPanel() {
        return mainPanel;
    }

    private void addToSysOutput(String text){
        textArea1.setText(text);
    }

    private void addToSysOutput2(String text){
        textPane.setText(text);
    }
}
