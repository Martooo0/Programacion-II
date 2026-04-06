package sources.Implementacion;

import sources.Interfaces.PilaTDA;

/**
 * Implementación estática de una Pila (TDA) de complejidad O(n) con tope fijo en el origen.
 * * Estrategia de diseño:
 * El tope de la pila se mantiene siempre fijo en el índice [0]. Para lograr esto, es 
 * obligatorio reacomodar todos los elementos del arreglo en cada operación:
 * - Right Shift (Desplazamiento a la derecha): Al apilar, se empujan todos los elementos un 
 * índice hacia la derecha para liberar la posición [0] e insertar el nuevo valor sobreescribiendo 
 * el valor duplicado que fue desplazado.
 * - Left Shift (Desplazamiento a la izquierda): Al desapilar, todos los elementos se mueven 
 * un índice hacia la izquierda para sobreescribir el valor del índice 0, al mismo tiempo se reduce 
 * cantidad-- para realizar un soft delete y una sobreescritura eventual.
 * * Ventajas:
 * Resulta útil como ejercicio de algoritmos de corrimiento de memoria en arreglos.
 * * Desventajas:
 * Altamente ineficiente. Al tener que mover físicamente todos los datos existentes en 
 * cada operación, su complejidad matemática es lineal O(n). Esto genera un consumo excesivo 
 * de procesamiento en comparación a las alternativas O(1).
 */
public class PilaEstatica1 implements PilaTDA {
    private static final int MAX = 100;
    private int[] datos;
    private int cantidad;

    public void InicializarPila() {
        this.datos = new int[100];
        this.cantidad = 0;
    }

    public void Apilar(int x) {
        if (this.cantidad < 100) {
            for(int i = this.cantidad; i > 0; --i) {
                this.datos[i] = this.datos[i - 1];
            }
            this.datos[0] = x;
            cantidad++;
        }
    }

    public void Desapilar() {
        if (!this.PilaVacia()) {
            for(int i = 0; i < cantidad - 1; ++i) {
                datos[i] = datos[i + 1];
            }
            cantidad--;
        }
    }

    public int Tope() {
        return datos[0];
    }

    public boolean PilaVacia() {
        return cantidad == 0;
    }
}
