package sources.Implementacion;

import sources.Interfaces.DiccionarioSimpleTDA;

public class DiccionarioSimpleEstatico implements DiccionarioSimpleTDA {
    private static final int MAX = 100;
    private int[] claves;
    private int[] valores;
    private int cantidad;

    public void InicializarDiccionario() {
        this.claves = new int[100];
        this.valores = new int[100];
        this.cantidad = 0;
    }

    public void Agregar(int clave, int valor) {
        int i;
        for(i = 0; i < this.cantidad && this.claves[i] != clave; ++i) {
        }

        if (i < this.cantidad) {
            this.valores[i] = valor;
        } else if (this.cantidad < 100) {
            this.claves[this.cantidad] = clave;
            this.valores[this.cantidad] = valor;
            ++this.cantidad;
        }

    }

    public void Eliminar(int clave) {
        int i;
        for(i = 0; i < this.cantidad && this.claves[i] != clave; ++i) {
        }

        if (i < this.cantidad) {
            this.claves[i] = this.claves[this.cantidad - 1];
            this.valores[i] = this.valores[this.cantidad - 1];
            --this.cantidad;
        }

    }

    public int[] Claves() {
        int[] aux = new int[this.cantidad];

        for(int i = 0; i < this.cantidad; ++i) {
            aux[i] = this.claves[i];
        }

        return aux;
    }
}
