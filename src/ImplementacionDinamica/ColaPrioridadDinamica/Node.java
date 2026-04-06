package ImplementacionDinamica.ColaPrioridadDinamica;

public class Node {

    private int dato;
    private int prioridad;
    private ImplementacionDinamica.PilaDinamica.Node next;

    public Node(int dato, int prioridad, ImplementacionDinamica.PilaDinamica.Node next) {
        this.dato = dato;
        this.prioridad = prioridad;
        this.next = next;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public ImplementacionDinamica.PilaDinamica.Node getNext() {
        return next;
    }

    public void setNext(ImplementacionDinamica.PilaDinamica.Node next) {
        this.next = next;
    }
}
