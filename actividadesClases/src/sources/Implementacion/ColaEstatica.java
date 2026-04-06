package sources.Implementacion;

import sources.Interfaces.ColaTDA;

public class ColaEstatica implements ColaTDA {
    private static final int MAX = 100;
    private int[] datos;
    private int cantidad;

    public void InicializarCola() {
        this.datos = new int[100];
        this.cantidad = 0;
    }

    public void Acolar(int x) {
        if (this.cantidad < 100) {
            this.datos[this.cantidad] = x;
            ++this.cantidad;
        }

    }

    public void Desacolar() {
        if (!this.ColaVacia()) {
            for(int i = 0; i < this.cantidad - 1; ++i) {
                this.datos[i] = this.datos[i + 1];
            }

            --this.cantidad;
        }

    }

    public int Primero() {
        return this.datos[0];
    }

    public boolean ColaVacia() {
        return this.cantidad == 0;
    }
}
