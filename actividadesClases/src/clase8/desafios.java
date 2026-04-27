package clase8;

import sources.implementacionDinamica.colaPrioridadDinamica.ColaPrioridadDinamica;
import sources.implementacionDinamica.conjuntoDinamico.ConjuntoDinamico;
import sources.implementacionDinamica.pilaDinamica.PilaDinamica;
import sources.interfaces.ColaPrioridadTDA;
import sources.interfaces.ConjuntoTDA;
import sources.interfaces.PilaTDA;

public class desafios {

    /// DESAFIO 2
    public static int contarPrioridadEspecifica(ColaPrioridadTDA cp, int pBuscada) {
        ColaPrioridadTDA aux = new ColaPrioridadDinamica();
        aux.InicializarColaPrioridad();
        int contador = 0;

        while (!cp.ColaVacia()) {
            if (cp.Prioridad() == pBuscada) {
                contador++;
            }
            aux.AcolarPrioridad(cp.Primero(), cp.Prioridad());
            cp.Desacolar();
        }

        // Restauración para que la cola original quede intacta
        while (!aux.ColaVacia()) {
            cp.AcolarPrioridad(aux.Primero(), aux.Prioridad());
            aux.Desacolar();
        }
        return contador;
    }

    /// DESAFIO 3
    public static void eliminarDuplicadosPila(PilaTDA p) {
        PilaTDA aux = new PilaDinamica();
        aux.InicializarPila();
        ConjuntoTDA valoresUnicos = new ConjuntoDinamico();
        valoresUnicos.InicializarConjunto();

        // Paso 1: Pasar a aux y registrar en el conjunto
        while (!p.PilaVacia()) {
            valoresUnicos.Agregar(p.Tope());
            aux.Apilar(p.Tope());
            p.Desapilar();
        }

        // Paso 2: Reconstruir la pila original sin los duplicados
        // Usamos el conjunto para saber qué elementos ya "vovieron"
        while (!aux.PilaVacia()) {
            int valor = aux.Tope();
            if (valoresUnicos.Pertenece(valor)) {
                p.Apilar(valor);
                valoresUnicos.Sacar(valor); // Evita que un duplicado entre dos veces
            }
            aux.Desapilar();
        }
    }

}
