package clase6.ejerciciosGuia;


import sources.implementacionDinamica.diccionarioMultipleDinamico.DiccionarioMultipleDinamico;
import sources.implementacionDinamica.diccionarioSimpleDinamico.DiccionarioSimpleDinamico;
import sources.interfaces.DiccionarioMultipleTDA;
import sources.interfaces.DiccionarioSimpleTDA;

public class Bloque4 {

    public void ejercicios() {
        // 1. Agenda de Contactos
        DiccionarioSimpleTDA d1 = new DiccionarioSimpleDinamico();
        d1.InicializarDiccionario();
        d1.Agregar(1, 44445555); 

        // 2. Diccionario de Sinónimos
        DiccionarioMultipleTDA d2 = new DiccionarioMultipleDinamico();
        d2.InicializarDiccionario();
        d2.Agregar(10, 11); 
        d2.Agregar(10, 12);

        // 3. Puntajes E-Sports
        DiccionarioSimpleTDA d3 = new DiccionarioSimpleDinamico();
        d3.InicializarDiccionario();
        d3.Agregar(505, 9900);

        // 4. Traductor
        // Uso Múltiple porque una palabra puede tener varios significados.
        DiccionarioMultipleTDA d4 = new DiccionarioMultipleDinamico();
        d4.InicializarDiccionario();
        d4.Agregar(20, 201);
        d4.Agregar(20, 202); 

        // 5. Índice de Libro
        DiccionarioMultipleTDA d5 = new DiccionarioMultipleDinamico();
        d5.InicializarDiccionario();
        d5.Agregar(30, 12);
        d5.Agregar(30, 45);

        // 6. Inscripción por Alumno
        DiccionarioMultipleTDA d6 = new DiccionarioMultipleDinamico();
        d6.InicializarDiccionario();
        d6.Agregar(1080, 5);
        d6.Agregar(1080, 8); 

        // 7. DNS
        DiccionarioSimpleTDA d7 = new DiccionarioSimpleDinamico();
        d7.InicializarDiccionario();
        d7.Agregar(777, 142250);

        // 8. Chipotle Bot 
        DiccionarioSimpleTDA d8 = new DiccionarioSimpleDinamico();
        d8.InicializarDiccionario();
        d8.Agregar(90, 101);
    }
}