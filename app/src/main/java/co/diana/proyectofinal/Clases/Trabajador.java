package co.diana.proyectofinal.Clases;

public class Trabajador {

    String categoria;
    String cedula;
    int cobro;
    String direccion;
    String estado;
    String id;
    String nombre;
    String telefono;

    public Trabajador(String categoria, String cedula, int cobro, String direccion, String estado, String id, String nombre, String telefono) {
        this.categoria = categoria;
        this.cedula = cedula;
        this.cobro = cobro;
        this.direccion = direccion;
        this.estado = estado;
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Trabajador() {
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getCobro() {
        return cobro;
    }

    public void setCobro(int cobro) {
        this.cobro = cobro;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
