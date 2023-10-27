package control;

import view.InteractionPanelHandler;
import view.ViewWindow;
import Model.Card;
import Model.Stack;

public class MainController {

    private Stack<Card> stackOrigin;  //Ursprünglicher Stapel mit zufälligen Zahlen/Karten
    private Stack<Card> stackKeep;    //Stapel der Karten, der behalten wird
    private InteractionPanelHandler view;
    public static final int STACK_SIZE = 10;
    public int remainingCards = STACK_SIZE;

    public MainController() {
        new ViewWindow(this);
        startProgram();
    }

    public void setView(InteractionPanelHandler view) {
        this.view = view;
    }

    /**
     * Erstellt die zwei benötigten Stacks und füllt stackOrigin mit Karten. Die Karten haben einen zufälligen Wert zwischen 0 und 20
     * Zufallswert: Z.b.: Math.random() -> Double zwischen 0 und 1
     */
    public void startProgram() {
        //COMPLETE 8: Implementiere die Methode gemäß des Kommentars
        stackKeep = new Stack<>();
        stackOrigin = new Stack<>();
        for (int i = 0; i < STACK_SIZE; i++) {
            stackOrigin.push(new Card((int) (Math.random() * 14)));
        }
    }

    /**
     * Wert der obersten Karte von stackOrigin wird ermittelt. Falls es keine oberste Karte gibt wird -1 zurückgegeben.
     *
     * @return Wert der obersten Karte oder -1
     */
    public int showNextCard() {
        //COMPLETE 9: Implementiere die Methode gemäß des Kommentars
        if (!stackOrigin.isEmpty()) {
            return stackOrigin.top().getWert();
        }
        return -1;
    }

    /**
     * Falls stackOrigin nicht leer ist, wird die oberste Karte von stackOrigin auf stackKeep gelegt.
     *
     * @return true, falls eine Karte auf stackKeep gelegt wird, sonst false.
     */
    public boolean keep() {
        //COMPLETE 10: Implementiere die Methode gemäß des Kommentars
        if (!stackOrigin.isEmpty()) {
            stackKeep.push(stackOrigin.top());
            stackOrigin.pop();
            remainingCards--;
            view.updateDisplay();
            return true;
        }
        return false;
    }

    public int getTopKeep() {
        if (!stackKeep.isEmpty()) {
            return stackKeep.top().getWert();
        }
        return -1;
    }

    /**
     * Falls stackOrigin nicht leer ist, wird die oberste Karte von stackOrigin entfernt.
     *
     * @return true, falls eine Karte auf stackOrigin entfernt wird, sonst false.
     */
    public boolean throwCard() {
        //COMPLETE 11: Implementiere die Methode gemäß des Kommentars
        if (!stackOrigin.isEmpty()) {
            stackOrigin.pop();
            remainingCards--;
            view.updateDisplay();
            return true;
        }
        return false;
    }

    /**
     * Zählt die Karten von stackKeep. Zunächst wird geprüft, ob stackKeep den Regeln entspricht (Nur Karten in aufsteigender Reihenfolge abgelegt).
     * Zählt anschließend die abgelegten Karten, falls stackKeep regelkonform ist.
     *
     * @return Die Anzahl der abgelegten Karten, falls stackKeep regelkonform ist, sonst -1.
     */
    public int inspect() {
        //COMPLETE 12: Implementiere die Methode gemäß des Kommentars
        if (!keepCorrect()) {
            return -1;
        }
        int count = 0;
        Stack<Card> help = stackKeep;
        while (!help.isEmpty()) {
            help.pop();
            count++;
        }
        return count;

    }

    /**
     * Prüft, ob stackKeep regelkonform ist. Dh. die Karten liegen (von oben nach unten) in absteigender Reihenfolge.
     * Tipp: Nutze einen Hilfsstack
     *
     * @return true, falls regelkonform. Sonst false.
     */
    public boolean keepCorrect() {
        Stack<Card> help = new Stack<>();
        while (!stackKeep.isEmpty()) {
            if (!help.isEmpty()) {
                if (stackKeep.top().getWert() < help.top().getWert()) {
                    help.push(stackKeep.top());
                    stackKeep.pop();
                } else {
                    return false;
                }
            } else {
                help.push(stackKeep.top());
                stackKeep.pop();
            }
        }
        stackKeep = help;
        return true;
    }

    public boolean cardStackEmpty() {
        return stackOrigin.isEmpty();
    }

}
