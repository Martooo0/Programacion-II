package clase5;
import sources.implementacionDinamica.colaDinamica.ColaDinamica;

public class mainClase5 {
    public static void main(String[] args) {

        // ####### BLOQUE 1 #######
        ColaDinamica colaDinamica = new ColaDinamica();
        colaDinamica.InicializarCola();

        int googlecom = 1;
        int fiubaar = 2;
        int stackoverflowcom = 3;

        colaDinamica.Acolar(googlecom); // https://www.google.com/
        colaDinamica.Acolar(fiubaar); // https://www.fi.uba.ar/
        colaDinamica.Desacolar();
        colaDinamica.Acolar(stackoverflowcom); //
    }
}
