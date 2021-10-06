package view;

import control.MainController;

import javax.swing.*;

public class ViewWindow extends JFrame{

    private MainController control;

    private JPanel interactionPanel;

    public ViewWindow(MainController control){
        this.interactionPanel=new InteractionPanelHandler(control).getPanel();
        this.control = control;
        this.setContentPane(interactionPanel);

        this.setVisible(true);
        this.setSize(800,800);
    }
}
