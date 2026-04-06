package clase4;

import sources.Implementacion.ColaPrioridadEstatica;

public class mainClase4 {
    public static void main(String[] args) {

        // ---------- BLOQUE 2 ----------
        // --- Fila de cajero ---
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
        System.out.println();
        System.out.println();

        // --- Impresora de laboratorio ---
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


        // --- Impresora de laboratorio ---
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
                + impresora.Primero() + " (prioridad " + impresora.Prioridad() + ")");
        System.out.println("Orden de la cola de pacientes: ");

        while (!impresora.ColaVacia()) {
            System.out.print(impresora.Primero() + "");
            impresora.Desacolar();
        }
        System.out.println();
        System.out.println();
    }
}