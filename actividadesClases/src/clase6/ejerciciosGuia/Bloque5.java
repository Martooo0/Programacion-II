package clase6.ejerciciosGuia;


import sources.implementacionDinamica.colaPrioridadDinamica.ColaPrioridadDinamica;
import sources.implementacionDinamica.diccionarioMultipleDinamico.DiccionarioMultipleDinamico;
import sources.implementacionDinamica.pilaDinamica.PilaDinamica;
import sources.interfaces.ColaPrioridadTDA;
import sources.interfaces.DiccionarioMultipleTDA;
import sources.interfaces.PilaTDA;


public class Bloque5 {

    public void ejercicios() {
        
        // 1. Hospital Premium
        ColaPrioridadTDA guardia = new ColaPrioridadDinamica();
        guardia.InicializarColaPrioridad();
        guardia.AcolarPrioridad(100, 1); 

        // Historial de Síntomas del paciente 100
        PilaTDA sintomasP100 = new PilaDinamica();
        sintomasP100.InicializarPila();
        sintomasP100.Apilar(1); 
        sintomasP100.Apilar(2); 

        // 2. Sistema de Tags de Facultad 
        DiccionarioMultipleTDA facultad = new DiccionarioMultipleDinamico();
        facultad.InicializarDiccionario();
        facultad.Agregar(10, 101);
        facultad.Agregar(10, 102);

    }
}