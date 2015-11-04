/**
 * Created by Usuario on 04/11/2015.
 */
public class Main {
    public static void main(String[] args) {
        // Creo una videoconferencia para 10 participantes.
        Videoconferencia videoconferencia = new Videoconferencia(10);
        // Creo e inicio un hilo para la videoconferencia.
        Thread hiloVideoconferencia = new Thread(videoconferencia);
        hiloVideoconferencia.start();
        // Creo e inicio un hilo para cada uno de los diez participantes.
        for (int i = 0; i < 5; i++) {
            Thread hiloParticipante = new Thread(new Equipo(videoconferencia, "Equipo: " + i,i+1));
            hiloParticipante.start();
        }
    }
}
