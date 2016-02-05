package afens.pr034retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Instituto.InstitutoInterface servicio;
    private Call<List<Alumno>> llamada;
    private TextView lbl;
    private Button button;
    private Call<Alumno> creacion;
    private Button button2;
    private Call<String> a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lbl= (TextView) findViewById(R.id.lbl);
        button= (Button) findViewById(R.id.button);
        button2= (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alumno a=new Alumno();
                a.setCurso("1");
                a.setNombre("Baldomero2");
                a.setRepetidor(true);
                a.setDireccion("des");
                a.setTelefono("+13");
                a.setFoto("ss");
                creacion=servicio.crearAlumno(a);
                creacion.enqueue(new Callback<Alumno>() {
                    @Override
                    public void onResponse(Response<Alumno> response) {

                        lbl.setText(response.body().getId()+"");
                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                });
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                a=servicio.borrarAlumno(35);
                a.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Response<String> response) {
                        lbl.setText(response.body());
                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                });
            }
        });

        servicio=Instituto.getServicio();
        llamada=servicio.listarAlumnos();
        llamada.enqueue(new Callback<List<Alumno>>() {
            @Override
            public void onResponse(Response<List<Alumno>> response) {
                List<Alumno> list=response.body();
                lbl.setText(list.get(5).getNombre());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });



    }
}
