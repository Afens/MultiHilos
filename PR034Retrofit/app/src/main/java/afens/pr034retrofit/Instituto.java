package afens.pr034retrofit;

import android.app.Application;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import java.util.List;


import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Usuario on 28/01/2016.
 */
public class Instituto extends Application {
    private static final String BASE_URL = "http://10.0.3.2:3000/";
    private static InstitutoInterface servicio;

    public static InstitutoInterface getServicio() {
        return servicio;
    }

    public interface InstitutoInterface {
        @GET("alumnos")
        Call<List<Alumno>> listarAlumnos();
        @POST("alumnos")
        Call<Alumno> crearAlumno(@Body Alumno alumno);
        @DELETE("alumnos/{id}")
        Call<String> borrarAlumno(@Path("id") int id);
        @DELETE("alumnos/{id}")
        Call<Alumno> editarAlumno(@Path("id") int id, @Body Alumno alumno);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        servicio = retrofit.create(InstitutoInterface.class);

    }

}
