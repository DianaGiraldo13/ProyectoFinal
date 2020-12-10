package co.diana.proyectofinal;

public class Donacion {
    protected String idusuario;
    protected String id;
    protected String Tipo;
    protected int cantidad;
    protected String direccion;
    protected String estado;
    protected String nombre;

    public Donacion(String idusuario,String nombre, String id, String tipo, int cantidad, String direccion, String estado) {
        this.idusuario = idusuario;
        this.id = id;
        Tipo = tipo;
        this.cantidad = cantidad;
        this.direccion = direccion;
        this.estado = estado;
        this.nombre=nombre;
    }
    public Donacion(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
}

