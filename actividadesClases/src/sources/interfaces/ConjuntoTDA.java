package sources.interfaces;

public interface ConjuntoTDA {
    void InicializarConjunto();

    void Agregar(int valor);

    void Sacar(int valor);

    boolean ConjuntoVacio();

    boolean Pertenece(int valor);

    int Elegir();
}
