import java.util.concurrent.Callable;

/**
 * Created by Usuario on 23/11/2015.
 */
public class Tarea implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum=0;
        for (int i = 1; i <= 5; i++) {
            sum+=i;
        }
        return sum;
    }
}
