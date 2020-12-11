package co.diana.proyectofinal.Clases;

public class User {

    String nombre;
    String correo;
    String password;
    String id;

    public User(String id, String nombre, String correo, String password ) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;

    }

    public User() {
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
