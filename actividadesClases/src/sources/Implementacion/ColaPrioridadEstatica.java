package sources.Implementacion;

import sources.Interfaces.ColaPrioridadTDA;

public class ColaPrioridadEstatica implements ColaPrioridadTDA {
    private static final int MAX = 100;
    private int[] datos;
    private int[] prioridades;
    private int cantidad;

    public void InicializarColaPrioridad() {
        this.datos = new int[100];
        this.prioridades = new int[100];
        this.cantidad = 0;
    }

    public void AcolarPrioridad(int numero, int prioridad) {
        if (this.cantidad < 100) {
            int i;
            for(i = this.cantidad - 1; i >= 0 && this.prioridades[i] < prioridad; --i) {
                this.datos[i + 1] = this.datos[i];
                this.prioridades[i + 1] = this.prioridades[i];
            }

            this.datos[i + 1] = numero;
            this.prioridades[i + 1] = prioridad;
            ++this.cantidad;
        }

    }

    public void Desacolar() {
        if (!this.ColaVacia()) {
            for(int i = 0; i < this.cantidad - 1; ++i) {
                this.datos[i] = this.datos[i + 1];
                this.prioridades[i] = this.prioridades[i + 1];
            }

            --this.cantidad;
        }

    }

    public boolean ColaVacia() {
        return this.cantidad == 0;
    }

    public int Primero() {
        return this.datos[0];
    }

    public int Prioridad() {
        return this.prioridades[0];
    }
}
