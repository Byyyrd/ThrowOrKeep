package Model;
/**
 * <p>
 * Materialien zu den zentralen NRW-Abiturpruefungen im Fach Informatik ab 2018
 * </p>
 * <p>
 * Generische Klasse Stack<ContentType>
 * </p>
 * <p>
 * Objekte der generischen Klasse Stack (Keller, Stapel) verwalten beliebige
 * Objekte vom Typ ContentType nach dem Last-In-First-Out-Prinzip, d.h., das
 * zuletzt abgelegte Objekt wird als erstes wieder entnommen. Alle Methoden
 * haben eine konstante Laufzeit, unabhaengig von der Anzahl der verwalteten
 * Objekte.
 * </p>
 *
 * @author Qualitaets- und UnterstuetzungsAgentur - Landesinstitut fuer Schule
 * @version Generisch_02 2014-02-21
 */
//TODO 1: Ändere die Klasse Stack derart, dass sie eine generische Klasse ist. Nenne den Typparameter "ContentType"
public class Stack {

    /* --------- Anfang der privaten inneren Klasse -------------- */

    private class StackNode {

        private Object content = null;
        private StackNode nextNode = null;

        /**
         * Ein neues Objekt vom Typ StackNode<ContentType> wird erschaffen. <br />
         * Der Inhalt wird per Parameter gesetzt. Der Verweis ist leer.
         *
         * @param pContent der Inhalt des Knotens
         */
        public StackNode(Object pContent) {
            //TODO 2: Implementiere den Konstruktor der inneren Klasse StackNode
        }

        /**
         * Der Verweis wird auf das Objekt, das als Parameter uebergeben wird,
         * gesetzt.
         *
         * @param pNext der Nachfolger des Knotens
         */
        public void setNext(StackNode pNext) {
            //TODO 3: Implementiere die Methode, wie sie im Kommentar beschrieben ist.
        }

        /**
         *
         * @return das Objekt, auf das der aktuelle Verweis zeigt
         */
        public StackNode getNext() {
            return nextNode;
        }

        /**
         * @return das Inhaltsobjekt vom Typ ContentType
         */
        public Object getContent() {
            return content;
        }
    }

    /* ----------- Ende der privaten inneren Klasse -------------- */

    private StackNode head;

    /**
     * Ein leerer Stapel wird erzeugt. Objekte, die in diesem Stapel verwaltet
     * werden, muessen vom Typ ContentType sein.
     */
    public Stack() {
        head = null;
    }

    /**
     * Die Anfrage liefert den Wert true, wenn der Stapel keine Objekte
     * enthaelt, sonst liefert sie den Wert false.
     *
     * @return true, falls der Stapel leer ist, sonst false
     */
    public boolean isEmpty() {
        //TODO 4: Implementiere die Methode wie im Kommentar beschrieben
        return false;
    }

    /**
     * Das Objekt pContent wird oben auf den Stapel gelegt. Falls
     * pContent gleich null ist, bleibt der Stapel unveraendert.
     *
     * @param pContent
     *        das einzufuegende Objekt vom Typ ContentType
     */
    public void push(Object pContent) {
        //TODO 5: Implementiere die Methode push(). Wenn pContent nicht null ist, wird das Objekt auf den Stapel gelegt
    }

    /**
     * Das zuletzt eingefuegte Objekt wird von dem Stapel entfernt. Falls der
     * Stapel leer ist, bleibt er unveraendert.
     */
    public void pop() {
        //TODO 6: Implementiere die Methode pop(). Achtung! Es gibt keine RÜckgabe, wenn ein Objekt aus dem Stapel entfernt wird.
    }

    /**
     * Die Anfrage liefert das oberste Stapelobjekt. Der Stapel bleibt
     * unveraendert. Falls der Stapel leer ist, wird null zurueckgegeben.
     *
     * @return das oberste Stackelement vom Typ ContentType oder null, falls
     *         der Stack leer ist
     */
    public Object top() {
        //TODO 7: Implementiere die Methode top(). Achtung! Der Stapel bleibt dabei unverändert!
        return null;
    }
}