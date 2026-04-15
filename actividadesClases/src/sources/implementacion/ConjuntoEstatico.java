package sources.implementacion;

import sources.interfaces.ConjuntoTDA;

public class ConjuntoEstatico implements ConjuntoTDA {
    private static final int MAX = 100;
    private int[] datos;
    private int cantidad;

    public void InicializarConjunto() {
        datos = new int[MAX];
        cantidad = 0;
    }

    public void Agregar(int x) {
        if (cantidad < MAX && !Pertenece(x)) {
            datos[cantidad] = x;
            ++cantidad;
        }
    }

    public void Sacar(int x) {
        int i;
        for(i = 0; i < cantidad && datos[i] != x; ++i) {
        }

        if (i < cantidad) {
            datos[i] = datos[cantidad - 1];
            --cantidad;
        }
    }

    public boolean ConjuntoVacio() {
        return cantidad == 0;
    }

    public boolean Pertenece(int x) {
        for(int i = 0; i < cantidad; ++i) {
            if (datos[i] == x) {
                return true;
            }
        }
        return false;
    }

    public int Elegir() {
        return datos[0];
    }
}
