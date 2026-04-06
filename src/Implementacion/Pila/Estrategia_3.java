package Implementacion.Pila;

import Interface.PilaTDA;

public class Estrategia_3 implements PilaTDA {

    private static final int MAX = 100;
    private int[] datos;

    @Override
    public void InicializarPila() {
        datos = new int[MAX + 1];
        datos[0] = 0; // en la posición 0 se guarda la cantidad de elementos
    }

    @Override
    public void Apilar(int x) {
        if (datos[0] < MAX) {
            datos[0]++;
            datos[datos[0]] = x;
        }
    }

    @Override
    public void Desapilar() {
        if (!PilaVacia()) {
            datos[0]--;
        }
    }

    @Override
    public int Tope() {
        return datos[datos[0]];
    }

    @Override
    public boolean PilaVacia() {
        return datos[0] == 0;
    }
}
