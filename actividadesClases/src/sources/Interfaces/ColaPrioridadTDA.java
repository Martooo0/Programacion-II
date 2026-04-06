package sources.Interfaces;

public interface ColaPrioridadTDA {
    void InicializarColaPrioridad();

    void AcolarPrioridad(int var1, int var2);

    void Desacolar();

    boolean ColaVacia();

    int Primero();

    int Prioridad();
}
