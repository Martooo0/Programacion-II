package clase4;

// Import Interfaces

import sources.interfaces.PilaTDA;
import sources.interfaces.ConjuntoTDA;
import sources.interfaces.DiccionarioSimpleTDA;
import sources.interfaces.DiccionarioMultipleTDA;

// Import Implementaciones Estaticas

import sources.implementacionEstatica.pila.PilaEstatica1;
import sources.implementacionEstatica.ColaPrioridadEstatica;
import sources.implementacionEstatica.ConjuntoEstatico;
import sources.implementacionEstatica.DiccionarioMultipleEstatico;
import sources.implementacionEstatica.DiccionarioSimpleEstatico;

public class mainClase4 {
    public static void main(String[] args) {

        // ==============================================================
        //   Ejercicios de Bloque 1: Pilas (LIFO - Last In, First Out)
        // ==============================================================

        // --- 1 Historial de Navegación

        PilaTDA historial = new PilaEstatica1();
        historial.InicializarPila();

        historial.Apilar(1); // Al id 1 lo hago simular como palabra: "google.com"
        historial.Apilar(2); // Al id 2 lo hago simular como palabra: "gemini.google.com"
        historial.Apilar(3); // Al id 3 lo hago simular como palabra: "x.com"

        System.out.println("\nPagina actual (ID): " + historial.Tope() + " (stackoverflow.com)");
        System.out.println("Usuario aprieta 'Atras'...");
        historial.Desapilar();
        System.out.println("Nueva pagina actual (ID): " + historial.Tope() + " (campus.utn.edu.ar)");

        // --- 2 Editor de Codigo

        PilaTDA estados = new PilaEstatica1();
        estados.InicializarPila();

        estados.Apilar(100); // Estado base (vacio)
        estados.Apilar(101); // Codigo escribiendo bien
        estados.Apilar(102); // Codigo donde borraste una línea por error

        System.out.println("Estado actual con error " + estados.Tope());
        estados.Desapilar();
        System.out.println("Estado recuperado " + estados.Tope());

        // --- 3 Balanceo de Parentesis

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
            System.out.println("La expresion ESTA balanceada.");
        } else {
            System.out.println("La expresion NO esta balanceada.");
        }

        // --- 4 Reversion de Strings

        // "ALGORITMOS" en valores numericos - Formato ASCII
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
            System.out.print(pilaAux.Tope() + " "); // Imprime los numeros en orden inverso
            pilaAux.Desapilar();
        }
        System.out.println();

        // --- 5 Pila de Llamadas (Call Stack)

        PilaTDA callStack = new PilaEstatica1();
        callStack.InicializarPila();

        // Establezco: 1 = Main, 2 = CalcularPromedio y 3 = Sumar
        callStack.Apilar(1);
        callStack.Apilar(2);
        callStack.Apilar(3); // Última en apilarse

        System.out.println("El tope es: " + callStack.Tope());

        // --- 6 Navegacion de Directorios

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
        cajero.AcolarPrioridad(85, 30); // Cliente 2: 3era edad
        cajero.AcolarPrioridad(54, 25); // Cliente 4: Discapacidad grave
        cajero.AcolarPrioridad(74, 20); // Cliente 5: Discapacitado leve de 3era edad
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
        impresora.AcolarPrioridad(1,-200); // Impresora 1 con archivo de peso de 200kbs
        impresora.AcolarPrioridad(3,-100); // Impresora 3 con archivo de peso de 100kbs
        impresora.AcolarPrioridad(2,-50); // Impresora 2 con archivo de peso de 50kbs
        impresora.AcolarPrioridad(4,-220); // Impresora 4 con archivo de peso de 200kbs
        impresora.AcolarPrioridad(6,-125); // Impresora 6 con archivo de peso de 125kbs
        impresora.AcolarPrioridad(5,-25); // Impresora 5 con archivo de peso de 25kbs

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
        guardiaHospital.AcolarPrioridad(5,1); // Paciente con raspon
        guardiaHospital.AcolarPrioridad(2,100); // Paciente de 3era edad con mareo
        guardiaHospital.AcolarPrioridad(3,150); // Paciente con fracturas multiples
        guardiaHospital.AcolarPrioridad(4,155); // Paciente en labor de parto
        guardiaHospital.AcolarPrioridad(6,10); // Paciente con dolor de garganta
        guardiaHospital.AcolarPrioridad(1,250); // Paciente con ACB

        System.out.println("--- Guardia del hospital de clínicas:");

        System.out.println("El cliente de mayor prioridad es: "
                + guardiaHospital.Primero() + " (prioridad " + guardiaHospital.Prioridad() + ")");
        System.out.println("Orden de la cola de pacientes: ");

        while (!guardiaHospital.ColaVacia()) {
            System.out.print(guardiaHospital.Primero() + "");
            guardiaHospital.Desacolar();
        }
        System.out.println();
        System.out.println();

        // 4 Examen Final (Promocionados vs Regulares)


        // 5 Buffet de la Facultad


        // 6 Procesador de Tareas (OS Scheduler)


        // 7 Embarque de Aerolineas


        // 8 Distribucion de Tickets IT


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

        // 4 Tags de un Blog de Ingenieria

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

        // 6 Operacion Elegir vs. Sacar

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

        System.out.println("Palabra: " + palabra + " tiene de sinonimos a: ");
        int[] listaDeSinonimos = sinonimos.Recuperar(palabra);

        for ( int sinonimo: listaDeSinonimos) {
            System.out.println(sinonimo + " ");
        }

        // 3 Puntajes de Torneo de E-Sports

        DiccionarioSimpleTDA jugadores = new DiccionarioSimpleEstatico();
        jugadores.InicializarDiccionario();

        // ID de jugador, cantidad de puntos

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

        DiccionarioMultipleTDA indice = new DiccionarioMultipleEstatico();
        indice.InicializarDiccionario();



        // 6 Inscripcion por Alumno


        // 7 DNS (Domain Name System)


        // 9 Chipotle Support Bot (Meme Context)


        // Ejercicios de Bloque 5: Mezcla de Modelado y Estrategias de Implementaciones

        // 1 Hospital Premium


        // 2 Sistema de Tags de la Facultad


        // 3 Analisis de Implementacion (Pilas)


        // Ejercicio de Bloque 7: Desafio Final

        // Departamento de Tecnologia


    }
}