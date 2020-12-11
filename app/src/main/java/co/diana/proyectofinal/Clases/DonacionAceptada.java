package co.diana.proyectofinal.Clases;

public class DonacionAceptada {

    int cantidad;
    String estado;
    String id;
    String idusuario;

    public DonacionAceptada(int cantidad, String estado, String id, String idusuario) {
        this.cantidad = cantidad;
        this.estado = estado;
        this.id = id;
        this.idusuario = idusuario;
    }

    public DonacionAceptada() {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }
}
