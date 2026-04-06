package sources.Implementacion;

import sources.Interfaces.ConjuntoTDA;

public class ConjuntoEstatico implements ConjuntoTDA {
    private static final int MAX = 100;
    private int[] datos;
    private int cantidad;

    public void InicializarConjunto() {
        this.datos = new int[100];
        this.cantidad = 0;
    }

    public void Agregar(int x) {
        if (this.cantidad < 100 && !this.Pertenece(x)) {
            this.datos[this.cantidad] = x;
            ++this.cantidad;
        }

    }

    public void Sacar(int x) {
        int i;
        for(i = 0; i < this.cantidad && this.datos[i] != x; ++i) {
        }

        if (i < this.cantidad) {
            this.datos[i] = this.datos[this.cantidad - 1];
            --this.cantidad;
        }

    }

    public boolean ConjuntoVacio() {
        return this.cantidad == 0;
    }

    public boolean Pertenece(int x) {
        for(int i = 0; i < this.cantidad; ++i) {
            if (this.datos[i] == x) {
                return true;
            }
        }

        return false;
    }

    public int Elegir() {
        return this.datos[0];
    }
}
