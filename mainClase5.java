package clase5;

// Import Interfaces

import sources.interfaces.PilaTDA;
import sources.interfaces.ColaTDA;
import sources.interfaces.ConjuntoTDA;
import sources.interfaces.DiccionarioSimpleTDA;
import sources.interfaces.DiccionarioMultipleTDA;

// Import Implementaciones Dinámicas

import sources.implementacionDinamica.pilaDinamica.PilaDinamica;
import sources.implementacionDinamica.colaDinamica.ColaDinamica;
import sources.implementacionDinamica.colaPrioridadDinamica.ColaPrioridadDinamica;
import sources.implementacionDinamica.conjuntoDinamico.ConjuntoDinamico;
import sources.implementacionDinamica.diccionarioSimpleDinamico.DiccionarioSimpleDinamico;
import sources.implementacionDinamica.diccionarioMultipleDinamico.DiccionarioMultipleDinamico;

import java.sql.SQLOutput;

public class mainClase5 {
    public static void main(String[] args) {

        // ==============================================================
        // Ejercicios de Bloque 1: Pilas (LIFO - Last In, First Out)
        // El último que entró es el primero que sale
        // ==============================================================

        // --- 1 Historial de Navegación

        PilaTDA historial = new PilaDinamica();
        historial.InicializarPila();

        historial.Apilar(1); // Primer pagina visitada
        historial.Apilar(2); // segunda
        historial.Apilar(3); // Tercera

        System.out.println("El ultimo elemento es: " + historial.Tope()); // Aca se va a mostrar la última
        historial.Desapilar();
        System.out.println("El ultimo elemento es: " + historial.Tope()); // Aca se muestra la segunda o la nueva última o anterior a la tercera

        // --- 2 Editor de Código

        PilaTDA historialDelEditor = new PilaDinamica();
        historialDelEditor.InicializarPila();

        historialDelEditor.Apilar(100); // Estado base
        historialDelEditor.Apilar(101); // Escrito
        historialDelEditor.Apilar(102); // Error o borrado

        System.out.println("Estado actual: " + historialDelEditor.Tope());
        historialDelEditor.Desapilar();
        System.out.println("Estado actual: " + historialDelEditor.Tope());

        // --- 3 Balanceo de Paréntesis

        // ( ( A + B ) * C )
        int[] expresion = {1, 1, 0, 0, 0, 2, 0, 0, 2}; // Siendo 1: ( | 2: )

        PilaTDA parentesis = new PilaDinamica();
        parentesis.InicializarPila();
        boolean chequeoLlaveAbierta = false;

        for (int valorActual : expresion) {
            if (valorActual == 1) {
                parentesis.Apilar(valorActual); // Cuando encuentra a "(" apila
            } else if (valorActual == 2) {
                if (parentesis.PilaVacia()) { // Antes de desapilar veo si existe la llave
                    chequeoLlaveAbierta = true;
                } else {
                    parentesis.Desapilar();
                }
            }
        }

        if (!chequeoLlaveAbierta && parentesis.PilaVacia()) { // Aca puede haber dos casos de error: que esté desbalanceada o que no estén todas las "()" cerradas.
            System.out.println("Balanceada");
        } else {
            System.out.println("No esta balanceada la expresión, chequear las '()'");
        }

        // --- 4 Reversion de Strings

        int[] palabraNumerica = {65, 76, 71, 79, 82, 73, 84, 77, 79, 83}; // Es la palabra "Algoritmos" en números ASCII

        PilaTDA pilaPalabra = new PilaDinamica();
        pilaPalabra.InicializarPila();

        for (int valorLetra : palabraNumerica) {
            pilaPalabra.Apilar(valorLetra); // Guardamos el array aca primero
        }

        System.out.println("\nPalabra invertida: ");
        while (!pilaPalabra.PilaVacia()) { // aca, hasta vaciarla, la desapilamos y queda al revés la palabra, ya que el tope de la pila tiene la última letra
            System.out.print(pilaPalabra.Tope() + " ");
            pilaPalabra.Desapilar();
        } // Después si queremos volver a tener la palabra en orden, apilamos devuelta en otra pila
        System.out.println();

        // --- 5 Pila de Llamadas (Call Stack)

        PilaTDA callStack = new PilaDinamica();
        callStack.InicializarPila();

        callStack.Apilar(100); // Main
        callStack.Apilar(101); // CalculaPromedio
        callStack.Apilar(102); // Suma

        System.out.println("La primer operación que se va a ejecutar es: " + callStack.Tope());
        callStack.Desapilar();
        System.out.println("sigue:" + callStack.Tope());

        // --- 6 Navegación de Directorios

        PilaTDA directorios = new PilaDinamica();
        directorios.InicializarPila();

        directorios.Apilar(100); // C:/
        directorios.Apilar(101); // Usuarios
        directorios.Apilar(102); // Documentos

        System.out.println("Actualmente en " + directorios.Tope());
        System.out.println("Subir un nivel");
        directorios.Desapilar();
        System.out.println("Actualmente en " + directorios.Tope());

        // =================================================================
        //   Ejercicios de Bloque 2: Colas y Colas con Prioridad (FIFO -
        //   In, First Out + Ranking - Mayor Prioridad = Mayor Valor Entero)
        // =================================================================

        // 1 Fila del Cajero

        ColaPrioridadDinamica cajero = new ColaPrioridadDinamica();
        cajero.InicializarColaPrioridad();

        // Cuanto más alto el número, más urgente
        cajero.AcolarPrioridad(85, 30); // Cliente 2: 3era edad
        cajero.AcolarPrioridad(54, 25); // Cliente 4: Discapacidad grave
        cajero.AcolarPrioridad(74, 20); // Cliente 5: Discapacitado leve de 3era edad
        cajero.AcolarPrioridad(25, 15); // Cliente 3: Discapacidad leve
        cajero.AcolarPrioridad(21, 10); // Cliente 1: Normal


        System.out.println("El cliente con mayor prioridad es: " + cajero.Primero() + " (prioridad " + cajero.Prioridad() + ")");
        System.out.println("Orden de la cola de clientes: ");

        while (!cajero.ColaVacia()) {
            System.out.print(cajero.Primero() + "");
            cajero.Desacolar();
        }

        // 2 Impresora de Laboratorio

        ColaPrioridadDinamica impresora = new ColaPrioridadDinamica();
        impresora.InicializarColaPrioridad();
        impresora.AcolarPrioridad(1,-200); // Impresora 1 con archivo de peso de 200 kbs
        impresora.AcolarPrioridad(3,-100); // Impresora 3 con archivo de peso de 100 kbs
        impresora.AcolarPrioridad(2,-50);  // Impresora 2 con archivo de peso de 50 kbs
        impresora.AcolarPrioridad(4,-220); // Impresora 4 con archivo de peso de 200 kbs
        impresora.AcolarPrioridad(6,-125); // Impresora 6 con archivo de peso de 125 kbs
        impresora.AcolarPrioridad(5,-25);  // Impresora 5 con archivo de peso de 25 kbs

        System.out.println("La impresora con mayor prioridad es: " + impresora.Primero() + " (prioridad " + impresora.Prioridad() + ")");
        System.out.println("Orden de la cola de impresoras: ");

        while (!impresora.ColaVacia()) {
            System.out.print(impresora.Primero() + " ");
            impresora.Desacolar();
        }

        // 3 Guardia del Hospital (Triage)

        ColaPrioridadDinamica guardiaHospital = new ColaPrioridadDinamica();
        guardiaHospital.InicializarColaPrioridad();
        guardiaHospital.AcolarPrioridad(5,   1); // Paciente con raspón
        guardiaHospital.AcolarPrioridad(2, 100); // Paciente de 3.ª edad con mareo
        guardiaHospital.AcolarPrioridad(3, 150); // Paciente con fracturas multiples
        guardiaHospital.AcolarPrioridad(4, 155); // Paciente en labor de parto
        guardiaHospital.AcolarPrioridad(6,  10); // Paciente con dolor de garganta
        guardiaHospital.AcolarPrioridad(1, 250); // Paciente con ACV

        System.out.println("El paciente de mayor prioridad es: " + guardiaHospital.Primero() + " (prioridad " + guardiaHospital.Prioridad() + ")");
        System.out.println("Orden de atención de pacientes: ");

        while (!guardiaHospital.ColaVacia()) {
            System.out.print(guardiaHospital.Primero() + " ");
            guardiaHospital.Desacolar();
        }

        // 4 Examen Final (Promocionados vs. Regulares)

        ColaPrioridadDinamica examenFinal = new ColaPrioridadDinamica();
        examenFinal.InicializarColaPrioridad();

        // id del alumno, prioridad (10 = promocionado, 5 = regular)
        examenFinal.AcolarPrioridad(101, 5);  // Alumno 101: Regular — llegó a las 8:00 AM
        examenFinal.AcolarPrioridad(202, 10); // Alumno 202: Promocionado — llegó a las 8:30 AM

        System.out.println("--- Examen Final:");
        System.out.println("Primero en pasar: " + examenFinal.Primero() + " prioridad: " + examenFinal.Prioridad());

        while (!examenFinal.ColaVacia()) {
            System.out.print("Alumno " + examenFinal.Primero() + " | ");
            examenFinal.Desacolar();
        }

        // 5 Buffet de la Facultad

        ColaTDA buffet = new ColaDinamica();
        buffet.InicializarCola();

        buffet.Acolar(1); // Alumno 1 llega primero
        buffet.Acolar(2); // Alumno 2 llega segundo
        buffet.Acolar(3); // Alumno 3 llega tercero

        System.out.println("Operación para evitar a los colados: Acolar() porque siempre agrega al final");

        while (!buffet.ColaVacia()) {
            System.out.print("Alumno " + buffet.Primero() + " | ");
            buffet.Desacolar();
        }

        // 6 Procesador de Tareas (OS Scheduler)

        ColaPrioridadDinamica scheduler = new ColaPrioridadDinamica();
        scheduler.InicializarColaPrioridad();

        // Establezco: id del proceso, prioridad
        scheduler.AcolarPrioridad(1, 50); // Proceso del sistema: Antivirus
        scheduler.AcolarPrioridad(2, 50); // Proceso del sistema: Actualización SO
        scheduler.AcolarPrioridad(3, 10); // Proceso del usuario: Spotify
        scheduler.AcolarPrioridad(4, 10); // Proceso del usuario: Chrome
        scheduler.AcolarPrioridad(5, 50); // Proceso del sistema: Gestor de red

        System.out.println("Orden de ejecucion de procesos (50=sistema, 10=usuario):");

        while (!scheduler.ColaVacia()) {
            System.out.print("PID " + scheduler.Primero() + " (prio " + scheduler.Prioridad() + ") | ");
            scheduler.Desacolar();
        }

        // 7 Embarque de Aerolíneas

        ColaPrioridadDinamica embarque = new ColaPrioridadDinamica();
        embarque.InicializarColaPrioridad();

        // Establezco: id del pasajero, prioridad (3=movilidad reducida, 2=Business, 1=Economy)
        embarque.AcolarPrioridad(10, 3); // Pasajero con silla de ruedas
        embarque.AcolarPrioridad(20, 3); // Otro pasajero con movilidad reducida (misma prioridad que 10)
        embarque.AcolarPrioridad(30, 2); // Pasajero Business A
        embarque.AcolarPrioridad(40, 2); // Pasajero Business B (misma prioridad que 30)
        embarque.AcolarPrioridad(50, 1); // Pasajero Economy

        System.out.println("Si dos pasajeros tienen la misma prioridad, embarca primero el que llego antes.");

        while (!embarque.ColaVacia()) {
            System.out.print("Pasajero " + embarque.Primero() + " con prioridad " + embarque.Prioridad() + " | ");
            embarque.Desacolar();
        }

        // 8 Distribución de Tickets IT

        ColaPrioridadDinamica ticketsIT = new ColaPrioridadDinamica();
        ticketsIT.InicializarColaPrioridad();

        // Establezco: id del ticket, prioridad
        ticketsIT.AcolarPrioridad(1, 0);   // Ticket 1: "No me gusta el fondo de pantalla"
        ticketsIT.AcolarPrioridad(2, 50);  // Ticket 2: Problema con impresora
        ticketsIT.AcolarPrioridad(3, 999); // Ticket 3: Se rompio el servidor principal
        ticketsIT.AcolarPrioridad(4, 10);  // Ticket 4: Mail no llega

        System.out.println("Tickets: 999 = critico | 0 = irrelevante");

        while (!ticketsIT.ColaVacia()) {
            System.out.print("Ticket " + ticketsIT.Primero() + " con prioridad " + ticketsIT.Prioridad() + " | ");
            ticketsIT.Desacolar();
        }

        // =========================================================================
        // Ejercicios de Bloque 3: Conjuntos (Sin duplicados)
        // No hay orden y no hay repetidos
        // =========================================================================

        // 1 Padron Electoral

        ConjuntoTDA padron = new ConjuntoDinamico();
        padron.InicializarConjunto();

        int legajoMartin = 1010;

        System.out.println("Legajo " + legajoMartin + " quiere votar");
        if (padron.Pertenece(legajoMartin)) {
            System.out.println("Ya voto, rechazado");
        } else {
            padron.Agregar(legajoMartin);
            System.out.println("Voto registrado");
        }

        // 2 Invitados a la Fiesta

        ConjuntoTDA fiesta = new ConjuntoDinamico();
        fiesta.InicializarConjunto();

        int legajoMartin2 = 3333;

        System.out.println("Agregando a Martin");
        fiesta.Agregar(legajoMartin2);

        System.out.println("Intentando agregar a Martin otra vez");
        fiesta.Agregar(legajoMartin2);

        int cantidadReal = 0;

        while (!fiesta.ConjuntoVacio()) {
            int invitado = fiesta.Elegir();
            fiesta.Sacar(invitado);
            cantidadReal++;
        }

        System.out.println("Cantidad real: " + cantidadReal);

        // 3 Filtro de Spam

        ConjuntoTDA blacklist = new ConjuntoDinamico();
        blacklist.InicializarConjunto();
        blacklist.Agregar(999); // Al numero 999 lo hago simular como palabra: "Crypto"
        blacklist.Agregar(888); // Al numero 888 lo hago simular como palabra: "Ganá"

        int palabraDelMail = 999;
        boolean esSpam = false;

        ConjuntoTDA auxiliar = new ConjuntoDinamico();
        auxiliar.InicializarConjunto();

        while (!blacklist.ConjuntoVacio()) {
            int valorActual = blacklist.Elegir();

            if (valorActual == palabraDelMail) {
                esSpam = true;
            }

            auxiliar.Agregar(valorActual);
            blacklist.Sacar(valorActual);
        }

        while (!auxiliar.ConjuntoVacio()) {
            int valorRestaurar = auxiliar.Elegir();
            blacklist.Agregar(valorRestaurar);
            auxiliar.Sacar(valorRestaurar);
        }

        System.out.println("El mail es spam?: " + esSpam);

        // 4 Tags de un Blog de Ingeniería

        ConjuntoTDA tags = new ConjuntoDinamico();
        tags.InicializarConjunto();

        int tagJava = 100; // "Java"

        System.out.println("Agregando tag: Java");
        tags.Agregar(tagJava);

        System.out.println("Agregando nuevamente el tag: Java");
        tags.Agregar(tagJava); // Sin repetido

        // 5 Gestion de Legajos

        ConjuntoTDA legajos = new ConjuntoDinamico();
        legajos.InicializarConjunto();

        int legajoAlumno = 12345;

        if (!legajos.Pertenece(legajoAlumno)) { // Se anota a su primera carrera
            legajos.Agregar(legajoAlumno);
            System.out.println("El alumno " + legajoAlumno + " se registro");
        }

        if (!legajos.Pertenece(legajoAlumno)) { // Se anota a una segunda carrera
            legajos.Agregar(legajoAlumno);
        } else {
            System.out.println("El legajo esta registrado en el sistema");
        }

        // 6 Operación Elegir vs. Sacar

        ConjuntoTDA pruebaElegir = new ConjuntoDinamico();
        pruebaElegir.InicializarConjunto();
        pruebaElegir.Agregar(50);
        pruebaElegir.Agregar(60);

        int primerLlamado = pruebaElegir.Elegir();
        int segundoLlamado = pruebaElegir.Elegir();

        System.out.println("Primer llamado a Elegir(): " + primerLlamado);
        System.out.println("Segundo llamado a Elegir(): " + segundoLlamado);
        System.out.println("Entonces, en conclusion, va a devolver el mismo elemento porque no se borro");

        // Ejercicios de Bloque 4: Diccionarios Simples y Multiples (Concepto: Clave - Valor) Tiene una unica clave con uno o más valores

        // 1 Agenda de Contactos

        DiccionarioSimpleTDA agendaContactos = new DiccionarioSimpleDinamico();
        agendaContactos.InicializarDiccionario();
        agendaContactos.Agregar(12, 1132457854); // Contacto ID 12 → tel 1132457854
        agendaContactos.Agregar(13, 1145678923); // Contacto ID 13 → tel 1145678923

        System.out.print("IDs de contactos registrados: ");
        for (int id : agendaContactos.Claves()) {
            System.out.print(id + " ");
        }

        // 2 Diccionario de Sinonimos

        DiccionarioMultipleTDA sinonimos = new DiccionarioMultipleDinamico();
        sinonimos.InicializarDiccionario();

        int palabra = 100; // 100 = Feliz

        sinonimos.Agregar(palabra, 101); // 101 = Alegre
        sinonimos.Agregar(palabra, 102); // 102 = Contento

        System.out.println("Palabra: " + palabra + " tiene de sinónimos a: ");
        int[] listaDeSinonimos = sinonimos.Recuperar(palabra);

        for (int sinonimo: listaDeSinonimos) {
            System.out.println(sinonimo + " ");
        }

        // 3 Puntajes de Torneo de E-Sports

        DiccionarioSimpleTDA jugadores = new DiccionarioSimpleDinamico();
        jugadores.InicializarDiccionario();

        jugadores.Agregar(1, 100);
        jugadores.Agregar(2, 10);
        jugadores.Agregar(3, 40);
        jugadores.Agregar(4, 50);

        // Ahora jugador 1 se juega otra y hace más puntos (o sea: sobreescribe sus puntos, no es que se van a sumar, porque asi funciona o lo establece el diccionario (ver herramienta))
        jugadores.Agregar(1, 600);

        System.out.println("Jugadores registrados en el torneo: ");
        for (int jugador : jugadores.Claves()) {
            System.out.println("ID Jugador: " + jugador);
        } // Aca tampoco pude mostrar los datos todavía


        // 4 Traductor de Idiomas

        DiccionarioMultipleTDA traductor = new DiccionarioMultipleDinamico();
        traductor.InicializarDiccionario();

        int palabraBank = 1;
        traductor.Agregar(palabraBank, 10); // 10 = "Banco"
        traductor.Agregar(palabraBank, 11); // 11 = "Orilla"

        System.out.print("Las traducciones para " + palabraBank + " son los IDs: ");
        int[] traduccionesDeBank = traductor.Recuperar(palabraBank);
        for (int traduccion : traduccionesDeBank) {
            System.out.print(traduccion + " ");
        }

        // 5 Índice de un Libro de Algoritmos

        DiccionarioMultipleTDA indice = new DiccionarioMultipleDinamico();
        indice.InicializarDiccionario();

        int palabraRecursion = 1; // 1 = "Recursion"
        indice.Agregar(palabraRecursion, 12);
        indice.Agregar(palabraRecursion, 45);
        indice.Agregar(palabraRecursion, 88);

        int palabraOrdenamiento = 2; // 2 = "Ordenamiento"
        indice.Agregar(palabraOrdenamiento, 5);
        indice.Agregar(palabraOrdenamiento, 30);

        System.out.println("Indice del libro:");
        for (int clave : indice.Claves()) {
            System.out.print("La palabra " + clave + " aparece en las páginas: ");
            for (int pagina : indice.Recuperar(clave)) {
                System.out.print(pagina + " ");
            }
            System.out.println();
        }

        // 6 Inscripción por Alumno!!!!

        DiccionarioMultipleTDA inscripciones = new DiccionarioMultipleDinamico();
        inscripciones.InicializarDiccionario();

        int legajoA = 11111;
        inscripciones.Agregar(legajoA, 501); // Materia Fundamentos
        inscripciones.Agregar(legajoA, 502); // Materia Programación II
        inscripciones.Agregar(legajoA, 503); // Materia Matemática Discreta

        int legajoB = 22222;
        inscripciones.Agregar(legajoB, 501); // Materia Fundamentos
        inscripciones.Agregar(legajoB, 504); // Materia Física II

        System.out.println("Inscripciones por alumno:");
        for (int leg : inscripciones.Claves()) {
            System.out.print("Legajo " + leg + " inscripto en materias: ");
            for (int materia : inscripciones.Recuperar(leg)) {
                System.out.print(materia + " ");
            }
            System.out.println();
        }

        // 7 DNS (Domain Name System)

        DiccionarioSimpleTDA dns = new DiccionarioSimpleDinamico();
        dns.InicializarDiccionario();

        // ip inventada
        dns.Agregar(1, 142250); // google.com → 142.250.190.46
        dns.Agregar(2, 172217); // youtube.com → 172.217.x.x
        dns.Agregar(3, 13107);  // github.com  → 13.107.x.x

        System.out.println("DNS:");
        System.out.print("Dominios registrados: ");
        for (int dominio : dns.Claves()) {
            System.out.print(dominio + " ");
        }

        // 8 Chipotle Support Bot (Meme Context)

        DiccionarioSimpleTDA pepperBot = new DiccionarioSimpleDinamico();
        pepperBot.InicializarDiccionario();

        pepperBot.Agregar(4001, 10); // Orden 4001 → Script 10: "reset_order.py"
        pepperBot.Agregar(4002, 11); // Orden 4002 → Script 11: "fix_payment.py"
        pepperBot.Agregar(4003, 12); // Orden 4003 → Script 12: "cancel_duplicate.py"

        System.out.print("Ordenes con script asignado (IDs): ");
        for (int orden : pepperBot.Claves()) {
            System.out.print(orden + " ");
        }

        // Ejercicios de Bloque 5: Mezcla de Modelado y Estrategias de Implementaciones

        // 1 Hospital Premium


        // 2 Sistema de Tags de la Facultad


        // 3 Análisis de Implementación (Pilas)

        //...

        // Ejercicio de Bloque 7: Desafío Final → Departamento de Tecnología

    }
}
