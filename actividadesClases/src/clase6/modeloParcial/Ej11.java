package clase6.modeloParcial;
import sources.implementacion.ColaPrioridadEstatica;


public class Ej11 { // Método sin modularizar

    public static ColaPrioridadEstatica combinarColasPrioriodad(ColaPrioridadEstatica CP1, ColaPrioridadEstatica CP2) {
        ColaPrioridadEstatica CP3 = new ColaPrioridadEstatica();
        ColaPrioridadEstatica aux1 = new ColaPrioridadEstatica();
        ColaPrioridadEstatica aux2 = new ColaPrioridadEstatica();
        CP3.InicializarColaPrioridad();
        aux1.InicializarColaPrioridad();
        aux2.InicializarColaPrioridad();

        while(!CP1.ColaVacia()){
            CP3.AcolarPrioridad(CP1.Primero(), CP1.Prioridad());
            aux1.AcolarPrioridad(CP1.Primero(), CP1.Prioridad());
            CP1.Desacolar();
        }
        while(!CP2.ColaVacia()){
            CP3.AcolarPrioridad(CP2.Primero(), CP2.Prioridad());
            aux2.AcolarPrioridad(CP2.Primero(), CP2.Prioridad());
            CP2.Desacolar();
        }
        while(!aux1.ColaVacia()){
            CP1.AcolarPrioridad(aux1.Primero(), aux1.Prioridad());
            aux1.Desacolar();
        }
        while(!aux2.ColaVacia()){
            CP2.AcolarPrioridad(aux2.Primero(), aux2.Prioridad());
            aux2.Desacolar();
        }
        return CP3;
    }
}
