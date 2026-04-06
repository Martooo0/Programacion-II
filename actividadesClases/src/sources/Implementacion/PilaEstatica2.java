package sources.Implementacion;

import sources.Interfaces.PilaTDA;

/**
 * Esta implementación de pila utiliza el primer valor del array como el contador, por lo que cada vez que se utiliza datos[datos[0]] se está acudiendo al dato del índice posterior al último ingresado 
 * Posee una complejidad matematica de O(1), la ventaja es la ausencia de necesidad de una variable externa, avogando por un uso menor de memoria, la desventaja es que rompe el que viola el principio "KISS" 
 */


public class PilaEstatica2 implements PilaTDA {
    private int[] datos;

    @Override
    public void InicializarPila() {
        datos = new int[101]; 
        datos[0] = 0;
    }

    @Override
    public void Apilar(int x) {
        if (datos[0] < 100) {
            datos[0]++;
            datos[datos[0]] = x;
        }
    }

    @Override
    public void Desapilar() {
        if (!PilaVacia()) {
            datos[0]--;
        }
    }

    @Override
    public int Tope() {
        return datos[datos[0]];
    }

    @Override
    public boolean PilaVacia() {
        return datos[0] == 0;
    }
}
