package sources.implementacionEstatica;

import sources.interfaces.ColaPrioridadTDA;

public class ColaPrioridadEstatica implements ColaPrioridadTDA {
    private static final int MAX = 100;
    private int[] datos;
    private int[] prioridades;
    private int cantidad;

    public void InicializarColaPrioridad() {
        datos = new int[MAX];
        prioridades = new int[MAX];
        cantidad = 0;
    }

    public void AcolarPrioridad(int numero, int prioridad) {
        if (cantidad < MAX) {
            int i;
            for(i = cantidad - 1; i >= 0 && prioridades[i] < prioridad; --i) {
                datos[i + 1] = datos[i];
                prioridades[i + 1] = prioridades[i];
            }

            datos[i + 1] = numero;
            prioridades[i + 1] = prioridad;
            ++cantidad;
        }
    }

    public void Desacolar() {
        if (!ColaVacia()) {
            for(int i = 0; i < cantidad - 1; ++i) {
                datos[i] = datos[i + 1];
                prioridades[i] = prioridades[i + 1];
            }

            --cantidad;
        }

    }

    public boolean ColaVacia() {
        return cantidad == 0;
    }

    public int Primero() {
        return datos[0];
    }

    public int Prioridad() {
        return prioridades[0];
    }
}
