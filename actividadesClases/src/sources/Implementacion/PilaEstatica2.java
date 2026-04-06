package sources.Implementacion;

import sources.Interfaces.PilaTDA;

public class PilaEstatica2 implements PilaTDA {
    private int[] datos;

    @Override
    public void InicializarPila() {
        this.datos = new int[101]; 
        this.datos[0] = 0;
    }

    @Override
    public void Apilar(int x) {
        if (this.datos[0] < 100) {
            this.datos[0]++;
            this.datos[this.datos[0]] = x;
        }
    }

    @Override
    public void Desapilar() {
        if (!this.PilaVacia()) {
            this.datos[0]--;
        }
    }

    @Override
    public int Tope() {
        return this.datos[this.datos[0]];
    }

    @Override
    public boolean PilaVacia() {
        return this.datos[0] == 0;
    }
}
