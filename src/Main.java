// Import Interface

import Interface.ConjuntoTDA;
import Interface.PilaTDA;
import Interface.ColaTDA;
import Interface.DiccionarioSimpleTDA;
import Interface.DiccionarioMultipleTDA;
import Interface.ColaPrioridadTDA;

// Import Implementacion

import Implementacion.ConjuntoEstatico;
import Implementacion.ColaEstatica;
import Implementacion.ColaPrioridadEstatica;
import Implementacion.DiccionarioMultipleEstatico;
import Implementacion.DiccionarioSimpleEstatico;
import Implementacion.Pila.Estrategia_1;
import Implementacion.Pila.Estrategia_2;
import Implementacion.Pila.Estrategia_3;

public class Main {
    public static void main(String[] args) {

        // Ejercicios de Bloque 1: Pilas (LIFO - Last In, First Out) Bascicamente el último que entro es el primero que sale

        // 1 Historial de Navegación

        PilaTDA historial = new Estrategia_1();
        historial.InicializarPila();

        historial.Apilar(1); // "Al id 1 lo hago simular como palabra: "google.com"
        historial.Apilar(2); // "Al id 2 lo hago simular como palabra: "gemini.google.com"
        historial.Apilar(3); // "Al id 3 lo hago simular como palabra: "x.com"

        System.out.println("Pagina actual (ID): " + historial.Tope() + " (stackoverflow.com)");
        System.out.println("Usuario aprieta 'Atras'...");
        historial.Desapilar();
        System.out.println("Nueva pagina actual (ID): " + historial.Tope() + " (campus.utn.edu.ar)");

        // 2 Editor de Codigo


        // 3 Balanceo de Parentesis


        // 4 Reversion de Strings


        // 5 Pila de Llamadas (Call Stack)


        // 6 Navegacion de Directorios


        // Ejercicios de Bloque 2: Colas y Colas con Prioridad (FIFO - First In, First Out + Ranking - Mayor Prioridad = Mayor Valor Entero) El primero que entra es el primero que sale a menos que haya alguien más importante que entre después

        // 1 Fila del Cajero


        // 2 Impresora de Laboratorio


        // 3 Guardia del Hospital (Triage)


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


        // 2 Diccionario de Sinonimos


        // 3 Puntajes de Torneo de E-Sports


        // 4 Traductor de Idiomas


        // 5 Índice de un Libro de Algoritmos


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