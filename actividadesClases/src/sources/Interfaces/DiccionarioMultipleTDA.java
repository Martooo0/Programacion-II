package sources.Interfaces;

public interface DiccionarioMultipleTDA {
    void InicializarDiccionario();

    void Agregar(int var1, int var2);

    void EliminarValor(int var1, int var2);

    void Eliminar(int var1);

    int[] Recuperar(int var1);

    int[] Claves();
}
