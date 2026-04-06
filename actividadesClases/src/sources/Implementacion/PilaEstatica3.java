package sources.Implementacion;

import sources.Interfaces.PilaTDA;

public class PilaEstatica3 implements PilaTDA {
    private static final int MAX = 100;
    private int[] datos;
    private int cantidad;

    public void InicializarPila() {
        this.datos = new int[100];
        this.cantidad = 0;
    }

    public void Apilar(int x) {
        if (this.cantidad < 100) {
            this.datos[this.cantidad] = x;
            ++this.cantidad;
        }

    }

    public void Desapilar() {
        if (!this.PilaVacia()) {
            --this.cantidad;
        }

    }

    public int Tope() {
        return this.datos[this.cantidad - 1];
    }

    public boolean PilaVacia() {
        return this.cantidad == 0;
    }
}
