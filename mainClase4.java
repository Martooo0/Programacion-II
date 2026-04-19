package clase4;

// Import Interfaces

import sources.implementacion.*;
import sources.interfaces.PilaTDA;
import sources.interfaces.ConjuntoTDA;
import sources.interfaces.DiccionarioSimpleTDA;
import sources.interfaces.DiccionarioMultipleTDA;

// Import Implementaciones Estáticas

import sources.implementacion.pila.PilaEstatica1;

public class mainClase4 {
    public static void main(String[] args) {

        // ==============================================================
        // Ejercicios de Bloque 1: Pilas (LIFO - Last In, First Out)
        // El último que entró es el primero que sale
        // ==============================================================

        // --- 1 Historial de Navegación

        PilaTDA historial = new PilaEstatica1();
        historial.InicializarPila();

        historial.Apilar(1); // Al id 1 lo hago simular como palabra: "google.com"
        historial.Apilar(2); // Al id 2 lo hago simular como palabra: "gemini.google.com"
        historial.Apilar(3); // Al id 3 lo hago simular como palabra: "x.com"

        System.out.println("Pagina actual: \n" + historial.Tope());
        historial.Desapilar();
        System.out.println("Pagina actual: \n" + historial.Tope());

        // --- 2 Editor de Código

        PilaTDA estados = new PilaEstatica1();
        estados.InicializarPila();

        estados.Apilar(100); // Estado base (vacío)
        estados.Apilar(101); // Código escribiendo bien
        estados.Apilar(102); // Código donde borraste una línea por error

        System.out.println("\nEstado actual con error " + estados.Tope());
        estados.Desapilar();
        System.out.println("Estado recuperado " + estados.Tope());

        // --- 3 Balanceo de Paréntesis

        int[] expresionNumerica = {1, 1, 0, 0, 0, 2, 0, 0, 2}; // ( ( a + b ) * c )

        PilaTDA parentesis = new PilaEstatica1();
        parentesis.InicializarPila();
        boolean errorBalanceo = false;

        for (int valorActual : expresionNumerica) {
            if (valorActual == 1) { // Si es un '('
                parentesis.Apilar(1);
            } else if (valorActual == 2) { // Si es un ')'
                if (parentesis.PilaVacia()) {
                    errorBalanceo = true;
                } else {
                    parentesis.Desapilar();
                }
            }
        }

        if (!errorBalanceo && parentesis.PilaVacia()) {
            System.out.println("La expresión ESTA balanceada.");
        } else {
            System.out.println("La expresión NO esta balanceada.");
        }

        // --- 4 Reversion de Strings

        // "ALGORITMOS" en valores numéricos - Formato ASCII
        int[] palabraNumerica = {65, 76, 71, 79, 82, 73, 84, 77, 79, 83};

        PilaTDA pila1 = new PilaEstatica1();
        pila1.InicializarPila();

        PilaTDA pilaAux = new PilaEstatica1();
        pilaAux.InicializarPila();

        for (int valorLetra : palabraNumerica) { // Apila con un for-each
            pila1.Apilar(valorLetra);
        }

        while (!pila1.PilaVacia()) { // Desapila pila1 y en la aux apila ese valor
            int valorActual = pila1.Tope();
            pilaAux.Apilar(valorActual);
            pila1.Desapilar();
        }

        System.out.print("Palabra invertida (en formato ASCII): ");
        while (!pilaAux.PilaVacia()) {
            System.out.print(pilaAux.Tope() + " "); // Imprime los números en orden inverso
            pilaAux.Desapilar();
        }
        System.out.println();

        // --- 5 Pila de Llamadas (Call Stack)

        PilaTDA callStack = new PilaEstatica1();
        callStack.InicializarPila();

        // Establezco: 1 = Main, 2 = CalcularPromedio y 3 = sumar
        callStack.Apilar(1);
        callStack.Apilar(2);
        callStack.Apilar(3); // Última en apilarse

        System.out.println("El tope es: " + callStack.Tope());

        // --- 6 Navegación de Directorios

        PilaTDA rutas = new PilaEstatica1();
        rutas.InicializarPila();

        // Establezco: 1 = C:/, 2 = Usuarios y 3 = Documentos
        rutas.Apilar(1);
        rutas.Apilar(2);
        rutas.Apilar(3); // Cada vez que entra a un nuevo nivel, apila la ruta

        System.out.println("Carpeta actual: " + rutas.Tope() + " (Documentos)");
        rutas.Desapilar();
        System.out.println(rutas.Tope());
        // =================================================================
        //   Ejercicios de Bloque 2: Colas y Colas con Prioridad (FIFO -
        //   In, First Out + Ranking - Mayor Prioridad = Mayor Valor Entero)
        // =================================================================

        // --- 1 Fila del Cajero

        ColaPrioridadEstatica cajero = new ColaPrioridadEstatica();
        cajero.InicializarColaPrioridad();

        // Cuanto más alto el número, más urgente
        cajero.AcolarPrioridad(85, 30); // Cliente 2: 3.ª edad
        cajero.AcolarPrioridad(54, 25); // Cliente 4: Discapacidad grave
        cajero.AcolarPrioridad(74, 20); // Cliente 5: Discapacitado leve de 3.ª edad
        cajero.AcolarPrioridad(25, 15); // Cliente 3: Discapacidad leve
        cajero.AcolarPrioridad(21, 10); // Cliente 1: Normal

        System.out.println("--- Fila del cajero:");

        System.out.println("El cliente con mayor prioridad es: "
                + cajero.Primero() + " (prioridad " + cajero.Prioridad() + ")");
        System.out.println("Orden de la cola de clientes: ");

        while (!cajero.ColaVacia()) {
            System.out.print(cajero.Primero() + "");
            cajero.Desacolar();
        }

        // --- 2 Impresora de Laboratorio

        ColaPrioridadEstatica impresora = new ColaPrioridadEstatica();
        impresora.InicializarColaPrioridad();
        impresora.AcolarPrioridad(1,-200); // Impresora 1 con archivo de peso de 200 kbs
        impresora.AcolarPrioridad(3,-100); // Impresora 3 con archivo de peso de 100 kbs
        impresora.AcolarPrioridad(2,-50); // Impresora 2 con archivo de peso de 50 kbs
        impresora.AcolarPrioridad(4,-220); // Impresora 4 con archivo de peso de 200 kbs
        impresora.AcolarPrioridad(6,-125); // Impresora 6 con archivo de peso de 125 kbs
        impresora.AcolarPrioridad(5,-25); // Impresora 5 con archivo de peso de 25 kbs

        System.out.println("--- Impresora de laboratorio:");

        System.out.println("La impresora con mayor prioridad es: "
                + impresora.Primero() + " (prioridad " + impresora.Prioridad() + ")");
        System.out.println("Orden de la cola de impresoras: ");

        while (!impresora.ColaVacia()) {
            System.out.print(impresora.Primero() + "");
            impresora.Desacolar();
        }
        System.out.println();
        System.out.println();

        // 3 Guardia del Hospital (Triage)

        ColaPrioridadEstatica guardiaHospital = new ColaPrioridadEstatica();
        guardiaHospital.InicializarColaPrioridad();
        guardiaHospital.AcolarPrioridad(5,1); // Paciente con raspón
        guardiaHospital.AcolarPrioridad(2,100); // Paciente de 3.ª edad con mareo
        guardiaHospital.AcolarPrioridad(3,150); // Paciente con fracturas multiples
        guardiaHospital.AcolarPrioridad(4,155); // Paciente en labor de parto
        guardiaHospital.AcolarPrioridad(6,10); // Paciente con dolor de garganta
        guardiaHospital.AcolarPrioridad(1,250); // Paciente con ACB

        System.out.println("--- Guardia del hospital de clínicas:");

        System.out.println("El paciente de mayor prioridad es: "
                + guardiaHospital.Primero() + " (prioridad " + guardiaHospital.Prioridad() + ")"); // Arreglo de variable
        System.out.println("Orden de atención de pacientes: ");

        while (!guardiaHospital.ColaVacia()) {
            System.out.print(guardiaHospital.Primero() + "");
            guardiaHospital.Desacolar();
        }
        System.out.println();
        System.out.println();

        // 4 Examen Final (Promocionados vs. Regulares)

        ColaPrioridadEstatica examenFinal = new ColaPrioridadEstatica();
        examenFinal.InicializarColaPrioridad();

        examenFinal.AcolarPrioridad(101, 5);  // Alumno 101: Regular — llegó a las 8:00 AM
        examenFinal.AcolarPrioridad(202, 10); // Alumno 202: Promocionado — llegó a las 8:30 AM

        System.out.println("Primero en hacer el examen: " + examenFinal.Primero());
        System.out.println(" — prioridad: " + examenFinal.Prioridad() + " (10 = Promocionado, 5 = Regular)");

        while (!examenFinal.ColaVacia()) {
            System.out.print("Alumno " + examenFinal.Primero() + " | ");
            examenFinal.Desacolar();
        }
        System.out.println();

        // 5 Buffet de la Facultad

        ColaEstatica buffet = new ColaEstatica();
        buffet.InicializarCola();

        buffet.Acolar(1); // Alumno 1 llega primero
        buffet.Acolar(2); // Alumno 2 llega segundo
        buffet.Acolar(3); // Alumno 3 llega tercero

        while (!buffet.ColaVacia()) {
            System.out.print("Alumno " + buffet.Primero() + " | ");
            buffet.Desacolar();
        }
        System.out.println();

        // 6 Procesador de Tareas (OS Scheduler)

        ColaPrioridadEstatica scheduler = new ColaPrioridadEstatica();
        scheduler.InicializarColaPrioridad();

        scheduler.AcolarPrioridad(1, 50); // Proceso del sistema: Antivirus
        scheduler.AcolarPrioridad(2, 50); // Proceso del sistema: Actualización S.O.
        scheduler.AcolarPrioridad(3, 10); // Proceso del usuario: Spotify
        scheduler.AcolarPrioridad(4, 10); // Proceso del usuario: Chrome
        scheduler.AcolarPrioridad(5, 50); // Proceso del sistema: Gestor de red


        System.out.println("50: sistema 10: usuario");

        while (!scheduler.ColaVacia()) {
            System.out.print("PID " + scheduler.Primero() + " (prio " + scheduler.Prioridad() + ") | ");
            scheduler.Desacolar();
        }
        System.out.println();

        // 7 Embarque de Aerolíneas

        ColaPrioridadEstatica embarque = new ColaPrioridadEstatica();
        embarque.InicializarColaPrioridad();

        // Movilidad reducida: 3 | Business: 2 | Economy: 1
        embarque.AcolarPrioridad(10, 3); // Pasajero con silla de ruedas
        embarque.AcolarPrioridad(20, 3); // Otro pasajero con movilidad reducida (misma prioridad que 10)
        embarque.AcolarPrioridad(30, 2); // Pasajero Business A
        embarque.AcolarPrioridad(40, 2); // Pasajero Business B (misma prioridad que 30)
        embarque.AcolarPrioridad(50, 1); // Pasajero Economy

        while (!embarque.ColaVacia()) {
            System.out.print("Pasajero " + embarque.Primero() + " (prio " + embarque.Prioridad() + ") | ");
            embarque.Desacolar();
        }
        System.out.println();

        // 8 Distribución de Tickets IT

        ColaPrioridadEstatica ticketsIT = new ColaPrioridadEstatica();
        ticketsIT.InicializarColaPrioridad();

        // id del ticket, prioridad
        ticketsIT.AcolarPrioridad(1, 0);   // Ticket 1: "No me gusta el fondo de pantalla"
        ticketsIT.AcolarPrioridad(2, 50);  // Ticket 2: Problema con impresora
        ticketsIT.AcolarPrioridad(3, 999); // Ticket 3: Se rompio el servidor principal
        ticketsIT.AcolarPrioridad(4, 10);  // Ticket 4: Mail no llega

        while (!ticketsIT.ColaVacia()) {
            System.out.print("Ticket " + ticketsIT.Primero() + " (prio " + ticketsIT.Prioridad() + ") | ");
            ticketsIT.Desacolar();
        }
        System.out.println();

        // Ejercicios de Bloque 3: Conjuntos (Sin duplicados) No hay orden y no hay repetidos

        // 1 Padron Electoral

        ConjuntoTDA padron = new ConjuntoEstatico();
        padron.InicializarConjunto();

        int legajoMartin = 1010;

        System.out.println("Legajo " + legajoMartin + " quiere votar");
        if (padron.Pertenece(legajoMartin)) {
            System.out.println("Ya votó, rechazado");
        } else {
            padron.Agregar(legajoMartin);
            System.out.println("Voto registrado");
        }

        // 2 Invitados a la Fiesta

        ConjuntoTDA fiesta = new ConjuntoEstatico();
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

        ConjuntoTDA blacklist = new ConjuntoEstatico();
        blacklist.InicializarConjunto();
        blacklist.Agregar(999); // "Al numero 999 lo hago simular como palabra: "Crypto"
        blacklist.Agregar(888); // "Al numero 888 lo hago simular como palabra: "Ganá"

        int palabraDelMail = 999;
        boolean esSpam = false;

        ConjuntoTDA auxiliar = new ConjuntoEstatico();
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

        ConjuntoTDA tags = new ConjuntoEstatico();
        tags.InicializarConjunto();

        int tagJava = 100; // "Java"

        System.out.println("Agregando tag: Java");
        tags.Agregar(tagJava);

        System.out.println("Agregando nuevamente el tag: Java");
        tags.Agregar(tagJava); // Sin repetido.

        // 5 Gestion de Legajos

        ConjuntoTDA legajos = new ConjuntoEstatico();
        legajos.InicializarConjunto();

        int legajoAlumno = 12345;

        if (!legajos.Pertenece(legajoAlumno)) { // Se anota a su primera carrera
            legajos.Agregar(legajoAlumno);
            System.out.println("El alumno " + legajoAlumno + "  se registró");
        }

        if (!legajos.Pertenece(legajoAlumno)) { // Se anota a una segunda carrera
            legajos.Agregar(legajoAlumno);
        } else {
            System.out.println("El legajo está registrado en el sistema");
        }

        // 6 Operación Elegir vs. Sacar

        ConjuntoTDA pruebaElegir = new ConjuntoEstatico();
        pruebaElegir.InicializarConjunto();
        pruebaElegir.Agregar(50);
        pruebaElegir.Agregar(60);

        // Llamamos a Elegir dos veces seguidas sin usar Sacar()
        int primerLlamado = pruebaElegir.Elegir();
        int segundoLlamado = pruebaElegir.Elegir();

        System.out.println("Primer llamado a Elegir(): " + primerLlamado);
        System.out.println("Segundo llamado a Elegir(): " + segundoLlamado);
        System.out.println("Conclusión: Devuelve exactamente el mismo elemento porque no se borro");


        // Ejercicios de Bloque 4: Diccionarios Simples y Multiples (Concepto: Clave - Valor) Tiene una unica clave con uno o más valores

        // 1 Agenda de Contactos

        DiccionarioSimpleTDA agendaContactos = new DiccionarioSimpleEstatico();
        agendaContactos.InicializarDiccionario();
        agendaContactos.Agregar(12,1132457854);
        agendaContactos.Agregar(13,1145678923);

        // 2 Diccionario de Sinonimos

        DiccionarioMultipleTDA sinonimos = new DiccionarioMultipleEstatico();
        sinonimos.InicializarDiccionario();

        int palabra = 100; // 100 = Feliz

        sinonimos.Agregar(palabra, 101); // 101 = Alegre
        sinonimos.Agregar(palabra, 102); // 102 = Contento

        System.out.println("Palabra: " + palabra + " tiene de sinónimos a: ");
        int[] listaDeSinonimos = sinonimos.Recuperar(palabra); //

        for ( int sinonimo: listaDeSinonimos) {
            System.out.println(sinonimo + " ");
        }

        // 3 Puntajes de Torneo de E-Sports

        DiccionarioSimpleTDA jugadores = new DiccionarioSimpleEstatico();
        jugadores.InicializarDiccionario();

        // id de jugador, cantidad de puntos

        jugadores.Agregar(1,100);
        jugadores.Agregar(2,10);
        jugadores.Agregar(3,40);
        jugadores.Agregar(4,50);

        // Un jugador juega otra partida y hace más puntos (sobreescribe sus puntos, no los suma)

        jugadores.Agregar(1,600);

        System.out.println("Jugadores que están registrados en el torneo: ");
        for (int jugador : jugadores.Claves()) {
            System.out.println("ID Jugador: " + jugador);
        } // Falta la manera de mostrar los puntos

        // 4 Traductor de Idiomas

        DiccionarioMultipleTDA traductor = new DiccionarioMultipleEstatico();
        traductor.InicializarDiccionario();

        // Establezco: 1 (ID para "Bank"). Valores: 10 ("Banco"), 11 ("Orilla")
        int palabraBank = 1;
        traductor.Agregar(palabraBank, 10);
        traductor.Agregar(palabraBank, 11);

        System.out.print("Las traducciones para " + palabraBank + " son los IDs: ");
        int[] traduccionesDeBank = traductor.Recuperar(palabraBank);
        for (int traduccion : traduccionesDeBank) {
            System.out.print(traduccion + " ");
        }

        // 5 Índice de un Libro de Algoritmos

        // Clave: id de la palabra | Valor: numeros de página donde aparece

        DiccionarioMultipleTDA indice = new DiccionarioMultipleEstatico();
        indice.InicializarDiccionario();

        int palabraRecursion = 1; // 1 = "Recursion"
        indice.Agregar(palabraRecursion, 12);
        indice.Agregar(palabraRecursion, 45);
        indice.Agregar(palabraRecursion, 88);

        int palabraOrdenamiento = 2; // 2 = "Ordenamiento"
        indice.Agregar(palabraOrdenamiento, 5);
        indice.Agregar(palabraOrdenamiento, 30);

        for (int clave : indice.Claves()) {
            System.out.print("La palabra " + clave + " aparece en las paginas: ");
            for (int pagina : indice.Recuperar(clave)) {
                System.out.print(pagina + " ");
            }
            System.out.println();
        }

        // 6 Inscripción por Alumno

        DiccionarioMultipleTDA inscripciones = new DiccionarioMultipleEstatico();
        inscripciones.InicializarDiccionario();

        int legajoA = 11111;
        inscripciones.Agregar(legajoA, 501); // Materia Fundamentos de Informática
        inscripciones.Agregar(legajoA, 502); // Materia Programación II
        inscripciones.Agregar(legajoA, 503); // Materia Matemática Discreta

        int legajoB = 22222;
        inscripciones.Agregar(legajoB, 501); // Materia Fundamentos de Informática
        inscripciones.Agregar(legajoB, 504); // Materia Física II

        for (int leg : inscripciones.Claves()) {
            System.out.print("Legajo " + leg + " inscripto en materias: ");
            for (int materia : inscripciones.Recuperar(leg)) {
                System.out.print(materia + " ");
            }
            System.out.println();
        }

        // 7 DNS (Domain Name System)

        DiccionarioSimpleTDA dns = new DiccionarioSimpleEstatico();
        dns.InicializarDiccionario();

        // 1 = "google.com" → IP simplificada como entero 142250 (142.250.x.x)
        dns.Agregar(1, 142250); // google.com → 142.250.190.46
        dns.Agregar(2, 172217); // youtube.com → 172.217.x.x
        dns.Agregar(3, 13107);  // github.com  → 13.107.x.x

        System.out.println("--- DNS:");
        System.out.print("Dominios registrados (IDs): ");
        for (int dominio : dns.Claves()) {
            System.out.print(dominio + " ");
        }
        System.out.println();

        // 9 Chipotle Support Bot (Meme Context)

        DiccionarioSimpleTDA pepperBot = new DiccionarioSimpleEstatico();
        pepperBot.InicializarDiccionario();

        pepperBot.Agregar(4001, 0); // Orden 4001 → Script 0
        pepperBot.Agregar(4002, 1); // Orden 4002 → Script 1
        pepperBot.Agregar(4003, 2); // Orden 4003 → Script 2

        for (int orden : pepperBot.Claves()) {
            System.out.print(orden + " ");
        }
        System.out.println();

        // Ejercicios de Bloque 5: Mezcla de Modelado y Estrategias de Implementaciones

        // 1 Hospital Premium

        ColaPrioridadEstatica guardiaHospitalPremium = new ColaPrioridadEstatica();
        guardiaHospitalPremium.InicializarColaPrioridad();
        guardiaHospitalPremium.AcolarPrioridad(1, 200); // Paciente 1 — critico
        guardiaHospitalPremium.AcolarPrioridad(2,  50); // Paciente 2 — moderado
        guardiaHospitalPremium.AcolarPrioridad(3,   5); // Paciente 3 — leve

        // Historial de síntomas del Paciente 1 con una Pila (el último detectado va a ser el tope)
        PilaTDA historialP1 = new PilaEstatica1();
        historialP1.InicializarPila();
        historialP1.Apilar(10); // Síntoma 10: "dolor de pecho" — primer Síntoma
        historialP1.Apilar(20); // Síntoma 20: "dificultad al respirar" — segundo Síntoma
        historialP1.Apilar(30); // Síntoma 30: "perdida de consciencia" — ultimo (tope)

        // DiccionarioMultiple: clave = id paciente | valores = id's de síntomas
        DiccionarioMultipleTDA historialClinico = new DiccionarioMultipleEstatico();
        historialClinico.InicializarDiccionario();
        historialClinico.Agregar(1, 10); // Paciente 1 tiene síntoma 10
        historialClinico.Agregar(1, 20); // Paciente 1 tiene síntoma 20
        historialClinico.Agregar(1, 30); // Paciente 1 tiene síntoma 30
        historialClinico.Agregar(2, 40); // Paciente 2 tiene síntoma 40

        System.out.println("Ultimo síntoma del Paciente 1: " + historialP1.Tope());
        System.out.print("Síntomas registrados del Paciente 1: ");
        for (int s : historialClinico.Recuperar(1)) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.print("Orden de atención: ");
        while (!guardiaHospitalPremium.ColaVacia()) {
            System.out.print("Paciente " + guardiaHospitalPremium.Primero() + " | ");
            guardiaHospitalPremium.Desacolar();
        }
        System.out.println();

        // 2 Sistema de Tags de la Facultad

        DiccionarioMultipleTDA tagsFacultad = new DiccionarioMultipleEstatico();
        tagsFacultad.InicializarDiccionario();

        int carreraIngInfo = 1; // "Ingeniería en Informatica"
        int carreraBioinfo = 2; // "Licenciatura en Bioinformática"
        int carreraCienciaDatos = 3; // "Ciencia de Datos"

        // Materias obligatorias
        tagsFacultad.Agregar(carreraIngInfo, 501); // Algoritmos
        tagsFacultad.Agregar(carreraIngInfo, 502); // Programación II
        tagsFacultad.Agregar(carreraIngInfo, 503); // Matemática Discreta
        tagsFacultad.Agregar(carreraBioinfo, 501); // Algoritmos, que también estaba en la otra carrera
        tagsFacultad.Agregar(carreraBioinfo, 601); // Biología Molecular
        tagsFacultad.Agregar(carreraCienciaDatos, 502); // Programación II, otra más
        tagsFacultad.Agregar(carreraCienciaDatos, 701); // Estadística Avanzada

        for (int carrera : tagsFacultad.Claves()) {
            System.out.print("Carrera " + carrera + " → materias: ");
            for (int materia : tagsFacultad.Recuperar(carrera)) {
                System.out.print(materia + " ");
            }
            System.out.println();
        } // A chequear si está bien eso de los repetidos en las claves, ya que en el diccionario multiple, técnicamente, no se admiten repetidos en la misma clave, pero sí en distintas... Conjuntos¿?
        System.out.println();
        // 3 Análisis de Implementación (Pilas)

        //...

        // Ejercicio de Bloque 7: Desafío Final → Departamento de Tecnología

        ConjuntoTDA alumnosInscriptos = new ConjuntoEstatico();
        alumnosInscriptos.InicializarConjunto();

        // Los Alumnos del dep. de tecnología van a tener prioridad 10 y el resto 5
        ColaPrioridadEstatica listaDeEspera = new ColaPrioridadEstatica();
        listaDeEspera.InicializarColaPrioridad();

        // Código de materia → correlativas previas
        DiccionarioMultipleTDA correlativas = new DiccionarioMultipleEstatico();
        correlativas.InicializarDiccionario();

        correlativas.Agregar(501, 500); // Para Programación I se necesita Fundamentos de Informática (501)
        correlativas.Agregar(502, 503); // Para Matemática Discreta se necesita Pensamiento Crítico (501)
        correlativas.Agregar(600, 504); // Programación III se necesita Programación II (502)
        correlativas.Agregar(600, 500); // Para Programación III también se necesita Fundamentos de Informática (501)

        int[] legajosPedidos = {10001, 10002, 10001, 10003}; // 10001 intenta inscribirse dos veces
        int[] prioridades    = {5, 10, 5, 5};                // 10002 es del Dep. Tecnología

        // Esto no sé qué tan buena idea es hardcodearlo asi. Como no sabemos qué cantidad de alumnos va a haber... Me pareció lo mejor hacer dos arrays ordenados. También se podría haber hecho con AcolarPrioridad de antemano

        for (int i = 0; i < legajosPedidos.length; i++) {
            int leg = legajosPedidos[i];
            int prio = prioridades[i];

            if (!alumnosInscriptos.Pertenece(leg)) {
                alumnosInscriptos.Agregar(leg);
                listaDeEspera.AcolarPrioridad(leg, prio);
                System.out.println("Legajo " + leg + " inscripto con prioridad " + prio);
            } else {
                System.out.println("Legajo " + leg + " ya estaba inscripto.");
            }
        }

        System.out.println("Orden de procesamiento de inscripciones:");
        while (!listaDeEspera.ColaVacia()) {
            System.out.print("| Legajo " + listaDeEspera.Primero() + " Prioridad " + listaDeEspera.Prioridad() + " | ");
            listaDeEspera.Desacolar();
        }
        System.out.println();

        // Consulta de correlativas de una materia
        int materiaPedida = 600; // Programación III
        System.out.print("Correlativas para materia " + materiaPedida + ": ");
        for (int pedidoDeMateria : correlativas.Recuperar(materiaPedida)) {
            System.out.print(pedidoDeMateria + " ");
        }
        System.out.println();
    }
}