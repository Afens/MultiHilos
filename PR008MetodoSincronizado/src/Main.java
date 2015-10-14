/**
 * Created by Usuario on 14/10/2015.
 */
public class Main {
    public static void main(String[] args) {
        Cuenta cuenta=new Cuenta();
        Thread h1=new Thread(new Banco(cuenta));
        Thread h2=new Thread(new Empresa(cuenta));

        h1.start();
        h2.start();
    }
}
