package afens.pr034retrofit;

/**
 * Created by Usuario on 28/01/2016.
 */
public class Alumno {

    private Boolean repetidor;

    private Integer edad;

    private String direccion;

    private String telefono;

    private String curso;

    private String nombre;

    private String foto;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Alumno withId(Integer id) {
        this.id = id;
        return this;
    }

    public Boolean getRepetidor() {
        return repetidor;
    }


    public void setRepetidor(Boolean repetidor) {
        this.repetidor = repetidor;
    }

    public Alumno withRepetidor(Boolean repetidor) {
        this.repetidor = repetidor;
        return this;
    }


    public Integer getEdad() {
        return edad;
    }


    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Alumno withEdad(Integer edad) {
        this.edad = edad;
        return this;
    }


    public String getDireccion() {
        return direccion;
    }


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Alumno withDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }


    public String getTelefono() {
        return telefono;
    }


    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Alumno withTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }


    public String getCurso() {
        return curso;
    }


    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Alumno withCurso(String curso) {
        this.curso = curso;
        return this;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Alumno withNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getFoto() {
        return foto;
    }


    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Alumno withFoto(String foto) {
        this.foto = foto;
        return this;
    }

}