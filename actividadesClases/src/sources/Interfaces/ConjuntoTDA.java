package sources.Interfaces;

public interface ConjuntoTDA {
    void InicializarConjunto();

    void Agregar(int var1);

    void Sacar(int var1);

    boolean ConjuntoVacio();

    boolean Pertenece(int var1);

    int Elegir();
}
