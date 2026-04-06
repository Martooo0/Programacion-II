package sources.Implementacion;

import sources.Interfaces.DiccionarioMultipleTDA;

public class DiccionarioMultipleEstatico implements DiccionarioMultipleTDA {
    private static final int MAX_CLAVES = 100;
    private static final int MAX_VALORES = 100;
    private int[] claves;
    private int[][] valores;
    private int[] cantValores;
    private int cantidadClaves;

    public void InicializarDiccionario() {
        this.claves = new int[100];
        this.valores = new int[100][100];
        this.cantValores = new int[100];
        this.cantidadClaves = 0;
    }

    public void Agregar(int clave, int valor) {
        int posClave = this.buscarClave(clave);
        if (posClave == -1) {
            if (this.cantidadClaves < 100) {
                this.claves[this.cantidadClaves] = clave;
                this.valores[this.cantidadClaves][0] = valor;
                this.cantValores[this.cantidadClaves] = 1;
                ++this.cantidadClaves;
            }
        } else if (!this.existeValor(posClave, valor) && this.cantValores[posClave] < 100) {
            this.valores[posClave][this.cantValores[posClave]] = valor;
            int var10002 = this.cantValores[posClave]++;
        }

    }

    public void EliminarValor(int clave, int valor) {
        int posClave = this.buscarClave(clave);
        if (posClave != -1) {
            int posValor = this.buscarValor(posClave, valor);
            if (posValor != -1) {
                this.valores[posClave][posValor] = this.valores[posClave][this.cantValores[posClave] - 1];
                int var10002 = this.cantValores[posClave]--;
                if (this.cantValores[posClave] == 0) {
                    this.Eliminar(clave);
                }
            }
        }

    }

    public void Eliminar(int clave) {
        int posClave = this.buscarClave(clave);
        if (posClave != -1) {
            this.claves[posClave] = this.claves[this.cantidadClaves - 1];
            this.cantValores[posClave] = this.cantValores[this.cantidadClaves - 1];

            for(int i = 0; i < this.cantValores[posClave]; ++i) {
                this.valores[posClave][i] = this.valores[this.cantidadClaves - 1][i];
            }

            --this.cantidadClaves;
        }

    }

    public int[] Recuperar(int clave) {
        int posClave = this.buscarClave(clave);
        if (posClave == -1) {
            return new int[0];
        } else {
            int[] aux = new int[this.cantValores[posClave]];

            for(int i = 0; i < this.cantValores[posClave]; ++i) {
                aux[i] = this.valores[posClave][i];
            }

            return aux;
        }
    }

    public int[] Claves() {
        int[] aux = new int[this.cantidadClaves];

        for(int i = 0; i < this.cantidadClaves; ++i) {
            aux[i] = this.claves[i];
        }

        return aux;
    }

    private int buscarClave(int clave) {
        int i;
        for(i = 0; i < this.cantidadClaves && this.claves[i] != clave; ++i) {
        }

        return i < this.cantidadClaves ? i : -1;
    }

    private int buscarValor(int posClave, int valor) {
        int i;
        for(i = 0; i < this.cantValores[posClave] && this.valores[posClave][i] != valor; ++i) {
        }

        return i < this.cantValores[posClave] ? i : -1;
    }

    private boolean existeValor(int posClave, int valor) {
        return this.buscarValor(posClave, valor) != -1;
    }
}
