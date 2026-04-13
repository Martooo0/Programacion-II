package implementacionDinamica.diccionarioSimpleDinamico;

public class Node {

    private int clave;
    private int valor;
    private Node next;

    public Node(int clave, int valor, Node next) {
        this.clave = clave;
        this.valor = valor;
        this.next = next;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}