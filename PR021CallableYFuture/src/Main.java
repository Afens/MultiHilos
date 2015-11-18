import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by Usuario on 16/11/2015.
 */
public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        ArrayList<Future<Integer>> resultados = new ArrayList<>();
        Random rnd = new Random();
        Integer[] numeros = new Integer[10];
        for (int i = 0; i < 10; i++) {
            numeros[i] = new Integer(rnd.nextInt(10));
            CalculadorFactorial factorial = new CalculadorFactorial(numeros[i]);
            resultados.add(executor.submit(factorial));
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < resultados.size(); i++) {
            try {
                System.out.printf("Tarea %d -> Factorial de %d = %d\n", i, numeros[i], resultados.get(i).get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
