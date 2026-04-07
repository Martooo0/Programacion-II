package sources.Implementacion;

import sources.Interfaces.DiccionarioMultipleTDA;

/**
 * Implementación de Diccionario Múltiple (TDA) utilizando una matriz para valores.
 * * Estrategia de diseño:
 * Utiliza un arreglo para las claves y una matriz (int[][]) donde cada fila 
 * corresponde a una clave, permitiendo almacenar múltiples valores por cada una. 
 * Se apoya en un arreglo auxiliar (cantValores) para gestionar cuántos valores 
 * tiene cada clave y aplica "Swap with last" para eliminaciones en O(1).
 * * Ventajas:
 * Acceso directo a los valores de una clave mediante índices de fila, evitando 
 * estructuras dinámicas complejas.
 * * Desventajas:
 * Consumo de memoria elevado y fijo (estático). La matriz reserva espacio para 
 * el máximo de valores en todas las filas, incluso si las claves tienen pocos valores.
 */
public class DiccionarioMultipleEstatico implements DiccionarioMultipleTDA {
    private static final int MAX_CLAVES = 100;
    private static final int MAX_VALORES = 100;
    
    private int[] claves;
    private int[][] valores;
    private int[] cantValores;
    private int cantidadClaves;

    @Override
    public void InicializarDiccionario() {
        claves = new int[MAX_CLAVES];
        valores = new int[MAX_CLAVES][MAX_VALORES];
        cantValores = new int[MAX_CLAVES];
        cantidadClaves = 0;
    }

    @Override
    public void Agregar(int clave, int valor) {
        int posClave = buscarClave(clave);
        
        // Si la clave no existe, la creamos
        if (posClave == -1) {
            if (cantidadClaves < MAX_CLAVES) {
                claves[cantidadClaves] = clave;
                valores[cantidadClaves][0] = valor;
                cantValores[cantidadClaves] = 1;
                cantidadClaves++;
            }
        } 
        // Si existe, verificamos que el valor no esté duplicado y que haya espacio
        else if (!existeValor(posClave, valor) && cantValores[posClave] < MAX_VALORES) {
            int posLibre = cantValores[posClave];
            valores[posClave][posLibre] = valor;
            cantValores[posClave]++;
        }
    }

    @Override
    public void EliminarValor(int clave, int valor) {
        int posClave = buscarClave(clave);
        if (posClave != -1) {
            int posValor = buscarValor(posClave, valor);
            if (posValor != -1) {
                // Swap with last dentro de la fila de valores
                int ultimoIndice = cantValores[posClave] - 1;
                valores[posClave][posValor] = valores[posClave][ultimoIndice];
                cantValores[posClave]--;

                // Si la clave se quedó sin valores, eliminamos la clave por completo
                if (cantValores[posClave] == 0) {
                    Eliminar(clave);
                }
            }
        }
    }

    @Override
    public void Eliminar(int clave) {
        int posClave = buscarClave(clave);
        if (posClave != -1) {
            int ultimo = cantidadClaves - 1;
            
            // Reemplazamos la clave eliminada por la última de la lista
            claves[posClave] = claves[ultimo];
            cantValores[posClave] = cantValores[ultimo];

            // IMPORTANTE: Mover la fila completa de valores del último al lugar del eliminado
            for (int i = 0; i < cantValores[posClave]; i++) {
                valores[posClave][i] = valores[ultimo][i];
            }

            cantidadClaves--;
        }
    }

    @Override
    public int[] Recuperar(int clave) {
        int posClave = buscarClave(clave);
        if (posClave == -1) {
            return new int[0];
        }

        // Creamos un arreglo del tamaño exacto de valores que tiene la clave
        int total = cantValores[posClave];
        int[] aux = new int[total];
        for (int i = 0; i < total; i++) {
            aux[i] = valores[posClave][i];
        }
        return aux;
    }

    @Override
    public int[] Claves() {
        int[] aux = new int[cantidadClaves];
        for (int i = 0; i < cantidadClaves; i++) {
            aux[i] = claves[i];
        }
        return aux;
    }

    // --- Métodos Privados de Búsqueda ---

    private int buscarClave(int clave) {
        int i;
        for (i = 0; i < cantidadClaves && claves[i] != clave; i++) { }
        return (i < cantidadClaves) ? i : -1;
    }

    private int buscarValor(int posClave, int valor) {
        int i;
        int totalValores = cantValores[posClave];
        for (i = 0; i < totalValores && valores[posClave][i] != valor; i++) { }
        return (i < totalValores) ? i : -1;
    }

    private boolean existeValor(int posClave, int valor) {
        return buscarValor(posClave, valor) != -1;
    }
}
