package implementacion.pila;

import interfaces.PilaTDA;

/**
 * Implementación estática de una Pila (TDA) de complejidad O(1) basada en un contador externo.
 * * Estrategia de diseño:
 * Utiliza una variable independiente (cantidad) para gestionar la frontera lógica de la pila. 
 * El tope siempre se ubica en el último elemento ingresado (cantidad - 1). La eliminación 
 * de elementos se realiza mediante baja lógica (Soft Delete) reduciendo el contador.
 * * Ventajas:
 * Alta legibilidad, código limpio (Clean Code) y estricto cumplimiento de la Separación 
 * de Responsabilidades. Es la implementación estándar y recomendada en la industria.
 * * Desventajas:
 * Requiere la declaración de una variable de estado adicional, aunque su impacto en 
 * la memoria es imperceptible frente a los beneficios enormes de mantenimiento.
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
