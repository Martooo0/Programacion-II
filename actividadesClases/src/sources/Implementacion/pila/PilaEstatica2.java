package implementacion.pila;

import interfaces.PilaTDA;

/**
 * Implementación estática de una Pila (TDA) de complejidad O(1) basada en "Señalización en banda".
 * * Estrategia de diseño:
 * Utiliza el índice [0] del propio arreglo para almacenar el contador de elementos (estado), 
 * reservando los índices del [1] en adelante para los datos reales. El tope de la pila 
 * siempre se encuentra apuntado por el valor almacenado en datos[0].
 * * Ventajas:
 * Ausencia de variables de estado externas, abogando por un uso estructuralmente mínimo 
 * de la memoria.
 * * Desventajas:
 * Rompe el principio "KISS" y el de Separación de Responsabilidades, ya que el arreglo 
 * mezcla metadatos de control con datos de usuario, reduciendo radicalmente la legibilidad.
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
            datos[datos[0]] = x;
            datos[0]++;
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
        return datos[datos[0]]-1;
    }

    @Override
    public boolean PilaVacia() {
        return datos[0] == 0;
    }
}
