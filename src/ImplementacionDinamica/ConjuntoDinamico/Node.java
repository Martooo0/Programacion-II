package ImplementacionDinamica.ConjuntoDinamico;

public class Node {

    private int data;
    private ImplementacionDinamica.PilaDinamica.Node next;

    public Node(int data, ImplementacionDinamica.PilaDinamica.Node next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ImplementacionDinamica.PilaDinamica.Node getNext() {
        return next;
    }

    public void setNext(ImplementacionDinamica.PilaDinamica.Node next) {
        this.next = next;
    }
}
