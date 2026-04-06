package sources.Implementacion;

import sources.Interfaces.PilaTDA;

/**
 * Esta implementación de pila tiene su tope en el último valor indexado del array, por lo que se apila al final y se elimina por soft delete, reduciendo el contador.
 * Posee una complejidad matematica de O(1)
 */


public class PilaEstatica3 implements PilaTDA {
    private static final int MAX = 100;
    private int[] datos;
    private int cantidad;

    public void InicializarPila() {
        datos = new int[100];
        cantidad = 0;
    }

    public void Apilar(int x) {
        if (cantidad < 100) {
            datos[cantidad] = x;
            cantidad++;
        }
    }

    public void Desapilar() {
        if (!PilaVacia()) {
            cantidad--;
        }
    }

    public int Tope() {
        return datos[cantidad - 1];
    }

    public boolean PilaVacia() {
        return cantidad == 0;
    }
}
