package afens.pr041firebase;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Usuario on 10/02/2016.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
