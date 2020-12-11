package co.diana.proyectofinal;

public class Donacion {
    protected String idusuario;
    protected String id;
    protected String Tipo;
    protected int cantidad;
    protected String estado;
    protected String nombre;
    protected String fecha;
    protected String hora;

    public Donacion() {
    }

    public Donacion(String idusuario, String id, String tipo, int cantidad, String estado, String nombre, String fecha, String hora) {
        this.idusuario = idusuario;
        this.id = id;
        Tipo = tipo;
        this.cantidad = cantidad;
        this.estado = estado;
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
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


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}

