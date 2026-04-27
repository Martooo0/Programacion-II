package clase8;

// Interfaces

import sources.interfaces.ColaTDA;
import sources.interfaces.ColaPrioridadTDA;

// Y aca las implementaciones

import sources.implementacionDinamica.colaDinamica.ColaDinamica;
import sources.implementacionDinamica.colaPrioridadDinamica.ColaPrioridadDinamica;

// Primero paso la cola normal a una con prioridad, asi la ordeno (con lo de P = 0 y demás). Después se vuelve a pasar a otra cola dinámica
// Entonces me queda una cola con solo FIFO, donde van a salir los positivos, el cero y los negativos, con el orden que corresponde.

public class Desafio5 {

    public static ColaTDA ordenar(ColaTDA cola) {
        // Paso 1: vaciamos la cola en una cola con prioridad.
        ColaPrioridadTDA cp = new ColaPrioridadDinamica();
        cp.InicializarColaPrioridad();

        while (!cola.ColaVacia()) {
            int x = cola.Primero();

            // según la regla
            int prioridad;
            if (x < 0) {
                prioridad = 0;  // negativos: prioridad más baja
            } else if (x == 0) {
                prioridad = 1;  // cero: prioridad media
            } else {
                prioridad = 2;  // positivos: prioridad más alta
            }

            cp.AcolarPrioridad(x, prioridad);
            cola.Desacolar();
        }

        // Cola dinámica.
        // Como la cola con prioridad entrega de mayor a menor, la cola resultante queda ya con el orden.
        ColaTDA resultado = new ColaDinamica();
        resultado.InicializarCola();

        while (!cp.ColaVacia()) {
            resultado.Acolar(cp.Primero());
            cp.Desacolar();
        }
        return resultado;
    }

}
