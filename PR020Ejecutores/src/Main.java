/**
 * Created by Usuario on 16/11/2015.
 */
public class Main {
    /* Haciendo uso de un ejecutor simular la entrada de 50 clientes a un teatro donde
    cada 1 de los clientes deben ser acomodados en su butaca por un acomodador.
    Realizar el ejercicio de dos maneras distintas suponiendo que:
        El teatro pudede disponer de un numero infinito de acomodadores
        El teatro puede disponer como maximo de 3 acomodadores
    */
    public static void main(String[] args) {
        Teatro teatro = new Teatro();

        for (int i = 0; i < 40; i++) {
            Cliente cliente=new Cliente("Cliente "+i);
            teatro.sentar(cliente);
        }
        teatro.cerrar();
    }
}
