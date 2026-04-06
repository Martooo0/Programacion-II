package ImplementacionDinamica.DiccionarioSimpleDinamico;

import ImplementacionDinamica.PilaDinamica.Node;
import Interface.DiccionarioSimpleTDA;

public class DiccionarioSimpleDinamico implements DiccionarioSimpleTDA {

    private Node cabeza; // lista enlazada de pares clave-valor

    @Override
    public void InicializarDiccionario() {
        cabeza = null;
    }

    @Override
    public void Agregar(int clave, int valor) {
        Node curr = cabeza;

        // Si la clave ya existe, actualiza su valor.
        while (curr != null && curr.getClave() != clave) {
            curr = curr.getNext();
        }

        if (curr != null) {
            curr.setValor(valor);
        } else {
            cabeza = new Node(clave, valor, cabeza);
        }
    }

    @Override
    public void Eliminar(int clave) {
        Node curr = cabeza;
        Node prev = null;

        while (curr != null && curr.getClave() != clave) {
            prev = curr;
            curr = curr.getNext();
        }

        if (curr != null) {
            if (prev == null) {
                cabeza = curr.getNext();
            } else {
                prev.setNext(curr.getNext());
            }
        }
    }

    @Override
    public int[] Claves() {
        int count = 0;
        Node curr = cabeza;
        while (curr != null) {
            count++;
            curr = curr.getNext();
        }

        int[] result = new int[count];
        curr = cabeza;
        for (int i = 0; i < count; i++) {
            result[i] = curr.getClave();
            curr = curr.getNext();
        }
        return result;
    }
}
