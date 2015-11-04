/**
 * Created by Usuario on 04/11/2015.
 */
public class Trabajo implements Runnable {
    // Cola de impresi�n.
    private ColaImpresion colaImpresion;

    // Constructor.
    public Trabajo(ColaImpresion colaImpresion){
        this.colaImpresion = colaImpresion;
    }

    @Override
    public void run() {
        // Mando a imprimir un documento.
        colaImpresion.imprimir(new Object());
    }
}
