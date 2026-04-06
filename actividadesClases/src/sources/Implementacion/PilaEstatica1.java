package sources.Implementacion;

import sources.Interfaces.PilaTDA;

public class PilaEstatica1 implements PilaTDA {
    private static final int MAX = 100;
    private int[] datos;
    private int cantidad;

    public void InicializarPila() {
        this.datos = new int[100];
        this.cantidad = 0;
    }

    public void Apilar(int x) {
        if (this.cantidad < 100) {
            for(int i = this.cantidad; i > 0; --i) {
                this.datos[i] = this.datos[i - 1];
            }

            this.datos[0] = x;
            ++this.cantidad;
        }

    }

    public void Desapilar() {
        if (!this.PilaVacia()) {
            for(int i = 0; i < this.cantidad - 1; ++i) {
                this.datos[i] = this.datos[i + 1];
            }

            --this.cantidad;
        }

    }

    public int Tope() {
        return this.datos[0];
    }

    public boolean PilaVacia() {
        return this.cantidad == 0;
    }
}
