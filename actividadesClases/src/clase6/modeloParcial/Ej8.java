package clase6.modeloParcial;

import sources.implementacion.ColaEstatica;
import sources.implementacion.ConjuntoEstatico;

public class Ej8 {

    public static void DiferenciaColaConjunto(ColaEstatica cola, ConjuntoEstatico conjunto) {
        ColaEstatica aux = new ColaEstatica();
        aux.InicializarCola();

        while (!cola.ColaVacia()){
            if (!conjunto.Pertenece(cola.Primero())){
                aux.Acolar(cola.Primero());// Acolo si no pertenece al conjunto
            }
            cola.Desacolar(); // Desaloco para seguir recorriendo
        }
        while(!aux.ColaVacia()){ // vuelvo a llenar la cola con los elementos que no pertenecen al conjunto
            cola.Acolar(aux.Primero());
            aux.Desacolar();
        }
    }
    public static void main(String[] args) {
        // Inicializaciones
        ColaEstatica cola = new ColaEstatica();
        ConjuntoEstatico conjunto = new ConjuntoEstatico();
        cola.InicializarCola();
        conjunto.InicializarConjunto();

        // Inserto los elementos
        for(int i = 0; i < 10; ++i){
            cola.Acolar(i);
            if (i % 2 == 0) { // El conjunto solo contiene los pares
                conjunto.Agregar(i);
            }
        }

        DiferenciaColaConjunto(cola, conjunto); // Genero la diferencia entre la cola y el conjunto

        while(!cola.ColaVacia()){ // Imprimo los elementos de la cola
            System.out.print(cola.Primero() + " ");
            cola.Desacolar();
        }
    }

}
