package clase6;
import sources.interfaces.ColaPrioridadTDA;

public class practicaColaPrioridad implements ColaPrioridadTDA {
    int cantidad;
    int[] datos;
    int[] prioridades;

    @Override
    public void InicializarColaPrioridad() {
        datos = new int[100];
        prioridades = new int[100];
        cantidad = 0;
    }

    @Override
    public void AcolarPrioridad(int numero, int prioridad) {
        int i;
        for ( i = cantidad-1 ; i >= 0 && prioridades[i] < prioridad ; --i ) {
            prioridades [i+1] = prioridades [i];
            datos [i+1] = datos [i];
        }
        prioridades [i+1] = prioridad;
        datos [i+1] = numero;
        ++cantidad;
    }

    @Override
    public void Desacolar() {
        for ( int i = 0 ; i < cantidad-1 ; ++i ) {
            datos [i] = datos [i+1];
            prioridades [i] = prioridades [i+1];
        }
        cantidad--;
    }

    @Override
    public boolean ColaVacia() {
        return false;
    }

    @Override
    public int Primero() {
        return 0;
    }

    @Override
    public int Prioridad() {
        return 0;
    }
}
