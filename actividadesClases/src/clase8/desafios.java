package clase8;

import sources.implementacionDinamica.colaDinamica.ColaDinamica;
import sources.implementacionDinamica.colaPrioridadDinamica.ColaPrioridadDinamica;
import sources.implementacionDinamica.conjuntoDinamico.ConjuntoDinamico;
import sources.implementacionDinamica.pilaDinamica.PilaDinamica;
import sources.interfaces.ColaPrioridadTDA;
import sources.interfaces.ColaTDA;
import sources.interfaces.ConjuntoTDA;
import sources.interfaces.PilaTDA;

public class desafios {

    ///DESAFIO 1
    public static boolean esPalindromo(ColaTDA c) {
        PilaTDA p = new PilaDinamica(); p.InicializarPila();
        ColaTDA aux = new ColaDinamica(); aux.InicializarCola();
        while (!c.ColaVacia()) {
            int valor = c.Primero();
            p.Apilar(valor);
            aux.Acolar(valor);
            c.Desacolar();
        }

        boolean esPalin = true;
        while (!aux.ColaVacia()) {
            int valOriginal = aux.Primero();
            int valInvertido = p.Tope();

            if (valOriginal != valInvertido) {
                esPalin = false;
            }
            c.Acolar(valOriginal);
            aux.Desacolar();
            p.Desapilar();
        }
        return esPalin;
    }

    /// DESAFIO 2
    public static int contarPrioridadUno(ColaPrioridadTDA cp) {
        ColaPrioridadTDA aux0 = new ColaPrioridadDinamica(); aux0.InicializarColaPrioridad();
        ColaPrioridadTDA aux1 = new ColaPrioridadDinamica(); aux1.InicializarColaPrioridad();
        int contador = 0;
        while (!cp.ColaVacia() && cp.Prioridad() == 0) {
            aux0.AcolarPrioridad(cp.Primero(), 0);
            cp.Desacolar();
        }
        while (!cp.ColaVacia() && cp.Prioridad() == 1) {
            contador++;
            aux1.AcolarPrioridad(cp.Primero(), 1);
            cp.Desacolar();
        }
        while (!aux0.ColaVacia()) {
            cp.AcolarPrioridad(aux0.Primero(), 0);
            aux0.Desacolar();
        }
        while (!aux1.ColaVacia()) {
            cp.AcolarPrioridad(aux1.Primero(), 1);
            aux1.Desacolar();
        }
        return contador;
    }


    /// DESAFIO 3
    public static void eliminarDuplicadosPila(PilaTDA p) {
        PilaTDA aux = new PilaDinamica(); aux.InicializarPila();
        ConjuntoTDA valoresUnicos = new ConjuntoDinamico(); valoresUnicos.InicializarConjunto();

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

    ///  DESAFIO 4
    public static ConjuntoTDA diferenciaSimetrica(ConjuntoTDA a, ConjuntoTDA b) {
        // Instanciamos el conjunto resultado usando la implementación dinámica de tu repo
        ConjuntoTDA resultado = new ConjuntoDinamico();
        resultado.InicializarConjunto();

        ConjuntoTDA auxA = new ConjuntoDinamico();
        auxA.InicializarConjunto();

        ConjuntoTDA auxB = new ConjuntoDinamico();
        auxB.InicializarConjunto();

        // --- PASADA 1: Calculamos (A - B) ---
        // Recorremos A. Si el valor NO pertenece a B, lo agregamos al resultado.
        while (!a.ConjuntoVacio()) {
            int valor = a.Elegir();
            if (!b.Pertenece(valor)) {
                resultado.Agregar(valor);
            }
            auxA.Agregar(valor); // Guardamos para no perder el dato
            a.Sacar(valor);      // Avanzamos en la iteración
        }

        // Restauramos el conjunto A original (Regla de oro de los TDA)
        while (!auxA.ConjuntoVacio()) {
            int valor = auxA.Elegir();
            a.Agregar(valor);
            auxA.Sacar(valor);
        }

        // --- PASADA 2: Calculamos (B - A) ---
        // Recorremos B. Si el valor NO pertenece a A, lo agregamos al resultado.
        while (!b.ConjuntoVacio()) {
            int valor = b.Elegir();
            if (!a.Pertenece(valor)) {
                resultado.Agregar(valor);
            }
            auxB.Agregar(valor);
            b.Sacar(valor);
        }

        // Restauramos el conjunto B original
        while (!auxB.ConjuntoVacio()) {
            int valor = auxB.Elegir();
            b.Agregar(valor);
            auxB.Sacar(valor);
        }

        return resultado;
    }

    /// DESAFIO 5
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


