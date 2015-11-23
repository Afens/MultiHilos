import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by Usuario on 23/11/2015.
 */
public class TR extends FutureTask<Integer> {


    public TR(Callable<Integer> callable) {
        super(callable);
    }

    @Override
    protected void done() {
        try {
            System.out.println(get()*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
