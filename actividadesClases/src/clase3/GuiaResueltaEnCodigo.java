package clase3;

import sources.implementacionDinamica.colaDinamica.ColaDinamica;
import sources.implementacionDinamica.colaPrioridadDinamica.ColaPrioridadDinamica;
import sources.interfaces.ColaTDA;
import sources.interfaces.ColaPrioridadTDA;

public class GuiaResueltaEnCodigo {
    public static void main(String[] args) {

        // ==========================================
        // INICIALIZACIÓN DE ESTRUCTURAS
        // ==========================================

        ColaTDA filaBanco = new ColaDinamica();
        filaBanco.InicializarCola();

        ColaTDA colaArchivo = new ColaDinamica();
        colaArchivo.InicializarCola();

        // OJO: Se quita el <String> porque la interfaz maneja 'int'
        ColaPrioridadTDA guardia = new ColaPrioridadDinamica();
        guardia.InicializarColaPrioridad(); // Método correcto según interfaz

        ColaPrioridadTDA filaExamen = new ColaPrioridadDinamica();
        filaExamen.InicializarColaPrioridad();

        ColaPrioridadTDA scheduler = new ColaPrioridadDinamica();
        scheduler.InicializarColaPrioridad();

        ColaPrioridadTDA embarque = new ColaPrioridadDinamica();
        embarque.InicializarColaPrioridad();

        ColaPrioridadTDA soporteIT = new ColaPrioridadDinamica();
        soporteIT.InicializarColaPrioridad();

        // ==========================================
        // EJECUCIÓN DE EJERCICIOS (Usando IDs numéricos)
        // ==========================================

        System.out.println("--- Ejercicio 1: Fila del Banco ---");
        filaBanco.Acolar(1); // 1 = Cliente 1
        filaBanco.Acolar(2); // 2 = Cliente 2
        filaBanco.Acolar(3); // 3 = Cliente 3
        filaBanco.Acolar(4); // 4 = Cliente 4
        filaBanco.Acolar(5); // 5 = Cliente 5

        while (!filaBanco.ColaVacia()) {
            System.out.println("Atendiendo ID Cliente: " + filaBanco.Primero());
            filaBanco.Desacolar();
        }

        System.out.println("\n--- Ejercicio 2: Archivos ---");
        colaArchivo.Acolar(2); // 2 = Archivo 2
        colaArchivo.Acolar(1); // 1 = Archivo 1
        colaArchivo.Acolar(5); // 5 = Archivo 5
        colaArchivo.Acolar(3); // 3 = Archivo 3
        colaArchivo.Acolar(4); // 4 = Archivo 4

        while (!colaArchivo.ColaVacia()) {
            System.out.println("Imprimiendo ID Archivo: " + colaArchivo.Primero());
            colaArchivo.Desacolar();
        }

        System.out.println("\n--- Ejercicio 3: Guardia Hospital ---");
        guardia.AcolarPrioridad(10, 1);     // 10 = Pibe con raspón
        guardia.AcolarPrioridad(20, 100);   // 20 = Jubilado con bobazo
        guardia.AcolarPrioridad(30, 80);    // 30 = Fractura expuesta
        guardia.AcolarPrioridad(40, 20);    // 40 = Gripe fuerte
        guardia.AcolarPrioridad(50, 5);     // 50 = Renovar receta

        while (!guardia.ColaVacia()) {
            System.out.println("Paciente ID: " + guardia.Primero() + " (Prioridad: " + guardia.Prioridad() + ")");
            guardia.Desacolar();
        }

        System.out.println("\n--- Ejercicio 4: Fila Examen ---");
        filaExamen.AcolarPrioridad(1, 5);  // 1 = Alumno Regular
        filaExamen.AcolarPrioridad(2, 10); // 2 = Alumno Promocionado

        while (!filaExamen.ColaVacia()) {
            System.out.println("Alumno ID: " + filaExamen.Primero() + " (Prioridad: " + filaExamen.Prioridad() + ")");
            filaExamen.Desacolar();
        }

        System.out.println("\n--- Ejercicio 5: Scheduler SO ---");
        scheduler.AcolarPrioridad(100, 10); // 100 = Spotify
        scheduler.AcolarPrioridad(101, 10); // 101 = Google Chrome
        scheduler.AcolarPrioridad(102, 50); // 102 = Gestor de Memoria
        scheduler.AcolarPrioridad(103, 50); // 103 = Antivirus del SO

        while (!scheduler.ColaVacia()) {
            System.out.println("Ejecutando Proceso ID: " + scheduler.Primero() + " (Prioridad: " + scheduler.Prioridad() + ")");
            scheduler.Desacolar();
        }

        System.out.println("\n--- Ejercicio 6: Embarque ---");
        embarque.AcolarPrioridad(1, 1); // 1 = Mortal 1 (Llegó primero)
        embarque.AcolarPrioridad(2, 1); // 2 = Mortal 2 (Llegó segundo)
        embarque.AcolarPrioridad(3, 2); // 3 = Pasajero Business

        while (!embarque.ColaVacia()) {
            System.out.println("Sube Pasajero ID: " + embarque.Primero() + " (Prioridad: " + embarque.Prioridad() + ")");
            embarque.Desacolar();
        }

        System.out.println("\n--- Ejercicio 7: Soporte IT ---");
        soporteIT.AcolarPrioridad(404, 0);   // 404 = Fondo de pantalla
        soporteIT.AcolarPrioridad(500, 999); // 500 = SE ROMPIÓ EL SERVIDOR

        while (!soporteIT.ColaVacia()) {
            System.out.println("Resolviendo Ticket ID: " + soporteIT.Primero() + " (Prioridad: " + soporteIT.Prioridad() + ")");
            soporteIT.Desacolar();
        }
    }
}