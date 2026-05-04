package clase6.ejerciciosGuia;


import sources.implementacionDinamica.colaDinamica.ColaDinamica;
import sources.implementacionDinamica.colaPrioridadDinamica.ColaPrioridadDinamica;
import sources.interfaces.ColaPrioridadTDA;
import sources.interfaces.ColaTDA;

public class Bloque2 {

    public void ejercicios() {
        // 1. Fila del Cajero
        ColaTDA banco = new ColaDinamica();
        banco.InicializarCola();

        // 2. Impresora del Laboratori
        ColaTDA impresora = new ColaDinamica();
        impresora.InicializarCola();
        impresora.Acolar(1);
        impresora.Acolar(2); 

        // 3. Guardia Hospital (Triage)
        ColaPrioridadTDA guardia = new ColaPrioridadDinamica();
        guardia.InicializarColaPrioridad();
        guardia.AcolarPrioridad(111, 1);
        guardia.AcolarPrioridad(222, 100); 

        // 4. Examen Final
        ColaPrioridadTDA finalProg = new ColaPrioridadDinamica();
        finalProg.InicializarColaPrioridad();
        finalProg.AcolarPrioridad(800, 5); 
        finalProg.AcolarPrioridad(830, 10); 

        // 5. Buffet Facultad
        ColaTDA buffet = new ColaDinamica();
        buffet.InicializarCola();
        buffet.Acolar(1);
        buffet.Acolar(2);
        // Asi me doy cuenta xq al desacolar salen en orden de llegada

        // 6. Procesador de Tareas
        ColaPrioridadTDA cpu = new ColaPrioridadDinamica();
        cpu.InicializarColaPrioridad();
        cpu.AcolarPrioridad(1, 50); 
        cpu.AcolarPrioridad(2, 10); 

        // 7. Embarque Aerolíneas
    
        ColaPrioridadTDA avion = new ColaPrioridadDinamica();
        avion.InicializarColaPrioridad();
        avion.AcolarPrioridad(10, 3);
        avion.AcolarPrioridad(20, 3); 

        // 8. Tickets IT
        ColaPrioridadTDA soporte = new ColaPrioridadDinamica();
        soporte.InicializarColaPrioridad();
        soporte.AcolarPrioridad(1, 999); 
        soporte.AcolarPrioridad(2, 0);   
    }
}