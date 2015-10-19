/**
 * Created by Usuario on 19/10/2015.
 */
public class Main {
    public static void main(String[] args) {
        Pila limpios=new Pila();
        Pila secos=new Pila();
        Thread pedro=new Thread(new Limpia(limpios));
        Thread juan=new Thread(new Seca(limpios,secos));
        Thread antonio=new Thread(new Guarda(secos));

        pedro.start();
        juan.start();
        antonio.start();
    }
}
