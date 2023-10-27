package view;

import control.MainController;

import javax.swing.*;

public class ViewWindow extends JFrame{

    private MainController control;

    private JPanel interactionPanel;

    public ViewWindow(MainController control){
        InteractionPanelHandler handler = new InteractionPanelHandler(control);
        this.interactionPanel=handler.getPanel();
        control.setView(handler);
        this.control = control;
        this.setContentPane(interactionPanel);

        this.setVisible(true);
        this.setSize(800,800);
    }
}
