package clase6.ejerciciosGuia;


import sources.implementacionDinamica.colaDinamica.ColaDinamica;
import sources.implementacionDinamica.colaPrioridadDinamica.ColaPrioridadDinamica;
import sources.interfaces.ColaPrioridadTDA;
import sources.interfaces.ColaTDA;

public class Bloque1 {

    public void simularColaComun() {
        ColaTDA impresora = new ColaDinamica();
        impresora.InicializarCola();
        
        impresora.Acolar(101);
        impresora.Acolar(102);
        impresora.Acolar(103);
        
        impresora.Desacolar();
    }

    public void simularColaPrioridad() {
        ColaPrioridadTDA hospital = new ColaPrioridadDinamica();
        hospital.InicializarColaPrioridad();
        
        hospital.AcolarPrioridad(10, 1);
        hospital.AcolarPrioridad(25, 100);
        hospital.AcolarPrioridad(40, 50);
        
        hospital.Desacolar();
    }
}