package sources.Implementacion;

import sources.Interfaces.PilaTDA;

public class PilaEstatica2 implements PilaTDA {
    private static final int MAX = 100;
    private int[] datos;

    public void InicializarPila() {
        this.datos = new int[101];
        this.datos[0] = 0;
    }

    public void Apilar(int x) {
        if (this.datos[0] < 100) {
            int var10002 = this.datos[0]++;
            this.datos[this.datos[0]] = x;
        }

    }

    public void Desapilar() {
        if (!this.PilaVacia()) {
            int var10002 = this.datos[0]--;
        }

    }

    public int Tope() {
        return this.datos[this.datos[0]];
    }

    public boolean PilaVacia() {
        return this.datos[0] == 0;
    }
}
