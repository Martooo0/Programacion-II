package clase6;

import sources.implementacion.pila.PilaEstatica1;
import sources.implementacionDinamica.pilaDinamica.PilaDinamica;
import sources.implementacionDinamica.colaDinamica.ColaDinamica;

public class mainClase6 {
    public static void main(String[] args) {

        // ####### Actividad de clase #######
        /* Dado una pila estática invertirla a una pila dinámica usando una cola dinámica.*/
        PilaEstatica1 pila = new PilaEstatica1();
        pila.InicializarPila();

        ColaDinamica colaDinamica = new ColaDinamica();
        colaDinamica.InicializarCola();

        PilaDinamica pilaDinamica = new PilaDinamica();
        pilaDinamica.InicializarPila();

        System.out.println("Pila Estatica:");
        for (int i = 0; i < 10; ++i) {
            pila.Apilar(i);
            System.out.print(pila.Tope() + "");
        }

        while (!pila.PilaVacia()) {
            colaDinamica.Acolar(pila.Tope());// Se utiza una cola dinámica para invertir la pila
            pila.Desapilar();
        }

        System.out.println("\nPila Dinamica");
        while(!colaDinamica.ColaVacia()) {
            pilaDinamica.Apilar(colaDinamica.Primero());
            colaDinamica.Desacolar();
            System.out.print(pilaDinamica.Tope() + "");
        }
    }
}
